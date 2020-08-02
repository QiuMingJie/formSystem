package com.qiumingjie.service;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.PatientInfoRepository;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.FormTemplateDto;
import com.qiumingjie.entities.formSystem.evaluate.dict.FormDict;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import com.qiumingjie.utils.Validate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:37
 * @description
 */
@Service
public class FormValuesService {
    @Resource
    private RepositoryContext repositoryContext;

    @Resource
    private FormDictService formDictService;

    @Resource
    private FormMainRepository formMainRepository;

    @Autowired
    private OpsQueueRepository opsQueueRepository;

    @Autowired
    private PatientInfoRepository patientInfoRepository;

    @Autowired
    private SignRepository signRepository;

    @Autowired
    private SignService signService;

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler saveOrUpdateNew(FormTemplate formValues) throws Exception {
        JpaRepository repository = repositoryContext.getRepository(formValues.getTemplateFormId());
        FormMain formMain;
        if (CommonUtils.empty(formValues.getFormId())) {
            //不存在formId则是新建操作！
            if (CommonUtils.empty(formValues.getTemplateFormId())) {
                return JsonHandler.fail("新建表单失败：获取模板表单id失败");
            }
            Optional<FormDict> formDict = formDictService.existFormDict(formValues.getTemplateFormId());
            if (!formDict.isPresent()) {
                return JsonHandler.fail("新建表单失败：表单模板不存在");
            }
            //判断是否signId重复
            if (signService.repeatSignId(formValues.getValue())) {
                return JsonHandler.fail("新建表单失败：signId已经被其他表单使用");
            }
            //暂时不知道怎么获取创建者
//            formValues.setCreator("？？");
            List<FormMain> formMainBytemplateIdLike = formMainRepository.findFormMainBytemplateIdLike(formValues.getTemplateFormId());
            if (CommonUtils.empty(formMainBytemplateIdLike) || formMainBytemplateIdLike.size() == 0) {
                formValues.setFormId(FormUtil.caculFormEntityId(formValues.getTemplateFormId()));
            } else {
                formValues.setFormId(FormUtil.caculFormEntityId(formMainBytemplateIdLike.get(0).getFormId()));
            }
             formMain = CopyUtils.transfer(formValues, new FormMain());
            //一开始设置为未归档未签名
            formMain.setArchiveFlag(false);
            formMain.setSignFlag(false);
        }else {
            formMain = formMainRepository.findById(formValues.getFormId()).get();
            if (formMain.getArchiveFlag()) {
                return JsonHandler.fail("表单已经归档，请取消归档后再取消签名再修改");
            }
            if (formMain.getSignFlag()) {
                return JsonHandler.fail("表单已经签名，请取消签名后再修改");
            }
        }
        //更新formMain表
        formMainRepository.save(formMain);
        //更新签名表中
        signService.saveOrUpdateSign(formMain.getFormId(),formValues.getValue());
        repository.saveAndFlush(CopyUtils.formEntityTransfer(formValues, FormEnum.getEntityClazz(formValues)));
        return JsonHandler.succeed(getForm(formValues.getFormId()));
    }

    @Transactional
    public void deleteForm(String id) {
        if (CommonUtils.notEmpty(id)) {
            JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(id));
            repository.deleteById(id);
            formMainRepository.deleteById(id);
            signRepository.deleteAllByFormId(id);
        }
    }


    public FormTemplateDto getForm(String formId) {
        Optional<FormMain> formMain = formMainRepository.findById(formId);
        if (!formMain.isPresent()) {
            Validate.error("主表中无表单记录，表单不存在");
        }
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(formId));
        Optional<FormTemplate> formTemplate = repository.findById(formId);
        if (formTemplate.isPresent()) {
            if (CommonUtils.empty(formTemplate.get().getPatientId())) {
                Validate.error("获取病人id失败，请联系管理员");
            }
            FormTemplateDto formTemplateDto = new FormTemplateDto();
            BeanUtils.copyProperties(formTemplate.get(), formTemplateDto);
            //判断有无手术信息，返回
            if (CommonUtils.notEmpty(formTemplate.get().getOperationId())) {
                Optional<OpsQueue> operation = opsQueueRepository.findById(formTemplate.get().getOperationId());
                if (operation.isPresent()) {
                    formTemplateDto.setOperation(operation.get());
                    if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                        if (patientInfoRepository.findById(operation.get().getPatientId()).isPresent()) {
                            formTemplateDto.setPatientInfo(patientInfoRepository.findById(operation.get().getPatientId()).get());
                        }
                    }
                }
            }
            formTemplateDto.setSignList(signRepository.findAllByFormId(formId));
            formTemplateDto.setArchiveFlag(formMain.get().getArchiveFlag());
            formTemplateDto.setSignFlag(formMain.get().getSignFlag());
            return formTemplateDto;
        } else {
            return null;
        }
    }




}
