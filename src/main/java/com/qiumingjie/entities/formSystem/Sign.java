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
@ApiModel(value = "签名对象Sign表", description = "新增&更新文章对象说明")
public class Sign {

    @Id
    @ApiModelProperty(value = "签名ID", required = true, example = "E001_0001_0001_01")
    String signId;

    @ApiModelProperty(value = "表单ID", required = true, example = "E001_0001_0001")
    String formId;

    @Column(columnDefinition = " image ")
    private byte[] signerPhoto;

    @ApiModelProperty(value = "分组的id")
    private String groupId;

    @ApiModelProperty(value = "前端id，给前端保存字段用")
    private String frontId;

    @ApiModelProperty(value = "签名原文")
    @Column(columnDefinition = "varchar(max)")
    private String signValue;

    @ApiModelProperty(value = "签名标志")
    private Boolean signFlag;

    @ApiModelProperty(value = "签名者序号，CA盾持有者", required = true, example = "SF452402199703133944")
    @Column(columnDefinition = "varchar(max)")
    String signer;

    @ApiModelProperty(value = "签名者姓名")
    String signerName;

    @ApiModelProperty(value = "签名过后值")
    @Column(columnDefinition = "varchar(max)")
    private String afterSignValue;

    @ApiModelProperty(value = "证书值", example = "MIIC/zCCAqSgAwIBAgIKIgAAAAAAAAbBmjAKBggqgRzPVQGDdTBoMQswCQYDVQQGEwJDTjEQMA4GA1UECAwHR3Vhbmd4aTEQMA4GA1UEBwwHTmFubmluZzENMAsGA1UECgwER1hDQTENMAsGA1UECwwER1hDQTEXMBUGA1UEAwwOR3Vhbmd4aSBTTTIgQ0EwHhcNMjAwMjA3MTYwMDAwWhcNMjEwMjA4MTU1OTU5WjBjMQswCQYDVQQGDAJDTjEeMBwGA1UECgwV5qKn5bee5biC5Lq65rCR5Yy76ZmiMQ8wDQYDVQQIDAblub/opb8xEjAQBgNVBAMMCeWPtuW7uueciTEPMA0GA1UEBwwG5qKn5beeMFkwEwYHKoZIzj0CAQYIKoEcz1UBgi0DQgAEugZPyA8acpfA2e4H72UP3RIiLhuVMUBp5y9UG7cHV0u83KuN8CJl8ViPv5MWmUG23U0LwR+V7M64SGUQ0yVVfaOCATkwggE1MB8GA1UdIwQYMBaAFKSwdSvAG1eiN3NHufr5gDWgIXj6MB0GA1UdDgQWBBT28gc1XRu96yxZ3cXcX7FA7IJzXjALBgNVHQ8EBAMCA9gwgcEGA1UdHwSBuTCBtjCBhKCBgaB/pH0wezELMAkGA1UEBgwCQ04xEDAOBgNVBAgMB0d1YW5neGkxEDAOBgNVBAcMB05hbm5pbmcxDTALBgNVBAoMBEdYQ0ExDTALBgNVBAsMBEdYQ0ExFzAVBgNVBAMMDkd1YW5neGkgU00yIENBMREwDwYDVQQDEwhjYTExY3JsMzAtoCugKYYnaHR0cDovL3NtMi5neGNhLmNvbS5jbi9jcmwvY2ExMWNybDMuY3JsMCIGCGCGSAGG+EQCBBYMFFNGNDUyNDAyMTk5NzAzMTMzOTQ0MAoGCCqBHM9VAYN1A0kAMEYCIQDE9UCUtGoSkkSLLYPTD83+49BveT232bq+dSGLlLXirAIhAN4UkgaGZrJt7tJ4kTL4mVsGHMmnMUS/OYDSA6mcVjo3")
    @Column(columnDefinition = " varchar(max)")
    private String certificate;

    @ApiModelProperty(value = "CA系统时间")
    private String  dateTime;

    @ApiModelProperty(value = "时间戳签名结果")
    @Column(columnDefinition = "varchar(max)")
    private String twiceValue;

    @Transient
    private Boolean twiceSign;

}
