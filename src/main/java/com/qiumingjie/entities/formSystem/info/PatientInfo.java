package com.qiumingjie.entities.formSystem.info;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-02-26 13:53
 * @description
 */
@Entity
@Table(name = "BasicData_Patient_Info")
@Data
public class PatientInfo  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 100, name = "patientID", columnDefinition = "varchar(100)")
    private String patientId;

    private String name;

    private String sex;

    private String age;

    private String ageMonth;

    private String ageDay;

    private String weight;

    @Column(name ="bloodtype")
    private String bloodType;

    private String bloodtypeRh;

    private String birthday;

    private String registerDatetime;

    private String registerPerson;

    private String patientType;

    private String telephoneNo;

    private String residence;

    private String zipcode;

    private String idCardNo;

    private String relationName;

    private String relationship;

    private String relationAddr;

    private String relationZipcode;

    private String relationTelephoneNo;

    private String medicareType;

    private String medicareNo;

    private String allergyDrug;

    private String adverseReactionDrug;

    private String hiv;

    private String tp;

    private String hcv;

    private String hbsag;

    private String otherInspection;

    private String pinyinCode;

    private String nation;

    private String inhospitalTime;

    private String inhospitalDiagnoses;

    private String inhospitalDept;

    private String inhospitalWard;

    private String inhospitalBed;

    private String mypatid;

}