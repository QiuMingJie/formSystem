package com.qiumingjie.controller;

import com.qiumingjie.dao.OpsQueueRepository;
import com.qiumingjie.dao.PatientInfoRepository;
import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.table.FormValuesRepository;
import com.qiumingjie.dto.FormValuesDto;
import com.qiumingjie.dto.PatientAndOperationInfoDto;
import com.qiumingjie.entities.OpsQueue;
import com.qiumingjie.entities.evaluate.table.FormValues;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
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

    @Autowired
    FormValuesService formValuesService;

    @Autowired
    FormValuesRepository formValuesRepository;

    @Autowired
    FormDictRepository formDictRepository;

    @Autowired
    PatientInfoRepository patientInfoRepository;

    @Autowired
    OpsQueueRepository opsQueueRepository;


    /**
     * 根据表单id获取表单
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getFormNew", method = RequestMethod.GET)
    public JsonHandler getFormNew(String id) {
        Optional<FormValues> byId = formValuesService.getById(id);
        if (byId.isPresent()) {
            if (CommonUtils.empty(byId.get().getOperationId())) {
                return JsonHandler.fail("获取手术id失败，请联系管理员");
            }
            FormValuesDto formValuesDto=new FormValuesDto();
            BeanUtils.copyProperties(byId.get(), formValuesDto);
            Optional<OpsQueue> operation = opsQueueRepository.findById(byId.get().getOperationId());
            if (operation.isPresent()) {
                formValuesDto.setOperation(operation.get());
                if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                    if (patientInfoRepository.findById(operation.get().getPatientId()).isPresent()) {
                        formValuesDto.setPatientInfo(patientInfoRepository.findById(operation.get().getPatientId()).get());
                    }
                }
            }
            return JsonHandler.succeed(formValuesDto);

        }else {
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
    public JsonHandler saveOrUpdateNew(@RequestBody @Validated FormValues formValues) {
        if (CommonUtils.empty(formValues.getTemplateFormId()) && CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("模板表不存在或获取表失败");
        }
        if (CommonUtils.empty(formValues.getTemplateFormId())) {
            formValues.setTemplateFormId(FormUtil.getFormDictId(formValues.getFormId()));
        }
        if (!opsQueueRepository.findById(formValues.getOperationId()).isPresent()) {
            return JsonHandler.fail("手术基本信息不存在");
        }else {
            formValues.setPatientId(opsQueueRepository.findById(formValues.getOperationId()).get().getPatientId());
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
    public JsonHandler deleteFormNew(@RequestBody FormValues formValues) {
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
        List<FormValuesDto> result=new ArrayList<>();
        List<FormValues> formValuesList = formValuesRepository.findAllByPatientId(patientId);
        for (FormValues formValues : formValuesList) {
            FormValuesDto formValuesDto=new FormValuesDto();
            BeanUtils.copyProperties(formValues,formValuesDto);
            result.add(formValuesDto);
        }
        for (FormValuesDto formValues : result) {
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
    public JsonHandler getAllFormNew( String patientId, String operationId) {
        if (CommonUtils.empty(patientId)||CommonUtils.empty(operationId)) {
            return JsonHandler.fail("患者id或者手术id不可以为空");
        }
        return JsonHandler.succeed(formValuesRepository.findAllByPatientIdAndOperationId(patientId, operationId));
    }



    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public JsonHandler getInfo(@RequestParam("operationId") String operationId) {
        if (CommonUtils.empty(operationId)) {
            return JsonHandler.fail("手术信息不可以为空");
        }
        PatientAndOperationInfoDto patientAndOperationInfoDto=new PatientAndOperationInfoDto();
        Optional<OpsQueue> operation = opsQueueRepository.findById(operationId.trim());
        if (operation.isPresent()) {
            patientAndOperationInfoDto.setOperationInfo(operation.get());
            if (CommonUtils.notEmpty(operation.get().getPatientId())) {
                patientInfoRepository.findById(operation.get().getPatientId()).ifPresent(patientInfo -> BeanUtils.copyProperties(patientInfo,patientAndOperationInfoDto));
            }
        }
        return JsonHandler.succeed(patientAndOperationInfoDto);
    }
}




















