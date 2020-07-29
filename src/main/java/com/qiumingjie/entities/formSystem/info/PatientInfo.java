package com.qiumingjie.entities.formSystem.info;

import com.qiumingjie.entities.formSystem.evaluate.table.BaseEntity;

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
@Table(name = "PATIENT_INFO")
public class PatientInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String patientId;

    private String systemUserId;

    private String systemUserName;

    private String name;

    private String sex;

    private String age;

    private String ageMonth;

    private String ageDay;

    private String weight;

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

    private String medicalCardNo;

    private String patientInfoExpand1;

    private String patientInfoExpand2;

    private String patientInfoExpand3;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSystemUserId() {
        return systemUserId;
    }

    public void setSystemUserId(String systemUserId) {
        this.systemUserId = systemUserId;
    }

    public String getSystemUserName() {
        return systemUserName;
    }

    public void setSystemUserName(String systemUserName) {
        this.systemUserName = systemUserName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(String ageMonth) {
        this.ageMonth = ageMonth;
    }

    public String getAgeDay() {
        return ageDay;
    }

    public void setAgeDay(String ageDay) {
        this.ageDay = ageDay;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getBloodtypeRh() {
        return bloodtypeRh;
    }

    public void setBloodtypeRh(String bloodtypeRh) {
        this.bloodtypeRh = bloodtypeRh;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegisterDatetime() {
        return registerDatetime;
    }

    public void setRegisterDatetime(String registerDatetime) {
        this.registerDatetime = registerDatetime;
    }

    public String getRegisterPerson() {
        return registerPerson;
    }

    public void setRegisterPerson(String registerPerson) {
        this.registerPerson = registerPerson;
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getRelationName() {
        return relationName;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationAddr() {
        return relationAddr;
    }

    public void setRelationAddr(String relationAddr) {
        this.relationAddr = relationAddr;
    }

    public String getRelationZipcode() {
        return relationZipcode;
    }

    public void setRelationZipcode(String relationZipcode) {
        this.relationZipcode = relationZipcode;
    }

    public String getRelationTelephoneNo() {
        return relationTelephoneNo;
    }

    public void setRelationTelephoneNo(String relationTelephoneNo) {
        this.relationTelephoneNo = relationTelephoneNo;
    }

    public String getMedicareType() {
        return medicareType;
    }

    public void setMedicareType(String medicareType) {
        this.medicareType = medicareType;
    }

    public String getMedicareNo() {
        return medicareNo;
    }

    public void setMedicareNo(String medicareNo) {
        this.medicareNo = medicareNo;
    }

    public String getAllergyDrug() {
        return allergyDrug;
    }

    public void setAllergyDrug(String allergyDrug) {
        this.allergyDrug = allergyDrug;
    }

    public String getAdverseReactionDrug() {
        return adverseReactionDrug;
    }

    public void setAdverseReactionDrug(String adverseReactionDrug) {
        this.adverseReactionDrug = adverseReactionDrug;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getHcv() {
        return hcv;
    }

    public void setHcv(String hcv) {
        this.hcv = hcv;
    }

    public String getHbsag() {
        return hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getOtherInspection() {
        return otherInspection;
    }

    public void setOtherInspection(String otherInspection) {
        this.otherInspection = otherInspection;
    }

    public String getPinyinCode() {
        return pinyinCode;
    }

    public void setPinyinCode(String pinyinCode) {
        this.pinyinCode = pinyinCode;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getInhospitalTime() {
        return inhospitalTime;
    }

    public void setInhospitalTime(String inhospitalTime) {
        this.inhospitalTime = inhospitalTime;
    }

    public String getInhospitalDiagnoses() {
        return inhospitalDiagnoses;
    }

    public void setInhospitalDiagnoses(String inhospitalDiagnoses) {
        this.inhospitalDiagnoses = inhospitalDiagnoses;
    }

    public String getInhospitalDept() {
        return inhospitalDept;
    }

    public void setInhospitalDept(String inhospitalDept) {
        this.inhospitalDept = inhospitalDept;
    }

    public String getInhospitalWard() {
        return inhospitalWard;
    }

    public void setInhospitalWard(String inhospitalWard) {
        this.inhospitalWard = inhospitalWard;
    }

    public String getInhospitalBed() {
        return inhospitalBed;
    }

    public void setInhospitalBed(String inhospitalBed) {
        this.inhospitalBed = inhospitalBed;
    }

    public String getMypatid() {
        return mypatid;
    }

    public void setMypatid(String mypatid) {
        this.mypatid = mypatid;
    }

    public String getMedicalCardNo() {
        return medicalCardNo;
    }

    public void setMedicalCardNo(String medicalCardNo) {
        this.medicalCardNo = medicalCardNo;
    }

    public String getPatientInfoExpand1() {
        return patientInfoExpand1;
    }

    public void setPatientInfoExpand1(String patientInfoExpand1) {
        this.patientInfoExpand1 = patientInfoExpand1;
    }

    public String getPatientInfoExpand2() {
        return patientInfoExpand2;
    }

    public void setPatientInfoExpand2(String patientInfoExpand2) {
        this.patientInfoExpand2 = patientInfoExpand2;
    }

    public String getPatientInfoExpand3() {
        return patientInfoExpand3;
    }

    public void setPatientInfoExpand3(String patientInfoExpand3) {
        this.patientInfoExpand3 = patientInfoExpand3;
    }
}
