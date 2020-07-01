package com.qiumingjie.entities.sign;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:29
 * @description 签名表
 */
@Entity
@Table(name = "Sign")
public class Sign {

    @Id
    String signId;

    String formId;

    String doctorId;

    String doctorSignPhoto;

    @Transient
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDoctorSignPhoto() {
        return doctorSignPhoto;
    }

    public void setDoctorSignPhoto(String doctorSignPhoto) {
        this.doctorSignPhoto = doctorSignPhoto;
    }

    public String getSignId() {
        return signId;
    }

    public void setSignId(String id) {
        this.signId = id;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
