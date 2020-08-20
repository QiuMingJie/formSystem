package com.qiumingjie.service;

import com.alibaba.fastjson.JSON;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.SignDto;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.SignUtils;
import com.qiumingjie.utils.TimeStampSignUtils;
import com.qiumingjie.utils.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

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
        String afterSignValue = SignUtils.signData(sign.getSignValue());
        try {

            if (!SignUtils.verifySignedData(sign.getSignValue(), afterSignValue)) {
                return JsonHandler.fail("表单签名失败，请稍后再试");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonHandler.fail("表单签名失败，请稍后再试");
        }
        //时间戳结果
        String timeStampString;
        try {
            timeStampString = TimeStampSignUtils.createTimeStamp(afterSignValue);
            String verifyResult = TimeStampSignUtils.verifyTss(timeStampString, afterSignValue);
            if (!"1".equals(verifyResult)) {
                return JsonHandler.fail(verifyResult);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return JsonHandler.fail("时间戳签名失败，请稍后再试:" + e.getMessage());
        }
        sign.setSignFlag(true);
        sign.setSigner(signer);
        sign.setCertificate(certificate);
        sign.setSignerName(userInfo.getUserName());
        sign.setSignerPhoto(userInfo.getUserSignPhoto());
        sign.setAfterSignValue(afterSignValue);
        sign.setDateTime(System.currentTimeMillis());
        sign.setTwiceValue(timeStampString);
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
        List<Sign> allSignList = signRepository.findAllByFormId(formId);
        Map<String, Boolean> map = allSignList.stream().collect(Collectors.toMap(Sign::getGroupId, Sign::getSignFlag,(value1, value2 )->{
            return value1||value2;
        }));
        return !map.containsValue(false);
    }


    /**
     * 新增或者修改签名信息
     */
    public void saveOrUpdateSign(String formId, List<SignDto> signDtoList, Boolean firstCreate) {
        List<Sign> signList = new ArrayList<>();
        for (SignDto signDto : signDtoList) {
            //如果是添加签名的话，直接insert
            if (firstCreate) {
                for (int i = 0; i < signDto.getSignerList().size(); i++) {
                    Sign sign = new Sign();
                    sign.setSignId(UUID.randomUUID().toString());
                    sign.setSignValue(signDto.getSignValue());
                    sign.setGroupId(signDto.getGroupId());
                    sign.setSignFlag(false);
                    sign.setFrontId(signDto.getSignerList().get(i).get("frontId"));
                    sign.setFormId(formId);
                    signList.add(sign);
                }
            } else {
                List<Sign> signList1 = signRepository.findAllByFormIdAndGroupId(formId, signDto.getGroupId());
                if (signList1.size() == 0) {
                    Validate.error("签名不存在");
                }
                //如果值没有变，不理会
                if (signDto.getSignValue().equals(signList1.get(0).getSignValue())) {
                    //刷新前端id
//                    signList1.get(0).setFrontId(signDto.getSignerList().get(i).get("frontId"));
                } else {
                    //值变了，取消次groupId下的全部签名
                    signList1.forEach(x -> {
                        x.setSignerPhoto(new byte[]{});
//                        sign.setSigner("");
//                        sign.setSignerName("");
//                        sign.setAfterSignValue("");
//                        sign.setCertificate("");
//                        sign.setTwiceValue(new byte[]{});
//                        sign.setSignFlag(false);
                        x.setSignFlag(false);
                        x.setSignValue(signDto.getSignValue());
                    });
                    signList.addAll(signList1);
                }
            }
        }
        signRepository.saveAll(signList);
    }

    public Map<String, SignDto> getSignMap(String formId) {
        Map<String, SignDto> result = new HashMap<>();
        List<Sign> signList = signRepository.findAllByFormId(formId);
        for (Sign sign : signList) {
            //如果已经存在，则更新或者新加，现在是一对多只要有一个人签名signFlag就是true
            if (result.get(sign.getGroupId()) != null) {
                SignDto signDto1 = result.get(sign.getGroupId());
                if (!signDto1.getSignFlag()) {
                    signDto1.setSignFlag(sign.getSignFlag());
                }
                signDto1.addSigner(sign);
            } else {
                SignDto signDto = new SignDto();
                signDto.setSignValue(sign.getSignValue());
                signDto.addSigner(sign);
                signDto.setGroupId(sign.getGroupId());
                signDto.setSignFlag(sign.getSignFlag());
                result.put(sign.getGroupId(), signDto);
            }
        }
        return result;
    }

    /**
     * 判断是否改变了原本的内容,假如改变则返回医生的名字
     *
     * @return
     */
    public List<Map<String, String>> changeValue(List<SignDto> signDtoList) {
        List<Map<String, String>> result = new ArrayList<>();
        for (SignDto signDto : signDtoList) {
            for (Map<String, String> map : signDto.getSignerList()) {
                Map<String, String> part = new HashMap<>();
                Optional<Sign> byId = signRepository.findById(map.get("signId"));
                if (byId.isPresent()) {
                    Sign sign = byId.get();
                    if (!JSON.parseObject(sign.getSignValue()).equals(JSON.parseObject(signDto.getSignValue()))&& sign.getSignFlag()) {
                        part.put("groupId", sign.getGroupId());
                        part.put("formId", sign.getFormId());
                        part.put("signer", sign.getSignerName());
                        result.add(part);
                    }
                } else {
                    Validate.error("签名数据不存在，签名id" + map.get("signId"));
                }
            }
        }
        return result;
    }


}
