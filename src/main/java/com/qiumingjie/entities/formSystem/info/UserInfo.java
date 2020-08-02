package com.qiumingjie.entities.formSystem.info;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:27
 * @description 用户表，存用户基本信息和签名基本信息
 */
@Entity
@Table(name = "SM_User")
@Data
public class UserInfo {

    @Id
    private Integer userIdentity;

    private Integer roleIdentity;

    private String userNumber;

    private String userName;

    private String userShortName;

    private String password;

    private String deptCode;

    private String ime;

    private String phoneNo;

    private String title;

    private String degreede;

    @Column( columnDefinition = " char(2) ")
    private Boolean flag;

    private String remark;

    @Column(name="可实施最高ASA分级")
    private String maxAsaLevel;

    @Column(name="可实施最高手术分级")
    private String maxOprLevel;

    @Column(name = "签名图片", columnDefinition = " image ")
    private byte[] userSignPhoto;


}
