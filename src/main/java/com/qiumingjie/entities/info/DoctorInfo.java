package com.qiumingjie.entities.info;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:27
 * @description
 */
@Entity
@Table(name = "Doctor_Info")
public class DoctorInfo {


    @Id
    private String doctorId;

    private String doctorSignPhoto;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorSignPhoto() {
        return doctorSignPhoto;
    }

    public void setDoctorSignPhoto(String signPhoto) {
        this.doctorSignPhoto = signPhoto;
    }
}
