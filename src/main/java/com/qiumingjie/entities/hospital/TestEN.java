package com.qiumingjie.entities.hospital;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-07-29 19:40
 * @description
 */
@Entity
@Data
@Table(name = "Sign_test")
public class TestEN {

    @Id
    String signId;

    String formId;

    String doctorId;

    String doctorSignPhoto;
}
