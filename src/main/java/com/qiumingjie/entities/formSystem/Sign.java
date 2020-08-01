package com.qiumingjie.entities.formSystem;


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
public class Sign {

    @Id
    String signId;

    String formId;

    String groupName;

    String signer;

    String signerPhotoPath;

    @Column(columnDefinition = "varchar(max)")
    private String afterSignValue;

    /**
     * 签名部分
     */
    private Boolean signFlag;

    @Transient
    String key;

}
