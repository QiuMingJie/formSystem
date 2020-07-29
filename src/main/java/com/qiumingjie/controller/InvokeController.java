package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.DoctorInfoRepository;
import com.qiumingjie.dao.formSystem.OpsQueueRepository;
import com.qiumingjie.dao.formSystem.PatientInfoRepository;
import com.qiumingjie.entities.formSystem.info.DoctorInfo;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.entities.formSystem.info.PatientInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    private DoctorInfoRepository doctorInfoRepository;

    /**
     * 病人基本信息
     * @param patientInfo
     * @return
     */
    @RequestMapping(value = "/saveOrUpdatePatientInfo", method = RequestMethod.POST)
    public JsonHandler savePatientInfo(PatientInfo patientInfo) {
        if (CommonUtils.empty(patientInfo.getPatientId())) {
            return JsonHandler.fail("id不可以为空");
        }
        return JsonHandler.succeed(patientInfoRepository.save(patientInfo));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @RequestMapping(value = "/getPatientInfo", method = RequestMethod.GET)
    public JsonHandler getInfo(String id) {
        Optional<PatientInfo> byId = patientInfoRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }

    /**
     * 手术基本信息
     *
     * @param opsQueue
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateOpsQueue", method = RequestMethod.POST)
    public JsonHandler saveOpsQueue(@Validated OpsQueue opsQueue) {
        return JsonHandler.succeed(opsQueueRepository.save(opsQueue));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @RequestMapping(value = "/getOpsQueue", method = RequestMethod.GET)
    public JsonHandler getOpsQueue(String id) {
        Optional<OpsQueue> byId = opsQueueRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }


    /**
     * 医生基本信息
     * @param doctorInfo
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateDoctorInfo", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateDoctorInfo(@Validated DoctorInfo doctorInfo) {
        return JsonHandler.succeed(doctorInfoRepository.save(doctorInfo));
//        return new JsonHandler("200", "http://122.51.171.14:8080/formweb/#/Index?patientInfo=" +.getId().toString(), patientInfo);
    }

    @RequestMapping(value = "/getDoctorInfo", method = RequestMethod.GET)
    public JsonHandler getDoctorInfo(String id) {
        Optional<DoctorInfo> byId = doctorInfoRepository.findById(id);
        if (byId.isPresent()) {
            return JsonHandler.succeed(byId.get());
        }
        return JsonHandler.fail("数据不存在");
    }


}
