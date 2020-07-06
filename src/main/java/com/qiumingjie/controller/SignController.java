package com.qiumingjie.controller;

import com.qiumingjie.dao.DoctorRepository;
import com.qiumingjie.dao.RepositoryContext;
import com.qiumingjie.dao.SignRepository;
import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormTemplate;
import com.qiumingjie.entities.info.DoctorInfo;
import com.qiumingjie.entities.sign.Sign;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.SignService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import com.qiumingjie.utils.SignUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-07-01 9:32
 * @description
 */
@RestController
@RequestMapping("/sign")
public class SignController {

    @Autowired
    private SignService signService;

    @Autowired
    private SignRepository signRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;


    @PostMapping("/signForm")
    public JsonHandler sign(@RequestBody Sign sign) throws IllegalAccessException, InstantiationException {
        if (CommonUtils.empty(sign.getFormId()) || CommonUtils.empty(sign.getDoctorId())) {
            return JsonHandler.fail("表单id和医生id不可为空，请联系管理员");
        }
        if (CommonUtils.empty(sign.getKey())) {
            return JsonHandler.fail("签名失败，获取医生证书失败");
        }

        DoctorInfo doctorInfo = new DoctorInfo();
        if (!doctorRepository.findById(sign.getDoctorId()).isPresent()) {
            return JsonHandler.fail("获取医生信息出错");
        } else {
            doctorInfo = doctorRepository.findById(sign.getDoctorId()).get();
        }
        sign.setDoctorSignPhoto(doctorInfo.getDoctorSignPhoto());
        FormTemplate formTemplate;
        FormMain formMain;
        Optional<FormMain> formMainOptional = formMainRepository.findById(sign.getFormId());
        if (!formMainOptional.isPresent()) {
            return JsonHandler.fail("表单不存在");
        } else {
            formMain = formMainOptional.get();
            JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
            formTemplate = (FormTemplate) repository.findById(sign.getFormId()).get();
        }
        if (CommonUtils.notEmpty(formTemplate.getAfterSignValue())) {
            return JsonHandler.fail("此表单已经签名");
        }
        formTemplate.setAfterSignValue(SignUtils.init("").signData(formTemplate.getValue()));
        formTemplate.setSignFlag(true);
        formMain.setSignFlag(true);
        return signService.sign(sign, formTemplate, formMain);
    }

    @PostMapping("/cancelSign")
    public JsonHandler cancelSign(@RequestBody Sign sign) throws IllegalAccessException, InstantiationException {
        if (CommonUtils.empty(sign.getFormId()) || CommonUtils.empty(sign.getDoctorId())) {
            return JsonHandler.fail("表单id和医生id不可为空，请联系管理员");
        }
        if (CommonUtils.empty(sign.getKey())) {
            return JsonHandler.fail("签名失败，获取医生证书失败");
        }
        sign.setDoctorSignPhoto(null);
        FormTemplate formTemplate;
        FormMain formMain;
        Optional<FormMain> formMainOptional = formMainRepository.findById(sign.getFormId());
        if (!formMainOptional.isPresent()) {
            return JsonHandler.fail("表单不存在");
        } else {
            formMain = formMainOptional.get();
            JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
            formTemplate = (FormTemplate) repository.findById(sign.getFormId()).get();
        }
        formTemplate.setAfterSignValue("");
        formTemplate.setSignFlag(false);
        formMain.setSignFlag(false);
        return signService.sign(sign, formTemplate, formMain);
    }


}
