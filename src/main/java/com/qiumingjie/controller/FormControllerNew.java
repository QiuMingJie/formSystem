package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.PatientInfoRepository;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.dict.FormDictRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.FormTemplateDto;
import com.qiumingjie.dto.PatientAndOperationInfoDto;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    private static final Logger logger = LoggerFactory.getLogger(FormControllerNew.class);
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
        return JsonHandler.succeed(formValuesService.getForm(id));
    }

    /**
     * 保存或者更新表单
     *
     * @param formValues
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateFormNew", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateNew(@RequestBody @Validated FormTemplateDto formValues) throws Exception {
        if (CommonUtils.empty(formValues.getFormId())&&CommonUtils.empty(formValues.getTemplateFormId())) {
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
    public JsonHandler deleteFormNew(@RequestBody FormTemplateDto formValues) {
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
//        for (FormTemplate formValues : formValuesList) {
//            result.add(formValuesService.getForm(formValues.getFormId()));
//        }
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
        List<FormTemplateDto> formTemplateDtoList = new ArrayList<>();
        if (CommonUtils.empty(patientId) || CommonUtils.empty(operationId)) {
            return JsonHandler.fail("患者id或者手术id不可以为空");
        }
        List<FormMain> allByPatientIdAndOperationId = formMainRepository.findAllByPatientIdAndOperationId(patientId, operationId);
        for (FormMain formMain : allByPatientIdAndOperationId) {
            formTemplateDtoList.add(formValuesService.getForm(formMain.getFormId()));
        }
        return JsonHandler.succeed(formTemplateDtoList);
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




















