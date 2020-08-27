package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.FormTemplateDto;
import com.qiumingjie.dto.SignDto;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.service.SignService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.SignUtils;
import com.qiumingjie.utils.Validate;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
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
    private UserInfoRepository userInfoRepository;

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    FormValuesService formValuesService;



    @ApiOperation("验证是否修改了表单中已经签名部分")
    @PostMapping("/checkValue")
    public JsonHandler checkValue(@RequestBody FormTemplateDto formValues) throws IllegalAccessException, InstantiationException {
        List<SignDto> signDtoList = new ArrayList<>(formValues.getSignList().values());
        return JsonHandler.succeed(signService.changeValue(signDtoList));
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

    @ApiOperation("取消签名")
    @PostMapping("/cancelSign")
    public JsonHandler cancelSign(@RequestBody Sign sign)  {
        if (CommonUtils.empty(sign.getSignId())) {
            return JsonHandler.fail("取消签名失败，signId为空");
        }
        Optional<Sign> signOptional = signRepository.findById(sign.getSignId());
        Sign sign1;
        if (!signOptional.isPresent()) {
            return JsonHandler.fail("取消签名失败，signId不存在");
        } else {
            sign1 = signOptional.get();
        }
        sign1.setSignFlag(false);
        sign1.setSignerPhoto(null);
        Optional<FormMain> formMain = formMainRepository.findById(sign1.getFormId());
        if (!formMain.isPresent()) {
            Validate.error("主表中无表单记录，表单不存在");
        } else {
            FormMain formMain1 = formMain.get();
            formMain1.setSignFlag(false);
            formMainRepository.save(formMain1);
        }
        signRepository.save(sign1);
        return JsonHandler.succeed(formValuesService.getForm(sign1.getFormId()));
    }


}
