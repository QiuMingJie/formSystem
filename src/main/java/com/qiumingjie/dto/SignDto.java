package com.qiumingjie.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author QiuMingJie
 * @date 2020-08-02 14:40
 * @description
 */
@Data
public class SignDto {

    @ApiModelProperty(value = "签名ID",required = true,example = "E001_0001_0001_01")
    String signId;

    @ApiModelProperty(value = "表单ID",required = true,example = "E001_0001_0001")
    String formId;

    byte[] signerPhotoPath;

    @ApiModelProperty(value = "签名原文")
    private String signValue;

    @ApiModelProperty(value = "签名标志")
    private Boolean signFlag;

    @ApiModelProperty(value = "签名者序号，CA盾持有者",required = true,example = "SF452402199703133944")
    String signer;

    @ApiModelProperty(value = "签名者姓名")
    String signerName;

    @ApiModelProperty(value = "CA系统时间")
    private Long dateTime;


}
