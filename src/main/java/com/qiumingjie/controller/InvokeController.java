package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.PatientInfoRepository;
import com.qiumingjie.dao.formSystem.UserInfoRepository;
import com.qiumingjie.dto.PatientAndOperationAndUserInfoDto;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.entities.formSystem.info.PatientInfo;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-26 13:49
 * @description
 */
@RestController
@RequestMapping("/invoke")
public class InvokeController {

    @Autowired
    private PatientInfoRepository patientInfoRepository;


    @Autowired
    private OpsQueueRepository opsQueueRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @ApiOperation("保存或者更新病人基本信息")
    @RequestMapping(value = "/saveOrUpdatePatientInfo", method = RequestMethod.POST)
    public JsonHandler savePatientInfo(PatientInfo patientInfo) {
        if (CommonUtils.empty(patientInfo.getPatientId())) {
            return JsonHandler.fail("id不可以为空");
        }
        return JsonHandler.succeed(patientInfoRepository.save(patientInfo));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @ApiOperation("获取病人基本信息")
    @RequestMapping(value = "/getPatientInfo", method = RequestMethod.GET)
    public JsonHandler getInfo(String id) {
        Optional<PatientInfo> byId = patientInfoRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }

    @ApiOperation("更新或者保存手机基本信息")
    @RequestMapping(value = "/saveOrUpdateOpsQueue", method = RequestMethod.POST)
    public JsonHandler saveOpsQueue(@Validated OpsQueue opsQueue) {
        return JsonHandler.succeed(opsQueueRepository.save(opsQueue));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @ApiOperation("获取手术基本信息")
    @RequestMapping(value = "/getOpsQueue", method = RequestMethod.GET)
    public JsonHandler getOpsQueue(String id) {
        Optional<OpsQueue> byId = opsQueueRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }


    @ApiOperation("更新或者保存医生基本信息")
    @RequestMapping(value = "/saveOrUpdateDoctorInfo", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateDoctorInfo(@Validated UserInfo userInfo) {
        return JsonHandler.succeed(userInfoRepository.save(userInfo));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @ApiOperation("获取医生基本信息")
    @RequestMapping(value = "/getDoctorInfo", method = RequestMethod.GET)
    public JsonHandler getDoctorInfo(String id) {
        Optional<UserInfo> byId = userInfoRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }

    @ApiOperation("获取所有病人信息，手术信息，用户信息")
    @PostMapping(value = "getPatientAndOperationAndUserInfo")
    public JsonHandler getPatientAndOperationAndUserInfo(String patientId, String operationId, String userId) {
        if (CommonUtils.empty(patientId) || CommonUtils.empty(userId)) {
            return JsonHandler.fail("病人id为空或用户id为空");
        }
        Optional<PatientInfo> patientInfoOptional = patientInfoRepository.findById(patientId);
        Optional<OpsQueue> opsQueueOptional = opsQueueRepository.findById(operationId);
        Optional<UserInfo> userInfoOptional = userInfoRepository.findById(userId);
        PatientAndOperationAndUserInfoDto patientAndOperationAndUserInfoDto = new PatientAndOperationAndUserInfoDto();
        patientInfoOptional.ifPresent(patientAndOperationAndUserInfoDto::setPatientInfo);
        opsQueueOptional.ifPresent(patientAndOperationAndUserInfoDto::setOpsQueue);
        userInfoOptional.ifPresent(patientAndOperationAndUserInfoDto::setUserInfo);
        return JsonHandler.succeed(patientAndOperationAndUserInfoDto);
    }
}
