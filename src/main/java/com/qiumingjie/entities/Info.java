package com.qiumingjie.entities;

import com.qiumingjie.entities.evaluate.table.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-02-26 13:53
 * @description
 */
@Entity
@Table(name = "INFO")
public class Info extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "INFO")
    @GenericGenerator(name ="INFO",strategy = "uuid")
    private String  id;

    /**
     * 患者部分
     */
    private String patientId;

    private String name;

    private String sex;

    private String age;

    private String weight;


    private String patientInfoExpand1;

    private String patientInfoExpand2;

    private String patientInfoExpand3;

    /**
     * 入院时间
     */
        private String inHospitalDateTime;

    private String deptName;

    private String bedNo;

    private String visitId;


    /**
     * 手术
     *
     * @return
     */

    private String operationId;

    private String operaDateTime;

    private String opreaInfoExpand1;
    private String opreaInfoExpand2;
    private String opreaInfoExpand3;

    public String getOpreaInfoExpand1() {
        return opreaInfoExpand1;
    }

    public void setOpreaInfoExpand1(String opreaInfoExpand1) {
        this.opreaInfoExpand1 = opreaInfoExpand1;
    }

    public String getOpreaInfoExpand2() {
        return opreaInfoExpand2;
    }

    public void setOpreaInfoExpand2(String opreaInfoExpand2) {
        this.opreaInfoExpand2 = opreaInfoExpand2;
    }

    public String getOpreaInfoExpand3() {
        return opreaInfoExpand3;
    }

    public void setOpreaInfoExpand3(String opreaInfoExpand3) {
        this.opreaInfoExpand3 = opreaInfoExpand3;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPatientInfoExpand1() {
        return patientInfoExpand1;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getInHospitalDateTime() {
        return inHospitalDateTime;
    }

    public void setInHospitalDateTime(String inHospitalDateTime) {
        this.inHospitalDateTime = inHospitalDateTime;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getVisitId() {
        return visitId;
    }

    public void setVisitId(String visitId) {
        this.visitId = visitId;
    }

    public String getOperaDateTime() {
        return operaDateTime;
    }

    public void setOperaDateTime(String operaDateTime) {
        this.operaDateTime = operaDateTime;
    }
}
