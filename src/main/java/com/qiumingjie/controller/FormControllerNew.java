package com.qiumingjie.controller;

import com.qiumingjie.dao.OpsQueueRepository;
import com.qiumingjie.dao.PatientInfoRepository;
import com.qiumingjie.dao.RepositoryContext;
import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.dto.FormTemplateDto;
import com.qiumingjie.dto.PatientAndOperationInfoDto;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormTemplate;
import com.qiumingjie.entities.info.OpsQueue;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:33
 * @description *暴力存表发获取表单接口
 */
@RestController
@RequestMapping("/form")
public class FormControllerNew {

    @Autowired
    FormValuesService formValuesService;

    @Autowired
    FormDictRepository formDictRepository;

    @Autowired
    PatientInfoRepository patientInfoRepository;

    @Autowired
    OpsQueueRepository opsQueueRepository;


    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    FormMainRepository formMainRepository;


    /**
     * 根据表单id获取表单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getFormNew", method = RequestMethod.GET)

    public JsonHandler getFormNew(String id)  {
        String formDictId = FormUtil.getFormDictId(id);
        JpaRepository repository = repositoryContext.getRepository(formDictId);
        Optional<FormTemplate> byId = repository.findById(id);
        if (byId.isPresent()) {
            if (CommonUtils.empty(byId.get().getOperationId())) {
                return JsonHandler.fail("获取手术id失败，请联系管理员");
            }
            FormTemplateDto formTemplateDto = new FormTemplateDto();
            BeanUtils.copyProperties(byId.get(), formTemplateDto);
            Optional<OpsQueue> operation = opsQueueRepository.findById(byId.get().getOperationId());
            if (operation.isPresent()) {
                formTemplateDto.setOperation(operation.get());
                if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                    if (patientInfoRepository.findById(operation.get().getPatientId()).isPresent()) {
                        formTemplateDto.setPatientInfo(patientInfoRepository.findById(operation.get().getPatientId()).get());
                    }
                }
            }
            return JsonHandler.succeed(formTemplateDto);

        } else {
            return JsonHandler.fail("表单不存在");
        }
    }

    /**
     * 保存或者更新表单
     *
     * @param formValues
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateFormNew", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateNew(@RequestBody @Validated FormTemplate formValues) {
        if (CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("模板表不存在或获取表失败");
        }
        if (CommonUtils.empty(formValues.getTemplateFormId())) {
            formValues.setTemplateFormId(FormUtil.getFormDictId(formValues.getFormId()));
        }
        String operationId = formValues.getOperationId();
        if (CommonUtils.notEmpty(operationId)) {
            if (!opsQueueRepository.findById(formValues.getOperationId()).isPresent()) {
                return JsonHandler.fail("手术基本信息不存在");
            } else {
                formValues.setPatientId(opsQueueRepository.findById(formValues.getOperationId()).get().getPatientId());
            }
        }
        formValues.setTemplateName(formDictRepository.findById(formValues.getTemplateFormId()).get().getFormName());
        return JsonHandler.succeed(formValuesService.saveOrUpdateNew(formValues));
    }

    /**
     * 删除表单
     *
     * @param formValues
     * @return
     */
    @RequestMapping(value = "/deleteFormNew", method = RequestMethod.POST)
    public JsonHandler deleteFormNew(@RequestBody FormTemplate formValues) {
        if (CommonUtils.empty(formValues) || CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("删除表单为空");
        }
        formValuesService.deleteForm(formValues.getFormId());
        return JsonHandler.succeed();
    }

    /**
     * 根据病人id获取所有表单
     *
     * @param patientId
     * @return
     */
    @RequestMapping(value = "/getAllFormNew", method = RequestMethod.GET)
    public JsonHandler getAllFormNew(String patientId) {
        if (CommonUtils.empty(patientId)) {
            return JsonHandler.fail("患者基本信息不可以为空");
        }
        List<FormTemplateDto> result = new ArrayList<>();
        List<FormMain> formValuesList = formMainRepository.findAllByPatientId(patientId);
        for (FormTemplate formValues : formValuesList) {
            FormTemplateDto formTemplateDto = new FormTemplateDto();
            BeanUtils.copyProperties(formValues, formTemplateDto);
            result.add(formTemplateDto);
        }
        for (FormTemplateDto formValues : result) {
            if (CommonUtils.notEmpty(formValues.getOperationId())) {
                opsQueueRepository.findById(formValues.getOperationId()).ifPresent(formValues::setOperation);
                if (CommonUtils.notEmpty(formValues.getOperation().getPatientId())) {
                    patientInfoRepository.findById(formValues.getOperation().getPatientId()).ifPresent(formValues::setPatientInfo);
                }
            }
        }
        return JsonHandler.succeed(result);
    }

    /**
     * 根据病人id和手术id获取表单
     *
     * @param patientId
     * @param operationId
     * @return
     */
    @RequestMapping(value = "/getFormByPatientIdAndOpsQueueNew", method = RequestMethod.GET)
    public JsonHandler getAllFormNew(String patientId, String operationId) {
        if (CommonUtils.empty(patientId) || CommonUtils.empty(operationId)) {
            return JsonHandler.fail("患者id或者手术id不可以为空");
        }
        return JsonHandler.succeed(formMainRepository.findAllByPatientIdAndOperationId(patientId, operationId));
    }


    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public JsonHandler getInfo(@RequestParam("operationId") String operationId) {
        if (CommonUtils.empty(operationId)) {
            return JsonHandler.fail("手术信息不可以为空");
        }
        PatientAndOperationInfoDto patientAndOperationInfoDto = new PatientAndOperationInfoDto();
        Optional<OpsQueue> operation = opsQueueRepository.findById(operationId.trim());
        if (operation.isPresent()) {
            patientAndOperationInfoDto.setOperationInfo(operation.get());
            if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                patientInfoRepository.findById(operation.get().getPatientId()).ifPresent(patientInfo -> BeanUtils.copyProperties(patientInfo, patientAndOperationInfoDto));
            }
        }
        return JsonHandler.succeed(patientAndOperationInfoDto);
    }
}




















