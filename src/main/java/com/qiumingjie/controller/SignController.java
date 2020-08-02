package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.DoctorInfoRepository;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.SignService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import io.swagger.annotations.ApiOperation;
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
    private DoctorInfoRepository doctorInfoRepository;

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;


    @ApiOperation("表单签名")
    @PostMapping("/signForm")
    public JsonHandler sign(@RequestBody Sign sign) throws IllegalAccessException, InstantiationException {
        if (CommonUtils.empty(sign.getFormId()) || CommonUtils.empty(sign.getSigner())) {
            return JsonHandler.fail("表单id和医生id不可为空，请联系管理员");
        }
        if (CommonUtils.empty(sign.getCertificate())) {
            return JsonHandler.fail("签名失败，获取医生证书失败");
        }

        UserInfo userInfo = new UserInfo();
        if (!doctorInfoRepository.findById(sign.getSigner()).isPresent()) {
            return JsonHandler.fail("获取医生信息出错");
        } else {
            userInfo = doctorInfoRepository.findById(sign.getSigner()).get();
        }
        sign.setSignerPhotoPath(userInfo.getUserSignPhoto());
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
//        if (CommonUtils.notEmpty(formTemplate.getAfterSignValue())) {
//            return JsonHandler.fail("此表单已经签名");
//        }
//        formTemplate.setAfterSignValue(SignUtils.init("").signData(formTemplate.getValue()));
//        formTemplate.setSignFlag(true);
        formMain.setSignFlag(true);
        return signService.sign(sign, formTemplate, formMain);
    }

//    @ApiOperation("取消签名")
//    @PostMapping("/cancelSign")
//    public JsonHandler cancelSign(@RequestBody Sign sign) throws IllegalAccessException, InstantiationException {
//        if (CommonUtils.empty(sign.getFormId()) || CommonUtils.empty(sign.getSigner())) {
//            return JsonHandler.fail("表单id和医生id不可为空，请联系管理员");
//        }
//        if (CommonUtils.empty(sign.getKey())) {
//            return JsonHandler.fail("签名失败，获取医生证书失败");
//        }
//        sign.setSignerPhotoPath(null);
//        FormTemplate formTemplate;
//        FormMain formMain;
//        Optional<FormMain> formMainOptional = formMainRepository.findById(sign.getFormId());
//        if (!formMainOptional.isPresent()) {
//            return JsonHandler.fail("表单不存在");
//        } else {
//            formMain = formMainOptional.get();
//            JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
//            formTemplate = (FormTemplate) repository.findById(sign.getFormId()).get();
//        }
////        formTemplate.setAfterSignValue("");
////        formTemplate.setSignFlag(false);
//        formMain.setSignFlag(false);
//        return signService.sign(sign, formTemplate, formMain);
//    }


}
