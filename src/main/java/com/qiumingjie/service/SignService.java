package com.qiumingjie.service;

import com.alibaba.fastjson.JSON;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.ValueToSignDto;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.SignUtils;
import com.qiumingjie.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-07-01 10:57
 * @description
 */
@Service
public class SignService {
    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    SignRepository signRepository;

    @Autowired
    FormValuesService formValuesService;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler sign(String signId, String signer, String certificate) {

        //验证用户基本信息存在
        UserInfo userInfo = userInfoRepository.findAllByUserNumber(signer);
        if (userInfo == null) {
            return JsonHandler.fail("获取用户基本信息出错");
        }
        Optional<Sign> signOptional = signRepository.findById(signId);
        if (!signOptional.isPresent()) {
            return JsonHandler.fail("签名记录不存在");
        }
        Sign sign = signOptional.get();
        //验证表单是否存在
        Optional<FormMain> formMainOptional = formMainRepository.findById(sign.getFormId());
        FormMain formMain = null;
        if (formMainOptional.isPresent()) {
            formMain = formMainOptional.get();
        } else {
            return JsonHandler.fail("表单不存在");
        }
        sign.setSignFlag(true);
        sign.setSigner(signer);
        sign.setCertificate(certificate);
        sign.setSignerName(userInfo.getUserName());
        sign.setSignerPhotoPath(userInfo.getUserSignPhoto());
        sign.setAfterSignValue(SignUtils.signData(sign.getSignValue()));
        sign.setDateTime(System.currentTimeMillis());
        sign.setTwiceValue(SignUtils.base64Decode(sign.getSignValue() + sign.getAfterSignValue()));
        signRepository.save(sign);
        formMain.setSignFlag(checkSignAll(sign.getFormId()));
        formMainRepository.save(formMain);
        return JsonHandler.succeed(formValuesService.getForm(sign.getFormId()));
    }

    /**
     * 判断是否全部都签名好了
     *
     * @param formId
     * @return
     */
    public Boolean checkSignAll(String formId) {
        signRepository.findAll();
        List<Sign> allByFormId = signRepository.findAllByFormId(formId);
        for (Sign sign : allByFormId) {
            if (!sign.getSignFlag()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 新增或者修改签名信息
     */
    public void saveOrUpdateSign(String formId, String value) {
        for (Sign sign : valueToList(value)) {
            if (CommonUtils.empty(sign.getSignId())) {
                Validate.error("签名id为空");
            }
            //如果不存在则说明是第一次插入，设置默认值
            if (!signRepository.findById(sign.getSignId()).isPresent()) {
                sign.setSignFlag(false);
            }
            sign.setFormId(formId);
            //如果已经存在说明是修改，判断和原本的一致不，一致的
            if (CommonUtils.notEmpty(changeValue(sign))) {
                sign.setSignerPhotoPath(new byte[]{});
                sign.setSigner("");
                sign.setSignerName("");
                sign.setAfterSignValue("");
                sign.setCertificate("");
                sign.setTwiceValue(new byte[]{});
                sign.setSignFlag(false);
            }
            signRepository.save(sign);
        }
    }

    /**
     * 判断是否改变了原本的内容,假如改变则返回医生的名字
     *
     * @return
     */
    public String changeValue(Sign sign) {
        Optional<Sign> byId = signRepository.findById(sign.getSignId());
        //如果已经存在说明是修改，判断和原本的一致不，一致的
        if (byId.isPresent()) {
            if (CommonUtils.empty(byId.get().getSignValue()) || byId.get().getSignValue().equals(sign.getSignValue())) {
                return null;
            }
            return byId.get().getSignerName();
        } else {
            return null;
        }
    }

    /**
     * 转换
     *
     * @param value
     * @return
     */
    public List<Sign> valueToList(String value) {
        ValueToSignDto valueToSignDto = JSON.parseObject(value, ValueToSignDto.class);
        return valueToSignDto.getSignList();
    }

    /**
     * 判断是否已经存在id
     *
     * @return
     */
    public Boolean repeatSignId(String value) {
        List<Sign> signs = valueToList(value);
        for (Sign sign : signs) {
            Optional<Sign> byId = signRepository.findById(sign.getSignId());
            if (byId.isPresent()) {
                return true;
            }
        }
        return false;
    }
}
