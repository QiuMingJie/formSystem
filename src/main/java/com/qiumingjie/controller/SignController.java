package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.SignService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.SignUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    private UserInfoRepository userInfoRepository;

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;


    @ApiOperation("验证是否修改了表单中已经签名部分")
    @PostMapping("/checkValue")
    public JsonHandler checkValue(@RequestBody FormTemplate formTemplate) throws IllegalAccessException, InstantiationException {
        List<Sign> signs = signService.valueToList(formTemplate.getValue());
        String name = "";
        for (Sign sign : signs) {
            name = name + (CommonUtils.empty (signService.changeValue(sign)) ? "" : (signService.changeValue(sign))) + (" ");
        }
        if (CommonUtils.empty(name)) {
            return JsonHandler.succeed("未修改已签名的部分");
        }
        return JsonHandler.fail("已经修改了用户 " + name + "签名部分，保存则自动取消签名");
    }

    @ApiOperation("表单签名")
    @PostMapping("/signForm")
    public JsonHandler sign(@RequestBody Sign sign) throws Exception {
        if (CommonUtils.empty(sign.getSigner())) {
            return JsonHandler.fail("签名者ID为空");
        }
        if (CommonUtils.empty(sign.getCertificate())) {
            return JsonHandler.fail("证书为空");
        }
        //验证证书有效性
        if (!"1".equals(SignUtils.validateCert(sign.getCertificate()))) {
            return JsonHandler.fail(SignUtils.validateCert(sign.getCertificate()));
        }
        return signService.sign(sign.getSignId(),sign.getSigner(),sign.getCertificate());
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
