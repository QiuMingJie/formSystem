package com.qiumingjie.dto;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qiumingjie.entities.formSystem.Sign;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

/**
 * @author QiuMingJie
 * @date 2020-08-02 14:40
 * @description
 */
@Data
public class SignDto {


    @ApiModelProperty(value = "签名分组ID",required = true,example = "A,B,C")
    String groupId;

    @ApiModelProperty(value = "值",required = true,example = "{}")
    Object value;

    List<Map<String,Object>> signerList;

    @ApiModelProperty(value = "签名标志")
    private Boolean signFlag;


    @JsonIgnore
    private String signValue;

    public String getSignValue() {
        return JSON.toJSONString(this.getValue());
    }

    public void setSignValue(String signValue) {
        this.value = JSON.parse(signValue);
    }

    public void addSigner(Sign sign) {
        if (this.signerList == null) {
            this.signerList = new ArrayList<>();
        }
        Map<String, Object> temp = new HashMap<>();
        temp.put("signId", sign.getSignId());
        if (sign.getSignerPhoto() != null&&sign.getSignerPhoto().length!=0) {
            temp.put("signerPhoto", Arrays.toString(sign.getSignerPhoto()));
        } else {
            temp.put("signerPhoto", null);
        }
        temp.put("signFlag", sign.getSignFlag());
        temp.put("frontId", sign.getFrontId());
        this.signerList.add(temp);
    }
}
