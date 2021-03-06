package com.qiumingjie.service;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.info.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.info.PatientInfoRepository;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:37
 * @description
 */
@Service
@Slf4j
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
    public JsonHandler saveOrUpdateNew(FormTemplateDto formValues) throws Exception {
        JpaRepository repository = repositoryContext.getRepository(formValues.getTemplateFormId());
        FormMain formMain;
        Boolean firstCreate;
        if (CommonUtils.empty(formValues.getFormId())) {
            firstCreate = true;
            //不存在formId则是新建操作！
            if (CommonUtils.empty(formValues.getTemplateFormId())) {
                return JsonHandler.fail("新建表单失败：获取模板表单id失败");
            }
            Optional<FormDict> formDict = formDictService.existFormDict(formValues.getTemplateFormId());
            if (!formDict.isPresent()) {
                return JsonHandler.fail("新建表单失败：表单模板不存在");
            }
            List<FormMain> formMainByTemplateIdLike = formMainRepository.findFormMainBytemplateIdLike(formValues.getTemplateFormId());
            if (CommonUtils.empty(formMainByTemplateIdLike) || formMainByTemplateIdLike.size() == 0) {
                formValues.setFormId(FormUtil.caculFormEntityId(formValues.getTemplateFormId()));
            } else {
                formValues.setFormId(FormUtil.caculFormEntityId(formMainByTemplateIdLike.get(0).getFormId()));
            }
             formMain = CopyUtils.transfer(formValues, new FormMain());
            //一开始设置为未归档未签名
            formMain.setArchiveFlag(false);
            formMain.setSignFlag(false);
            //签名部分
        }else {
            firstCreate = false;
            if (!formMainRepository.findById(formValues.getFormId()).isPresent()) {
                Validate.error("表单不存在");
            }
            formMain = formMainRepository.findById(formValues.getFormId()).get();
            if (formMain.getArchiveFlag()) {
                return JsonHandler.fail("表单已经归档，请取消归档后再取消签名再修改");
            }
        }
        //更新formMain表
        formMainRepository.save(formMain);
        //更新签名表中
        signService.saveOrUpdateSign(formMain.getFormId(), new ArrayList<>(formValues.getSignList().values()),firstCreate);
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
        Optional<FormMain> formMainOptional = formMainRepository.findById(formId);
        if (!formMainOptional.isPresent()) {
            Validate.error("主表中无表单记录，表单不存在");
        }
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(formId));
        Optional<FormTemplate> formTemplateOptional = repository.findById(formId);
        if (formTemplateOptional.isPresent()) {
            if (CommonUtils.empty(formTemplateOptional.get().getPatientId())) {
                Validate.error("获取病人id失败，请联系管理员");
            }
            FormTemplateDto formTemplateDto = new FormTemplateDto();
            BeanUtils.copyProperties(formTemplateOptional.get(), formTemplateDto);
            //判断有无手术信息，返回
            if (CommonUtils.notEmpty(formTemplateOptional.get().getOperationId())) {
                Optional<OpsQueue> operation = opsQueueRepository.findById(formTemplateOptional.get().getOperationId());
                if (operation.isPresent()) {
                    formTemplateDto.setOperation(operation.get());
                    if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                        if (patientInfoRepository.findById(operation.get().getPatientId()).isPresent()) {
                            formTemplateDto.setPatientInfo(patientInfoRepository.findById(operation.get().getPatientId()).get());
                        }
                    }
                }
            }
            formTemplateDto.setSignList(signService.getSignMap(formId));
            formTemplateDto.setArchiveFlag(formMainOptional.get().getArchiveFlag());
            formTemplateDto.setSignFlag(formMainOptional.get().getSignFlag());
            return formTemplateDto;
        } else {
            return null;
        }
    }




}
