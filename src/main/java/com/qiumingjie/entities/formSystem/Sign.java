package com.qiumingjie.entities.formSystem;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:29
 * @description 签名表
 */
@Entity
@Table(name = "Sign")
@Data
@ApiModel(value="签名对象",description="新增&更新文章对象说明")
public class Sign {

    @Id
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

    @ApiModelProperty(value = "签名过后值")
    @Column(columnDefinition = "varchar(max)")
    private String afterSignValue;

    @ApiModelProperty(value = "证书值",example = "2200000000000006C19A")
    private String certificate;

    @ApiModelProperty(value = "CA系统时间")
    private Long dateTime;

    @ApiModelProperty(value = "CA系统时间结果")
    private String twiceValue;

}
