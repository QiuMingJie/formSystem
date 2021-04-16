package com.qiumingjie.service;

import com.alibaba.fastjson.JSON;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.info.UserInfoRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.dto.SignDto;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.dict.FormDict;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.DateUtils;
import com.qiumingjie.utils.FormUtil;
import com.qiumingjie.utils.SignUtils;
import com.qiumingjie.utils.TimeStampSignUtils;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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


    @Autowired
    FormDictService formDictService;

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
        sign.setDateTime(DateUtils.getNowDateTime());
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
        List<Sign> allSignList = signRepository.findAllByFormIdOrderByFrontIdAsc(formId);
        Map<String, Boolean> map = allSignList.stream().collect(Collectors.toMap(Sign::getGroupId, Sign::getSignFlag,(value1, value2 )->{
            return value1&&value2;
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
                    sign.setFrontId(String.valueOf(signDto.getSignerList().get(i).get("frontId")));
                    sign.setFormId(formId);
                    signList.add(sign);
                }
            } else {
                List<Sign> databaseSignValue = signRepository.findAllByFormIdAndGroupId(formId, signDto.getGroupId());
                if (databaseSignValue.size() == 0) {
                    List<Sign> insertSignList = new ArrayList<>();
                    for (int i = 0; i < signDto.getSignerList().size(); i++) {
                        Sign sign = new Sign();
                        sign.setSignId(UUID.randomUUID().toString());
                        sign.setSignValue(signDto.getSignValue());
                        sign.setGroupId(signDto.getGroupId());
                        sign.setSignFlag(false);
                        sign.setFrontId(String.valueOf(signDto.getSignerList().get(i).get("frontId")));
                        sign.setFormId(formId);
                        insertSignList.add(sign);
                    }
                    signRepository.saveAll(insertSignList);
                }else {
                    //假如两个的值变了而且formDict 的changeDeleteSign标志为true的话才取消签名
                    FormDict formdict = formDictService.getFromByFromDictId(FormUtil.getFormDictId(formId));
                    if (formdict == null) {
                        throw new RuntimeException("表单字典表form_dict表中无此表单");
                    }
                    if (twoJsonNoEqual(signDto.getSignValue(), databaseSignValue.get(0).getSignValue()) && formdict.getChangeDeleteSign()) {
                        //值变了，取消次groupId下的全部签名
                        databaseSignValue.forEach(x -> {
                            x.setSignerPhoto(null);
                            x.setSignFlag(false);
                            x.setSignValue(signDto.getSignValue());
                        });
                        signList.addAll(databaseSignValue);
                    } else {
                        //值没变，还是覆盖保存
                        databaseSignValue.forEach(x -> {
                            x.setSignValue(signDto.getSignValue());
                        });
                        signList.addAll(databaseSignValue);
                    }
                }
            }
        }
        signRepository.saveAll(signList);
    }

    public Map<String, SignDto> getSignMap(String formId) {
        Map<String, SignDto> result = new HashMap<>();
        List<Sign> signList = signRepository.findAllByFormIdOrderByFrontIdAsc(formId);
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
            for (Map<String, Object> map : signDto.getSignerList()) {
                Map<String, String> part = new HashMap<>();
                Optional<Sign> byId = signRepository.findById(String.valueOf(map.get("signId")));
                if (byId.isPresent()) {
                    Sign sign = byId.get();
                    if (twoJsonNoEqual(sign.getSignValue(),signDto.getSignValue())&& sign.getSignFlag()) {
                        part.put("groupId", sign.getGroupId());
                        part.put("formId", sign.getFormId());
                        part.put("signer", sign.getSignerName());
                        result.add(part);
                    }
                } else {
                    //跳过此处验证，后续会保存，
                    log.info("签名数据不存在，参数为 {}", map);
                }
            }
        }
        return result;
    }

    /**
     * 判断两个json是否不相等
     * @return
     */
    public Boolean twoJsonNoEqual(String json1,String json2) {
        return  !JSON.parseObject(json1).equals(JSON.parseObject(json2));
    }

}
