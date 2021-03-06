package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.dict.FormDictRepository;
import com.qiumingjie.dao.formSystem.info.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.info.PatientInfoRepository;
import com.qiumingjie.dao.formSystem.info.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.FormTemplateDto;
import com.qiumingjie.dto.PatientAndOperationInfoDto;
import com.qiumingjie.entities.formSystem.evaluate.dict.FormDict;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormDictService;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.service.UserAndRoleService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api(description = "表单基本增删改操作")
@Slf4j
public class FormController {

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

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    private UserAndRoleService userAndRoleService;

    @Autowired
    private FormDictService formDictService;

    @RequestMapping(value = "/getFormNew", method = RequestMethod.GET)
    @ApiOperation("根据表单id获取表单")
    public JsonHandler getFormNew( String id)  {
        return JsonHandler.succeed(formValuesService.getForm(id));
    }



    @ApiOperation("保存或者更新表单")
    @RequestMapping(value = "/saveOrUpdateFormNew", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateNew(@RequestBody @Validated FormTemplateDto formValues) throws Exception {
        if (CommonUtils.empty(formValues.getOperationId()) || CommonUtils.empty(formValues.getUserId()) || CommonUtils.empty(formValues.getPatientId())) {
            return JsonHandler.fail(JsonHandler.fail("传入的手术id或者用户id或病人id为空", formValues));
        }
        if (CommonUtils.empty(formValues.getFormId()) && CommonUtils.empty(formValues.getTemplateFormId())) {
            return JsonHandler.fail(JsonHandler.fail("模板表不存在或获取表失败"));
        }
        if (CommonUtils.empty(formValues.getTemplateFormId())) {
            formValues.setTemplateFormId(FormUtil.getFormDictId(formValues.getFormId()));
        }
        if (!opsQueueRepository.findById(formValues.getOperationId()).isPresent()) {
            return JsonHandler.fail(JsonHandler.fail("手术基本信息不存在"));
        } else {
            //暂时取消
            if (!opsQueueRepository.findById(formValues.getOperationId()).get().getPatientId().equals(formValues.getPatientId())) {
                return JsonHandler.fail(JsonHandler.fail("此手术不是当前患者的手术", formValues));
            }
        }
        Optional<FormDict> formDictOptional = formDictRepository.findById(formValues.getTemplateFormId());
        if (formDictOptional.isPresent()) {
            formValues.setTemplateName(formDictOptional.get().getFormName());
        } else {
            return JsonHandler.fail(JsonHandler.fail("字典表不存在此表单"));
        }
        return JsonHandler.succeed(formValuesService.saveOrUpdateNew(formValues));
    }


    @ApiOperation("删除表单")
    @RequestMapping(value = "/deleteFormNew", method = RequestMethod.POST)
    public JsonHandler deleteFormNew(@RequestBody FormTemplateDto formValues) {
        if (CommonUtils.empty(formValues) || CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("删除表单为空");
        }
        formValuesService.deleteForm(formValues.getFormId());
        return JsonHandler.succeed();
    }


    @ApiOperation("根据病人id获取所有表单")
    @RequestMapping(value = "/getAllFormNew", method = RequestMethod.GET)
    public JsonHandler getAllFormNew(String patientId) {
        if (CommonUtils.empty(patientId)) {
            return JsonHandler.fail("患者基本信息不可以为空");
        }
        //这里可能需要优化
        List<FormTemplateDto> result = new ArrayList<>();
        List<FormMain> formValuesList = formMainRepository.findAllByPatientIdOrderByTemplateFormId(patientId);
        for (FormMain formValues : formValuesList) {
            result.add(formValuesService.getForm(formValues.getFormId()));
        }
        return JsonHandler.succeed(result);
    }


    @ApiOperation("根据病人id和手术id和用户id获取表单")
    @RequestMapping(value = "/getFormByPatientIdAndOpsQueueNew", method = RequestMethod.GET)
    public JsonHandler getAllFormNew(String patientId, String operationId, Integer userId) {
        List<FormTemplateDto> formTemplateDtoList = new ArrayList<>();
        if (CommonUtils.empty(patientId) || CommonUtils.empty(operationId)||CommonUtils.empty(userId)) {
            return JsonHandler.fail("患者id或者手术id不可以为空");
        }
        List<FormMain> allByPatientIdAndOperationId = formMainRepository.findAllByPatientIdAndOperationIdAndUserId(patientId, operationId,userId);
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




















