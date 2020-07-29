package com.qiumingjie.entities.formSystem.info;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 * @author QiuMingJie
 * @date 2020-03-10 16:53
 * @description 手术信息
 */
@Entity
@Table(name = "OPS_QUEUE")
public class OpsQueue {

    @Id
    private String operationId;

    @NotEmpty(message = "patientId不可以为空")
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientId;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String outpatientId;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String inpatientId;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientDept;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientWard;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientBed;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationRoom;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationNo;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationDatetime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationDoctor;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationPosition;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticDoctor;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticMethod;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String preoperationDiagnosis;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String apparatusNurse;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String requestDatetime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String registerTime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String registerPerson;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String canceledTime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String canceledPerson;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String canceledCause;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationState;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientState;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String enterRoomTime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String exitRoomTime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String specialInstrument;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String monitoringStarttime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String monitoringEndtime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationStarttime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationEndtime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anesthesiaStarttime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anesthesiaEndtime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String ASA;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String heartFunction;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String bodyPosition;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String preanesthMedication;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String specialCase;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String postoperationDiagnosis;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String postoperaAnalgesia;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String analgesiaFormula;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String amountBleeding;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String urinaryProduction;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String others;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String emergencyOrNot;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationDept;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationPerson;
    @Column(name = "tbcondition " ,length = 100, columnDefinition = "varchar(100)")
    private String condition;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isolation;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationLv;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isMonitoring;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationFormNumber;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isPreoperationFasting;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientHeight;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientWeight;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientDepRoom;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant4;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant5;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isAnesthing;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation4;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation5;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation6;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost4;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost5;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost6;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String ipid;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String instrumentName;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String preoperationDiagnosisCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation4Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation5Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String intendedOperation6Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPostCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost4Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost5Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPost6Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticMethodCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationDoctorCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant4Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationAssistant5Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticDoctorCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String wardCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String deptCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurseCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurseCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String registerPersonCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationDeptCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationPersonCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String infectionType;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String incisionType;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isOpenSurgery;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isEndoscopicSurgery;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String inpatientOrOutpatient;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isPreoperativeVisits;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isPostoperativeVisits;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String greenChannel;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefDatetime1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefDatetime2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefDatetime3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefDatetime1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefDatetime2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubReliefDatetime3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String postoperationDiagnosisCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationStateNotfinalReason;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String postoperativeDeath;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String checkedPerson;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String checkedPersonCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationTime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String isPrinted;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationFinishstate;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticDoctor;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticDoctorCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticDoctorShiftDatetime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant1;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant1Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant1ShiftDatetime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant2;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant2ShiftDatetime;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant3;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String reliefAnestheticAssistant3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticAssistant3ShiftDatetime;

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

    public String getOutpatientId() {
        return outpatientId;
    }

    public void setOutpatientId(String outpatientId) {
        this.outpatientId = outpatientId;
    }

    public String getInpatientId() {
        return inpatientId;
    }

    public void setInpatientId(String inpatientId) {
        this.inpatientId = inpatientId;
    }

    public String getPatientDept() {
        return patientDept;
    }

    public void setPatientDept(String patientDept) {
        this.patientDept = patientDept;
    }

    public String getPatientWard() {
        return patientWard;
    }

    public void setPatientWard(String patientWard) {
        this.patientWard = patientWard;
    }

    public String getPatientBed() {
        return patientBed;
    }

    public void setPatientBed(String patientBed) {
        this.patientBed = patientBed;
    }

    public String getOperationRoom() {
        return operationRoom;
    }

    public void setOperationRoom(String operationRoom) {
        this.operationRoom = operationRoom;
    }

    public String getOperationNo() {
        return operationNo;
    }

    public void setOperationNo(String operationNo) {
        this.operationNo = operationNo;
    }

    public String getOperationDatetime() {
        return operationDatetime;
    }

    public void setOperationDatetime(String operationDatetime) {
        this.operationDatetime = operationDatetime;
    }

    public String getIntendedOperation1() {
        return intendedOperation1;
    }

    public void setIntendedOperation1(String intendedOperation1) {
        this.intendedOperation1 = intendedOperation1;
    }

    public String getIntendedOperation2() {
        return intendedOperation2;
    }

    public void setIntendedOperation2(String intendedOperation2) {
        this.intendedOperation2 = intendedOperation2;
    }

    public String getIntendedOperation3() {
        return intendedOperation3;
    }

    public void setIntendedOperation3(String intendedOperation3) {
        this.intendedOperation3 = intendedOperation3;
    }

    public String getOperationDoctor() {
        return operationDoctor;
    }

    public void setOperationDoctor(String operationDoctor) {
        this.operationDoctor = operationDoctor;
    }

    public String getOperationAssistant1() {
        return operationAssistant1;
    }

    public void setOperationAssistant1(String operationAssistant1) {
        this.operationAssistant1 = operationAssistant1;
    }

    public String getOperationAssistant2() {
        return operationAssistant2;
    }

    public void setOperationAssistant2(String operationAssistant2) {
        this.operationAssistant2 = operationAssistant2;
    }

    public String getOperationAssistant3() {
        return operationAssistant3;
    }

    public void setOperationAssistant3(String operationAssistant3) {
        this.operationAssistant3 = operationAssistant3;
    }

    public String getOperationPosition() {
        return operationPosition;
    }

    public void setOperationPosition(String operationPosition) {
        this.operationPosition = operationPosition;
    }

    public String getAnestheticDoctor() {
        return anestheticDoctor;
    }

    public void setAnestheticDoctor(String anestheticDoctor) {
        this.anestheticDoctor = anestheticDoctor;
    }

    public String getAnestheticAssistant1() {
        return anestheticAssistant1;
    }

    public void setAnestheticAssistant1(String anestheticAssistant1) {
        this.anestheticAssistant1 = anestheticAssistant1;
    }

    public String getAnestheticAssistant2() {
        return anestheticAssistant2;
    }

    public void setAnestheticAssistant2(String anestheticAssistant2) {
        this.anestheticAssistant2 = anestheticAssistant2;
    }

    public String getAnestheticAssistant3() {
        return anestheticAssistant3;
    }

    public void setAnestheticAssistant3(String anestheticAssistant3) {
        this.anestheticAssistant3 = anestheticAssistant3;
    }

    public String getAnestheticMethod() {
        return anestheticMethod;
    }

    public void setAnestheticMethod(String anestheticMethod) {
        this.anestheticMethod = anestheticMethod;
    }

    public String getPreoperationDiagnosis() {
        return preoperationDiagnosis;
    }

    public void setPreoperationDiagnosis(String preoperationDiagnosis) {
        this.preoperationDiagnosis = preoperationDiagnosis;
    }

    public String getCirculatingNurse() {
        return circulatingNurse;
    }

    public void setCirculatingNurse(String circulatingNurse) {
        this.circulatingNurse = circulatingNurse;
    }

    public String getScrubNurse() {
        return scrubNurse;
    }

    public void setScrubNurse(String scrubNurse) {
        this.scrubNurse = scrubNurse;
    }

    public String getApparatusNurse() {
        return apparatusNurse;
    }

    public void setApparatusNurse(String apparatusNurse) {
        this.apparatusNurse = apparatusNurse;
    }

    public String getRequestDatetime() {
        return requestDatetime;
    }

    public void setRequestDatetime(String requestDatetime) {
        this.requestDatetime = requestDatetime;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterPerson() {
        return registerPerson;
    }

    public void setRegisterPerson(String registerPerson) {
        this.registerPerson = registerPerson;
    }

    public String getCanceledTime() {
        return canceledTime;
    }

    public void setCanceledTime(String canceledTime) {
        this.canceledTime = canceledTime;
    }

    public String getCanceledPerson() {
        return canceledPerson;
    }

    public void setCanceledPerson(String canceledPerson) {
        this.canceledPerson = canceledPerson;
    }

    public String getCanceledCause() {
        return canceledCause;
    }

    public void setCanceledCause(String canceledCause) {
        this.canceledCause = canceledCause;
    }

    public String getOperationState() {
        return operationState;
    }

    public void setOperationState(String operationState) {
        this.operationState = operationState;
    }

    public String getPatientState() {
        return patientState;
    }

    public void setPatientState(String patientState) {
        this.patientState = patientState;
    }

    public String getEnterRoomTime() {
        return enterRoomTime;
    }

    public void setEnterRoomTime(String enterRoomTime) {
        this.enterRoomTime = enterRoomTime;
    }

    public String getExitRoomTime() {
        return exitRoomTime;
    }

    public void setExitRoomTime(String exitRoomTime) {
        this.exitRoomTime = exitRoomTime;
    }

    public String getSpecialInstrument() {
        return specialInstrument;
    }

    public void setSpecialInstrument(String specialInstrument) {
        this.specialInstrument = specialInstrument;
    }

    public String getMonitoringStarttime() {
        return monitoringStarttime;
    }

    public void setMonitoringStarttime(String monitoringStarttime) {
        this.monitoringStarttime = monitoringStarttime;
    }

    public String getMonitoringEndtime() {
        return monitoringEndtime;
    }

    public void setMonitoringEndtime(String monitoringEndtime) {
        this.monitoringEndtime = monitoringEndtime;
    }

    public String getOperationStarttime() {
        return operationStarttime;
    }

    public void setOperationStarttime(String operationStarttime) {
        this.operationStarttime = operationStarttime;
    }

    public String getOperationEndtime() {
        return operationEndtime;
    }

    public void setOperationEndtime(String operationEndtime) {
        this.operationEndtime = operationEndtime;
    }

    public String getAnesthesiaStarttime() {
        return anesthesiaStarttime;
    }

    public void setAnesthesiaStarttime(String anesthesiaStarttime) {
        this.anesthesiaStarttime = anesthesiaStarttime;
    }

    public String getAnesthesiaEndtime() {
        return anesthesiaEndtime;
    }

    public void setAnesthesiaEndtime(String anesthesiaEndtime) {
        this.anesthesiaEndtime = anesthesiaEndtime;
    }

    public String getASA() {
        return ASA;
    }

    public void setASA(String ASA) {
        this.ASA = ASA;
    }

    public String getHeartFunction() {
        return heartFunction;
    }

    public void setHeartFunction(String heartFunction) {
        this.heartFunction = heartFunction;
    }

    public String getBodyPosition() {
        return bodyPosition;
    }

    public void setBodyPosition(String bodyPosition) {
        this.bodyPosition = bodyPosition;
    }

    public String getPreanesthMedication() {
        return preanesthMedication;
    }

    public void setPreanesthMedication(String preanesthMedication) {
        this.preanesthMedication = preanesthMedication;
    }

    public String getSpecialCase() {
        return specialCase;
    }

    public void setSpecialCase(String specialCase) {
        this.specialCase = specialCase;
    }

    public String getPostoperationDiagnosis() {
        return postoperationDiagnosis;
    }

    public void setPostoperationDiagnosis(String postoperationDiagnosis) {
        this.postoperationDiagnosis = postoperationDiagnosis;
    }

    public String getPostoperaAnalgesia() {
        return postoperaAnalgesia;
    }

    public void setPostoperaAnalgesia(String postoperaAnalgesia) {
        this.postoperaAnalgesia = postoperaAnalgesia;
    }

    public String getOperationMethodPost() {
        return operationMethodPost;
    }

    public void setOperationMethodPost(String operationMethodPost) {
        this.operationMethodPost = operationMethodPost;
    }

    public String getAnalgesiaFormula() {
        return analgesiaFormula;
    }

    public void setAnalgesiaFormula(String analgesiaFormula) {
        this.analgesiaFormula = analgesiaFormula;
    }

    public String getAmountBleeding() {
        return amountBleeding;
    }

    public void setAmountBleeding(String amountBleeding) {
        this.amountBleeding = amountBleeding;
    }

    public String getUrinaryProduction() {
        return urinaryProduction;
    }

    public void setUrinaryProduction(String urinaryProduction) {
        this.urinaryProduction = urinaryProduction;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getEmergencyOrNot() {
        return emergencyOrNot;
    }

    public void setEmergencyOrNot(String emergencyOrNot) {
        this.emergencyOrNot = emergencyOrNot;
    }

    public String getApplicationDept() {
        return applicationDept;
    }

    public void setApplicationDept(String applicationDept) {
        this.applicationDept = applicationDept;
    }

    public String getApplicationPerson() {
        return applicationPerson;
    }

    public void setApplicationPerson(String applicationPerson) {
        this.applicationPerson = applicationPerson;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIsolation() {
        return isolation;
    }

    public void setIsolation(String isolation) {
        this.isolation = isolation;
    }

    public String getOperationLv() {
        return operationLv;
    }

    public void setOperationLv(String operationLv) {
        this.operationLv = operationLv;
    }

    public String getIsMonitoring() {
        return isMonitoring;
    }

    public void setIsMonitoring(String isMonitoring) {
        this.isMonitoring = isMonitoring;
    }

    public String getApplicationFormNumber() {
        return applicationFormNumber;
    }

    public void setApplicationFormNumber(String applicationFormNumber) {
        this.applicationFormNumber = applicationFormNumber;
    }

    public String getIsPreoperationFasting() {
        return isPreoperationFasting;
    }

    public void setIsPreoperationFasting(String isPreoperationFasting) {
        this.isPreoperationFasting = isPreoperationFasting;
    }

    public String getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(String patientHeight) {
        this.patientHeight = patientHeight;
    }

    public String getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(String patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientDepRoom() {
        return patientDepRoom;
    }

    public void setPatientDepRoom(String patientDepRoom) {
        this.patientDepRoom = patientDepRoom;
    }

    public String getOperationAssistant4() {
        return operationAssistant4;
    }

    public void setOperationAssistant4(String operationAssistant4) {
        this.operationAssistant4 = operationAssistant4;
    }

    public String getOperationAssistant5() {
        return operationAssistant5;
    }

    public void setOperationAssistant5(String operationAssistant5) {
        this.operationAssistant5 = operationAssistant5;
    }

    public String getIsAnesthing() {
        return isAnesthing;
    }

    public void setIsAnesthing(String isAnesthing) {
        this.isAnesthing = isAnesthing;
    }

    public String getIntendedOperation4() {
        return intendedOperation4;
    }

    public void setIntendedOperation4(String intendedOperation4) {
        this.intendedOperation4 = intendedOperation4;
    }

    public String getIntendedOperation5() {
        return intendedOperation5;
    }

    public void setIntendedOperation5(String intendedOperation5) {
        this.intendedOperation5 = intendedOperation5;
    }

    public String getIntendedOperation6() {
        return intendedOperation6;
    }

    public void setIntendedOperation6(String intendedOperation6) {
        this.intendedOperation6 = intendedOperation6;
    }

    public String getOperationMethodPost2() {
        return operationMethodPost2;
    }

    public void setOperationMethodPost2(String operationMethodPost2) {
        this.operationMethodPost2 = operationMethodPost2;
    }

    public String getOperationMethodPost3() {
        return operationMethodPost3;
    }

    public void setOperationMethodPost3(String operationMethodPost3) {
        this.operationMethodPost3 = operationMethodPost3;
    }

    public String getOperationMethodPost4() {
        return operationMethodPost4;
    }

    public void setOperationMethodPost4(String operationMethodPost4) {
        this.operationMethodPost4 = operationMethodPost4;
    }

    public String getOperationMethodPost5() {
        return operationMethodPost5;
    }

    public void setOperationMethodPost5(String operationMethodPost5) {
        this.operationMethodPost5 = operationMethodPost5;
    }

    public String getOperationMethodPost6() {
        return operationMethodPost6;
    }

    public void setOperationMethodPost6(String operationMethodPost6) {
        this.operationMethodPost6 = operationMethodPost6;
    }

    public String getIpid() {
        return ipid;
    }

    public void setIpid(String ipid) {
        this.ipid = ipid;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getPreoperationDiagnosisCode() {
        return preoperationDiagnosisCode;
    }

    public void setPreoperationDiagnosisCode(String preoperationDiagnosisCode) {
        this.preoperationDiagnosisCode = preoperationDiagnosisCode;
    }

    public String getIntendedOperation1Code() {
        return intendedOperation1Code;
    }

    public void setIntendedOperation1Code(String intendedOperation1Code) {
        this.intendedOperation1Code = intendedOperation1Code;
    }

    public String getIntendedOperation2Code() {
        return intendedOperation2Code;
    }

    public void setIntendedOperation2Code(String intendedOperation2Code) {
        this.intendedOperation2Code = intendedOperation2Code;
    }

    public String getIntendedOperation3Code() {
        return intendedOperation3Code;
    }

    public void setIntendedOperation3Code(String intendedOperation3Code) {
        this.intendedOperation3Code = intendedOperation3Code;
    }

    public String getIntendedOperation4Code() {
        return intendedOperation4Code;
    }

    public void setIntendedOperation4Code(String intendedOperation4Code) {
        this.intendedOperation4Code = intendedOperation4Code;
    }

    public String getIntendedOperation5Code() {
        return intendedOperation5Code;
    }

    public void setIntendedOperation5Code(String intendedOperation5Code) {
        this.intendedOperation5Code = intendedOperation5Code;
    }

    public String getIntendedOperation6Code() {
        return intendedOperation6Code;
    }

    public void setIntendedOperation6Code(String intendedOperation6Code) {
        this.intendedOperation6Code = intendedOperation6Code;
    }

    public String getOperationMethodPostCode() {
        return operationMethodPostCode;
    }

    public void setOperationMethodPostCode(String operationMethodPostCode) {
        this.operationMethodPostCode = operationMethodPostCode;
    }

    public String getOperationMethodPost2Code() {
        return operationMethodPost2Code;
    }

    public void setOperationMethodPost2Code(String operationMethodPost2Code) {
        this.operationMethodPost2Code = operationMethodPost2Code;
    }

    public String getOperationMethodPost3Code() {
        return operationMethodPost3Code;
    }

    public void setOperationMethodPost3Code(String operationMethodPost3Code) {
        this.operationMethodPost3Code = operationMethodPost3Code;
    }

    public String getOperationMethodPost4Code() {
        return operationMethodPost4Code;
    }

    public void setOperationMethodPost4Code(String operationMethodPost4Code) {
        this.operationMethodPost4Code = operationMethodPost4Code;
    }

    public String getOperationMethodPost5Code() {
        return operationMethodPost5Code;
    }

    public void setOperationMethodPost5Code(String operationMethodPost5Code) {
        this.operationMethodPost5Code = operationMethodPost5Code;
    }

    public String getOperationMethodPost6Code() {
        return operationMethodPost6Code;
    }

    public void setOperationMethodPost6Code(String operationMethodPost6Code) {
        this.operationMethodPost6Code = operationMethodPost6Code;
    }

    public String getAnestheticMethodCode() {
        return anestheticMethodCode;
    }

    public void setAnestheticMethodCode(String anestheticMethodCode) {
        this.anestheticMethodCode = anestheticMethodCode;
    }

    public String getOperationDoctorCode() {
        return operationDoctorCode;
    }

    public void setOperationDoctorCode(String operationDoctorCode) {
        this.operationDoctorCode = operationDoctorCode;
    }

    public String getOperationAssistant1Code() {
        return operationAssistant1Code;
    }

    public void setOperationAssistant1Code(String operationAssistant1Code) {
        this.operationAssistant1Code = operationAssistant1Code;
    }

    public String getOperationAssistant2Code() {
        return operationAssistant2Code;
    }

    public void setOperationAssistant2Code(String operationAssistant2Code) {
        this.operationAssistant2Code = operationAssistant2Code;
    }

    public String getOperationAssistant3Code() {
        return operationAssistant3Code;
    }

    public void setOperationAssistant3Code(String operationAssistant3Code) {
        this.operationAssistant3Code = operationAssistant3Code;
    }

    public String getOperationAssistant4Code() {
        return operationAssistant4Code;
    }

    public void setOperationAssistant4Code(String operationAssistant4Code) {
        this.operationAssistant4Code = operationAssistant4Code;
    }

    public String getOperationAssistant5Code() {
        return operationAssistant5Code;
    }

    public void setOperationAssistant5Code(String operationAssistant5Code) {
        this.operationAssistant5Code = operationAssistant5Code;
    }

    public String getAnestheticDoctorCode() {
        return anestheticDoctorCode;
    }

    public void setAnestheticDoctorCode(String anestheticDoctorCode) {
        this.anestheticDoctorCode = anestheticDoctorCode;
    }

    public String getAnestheticAssistant1Code() {
        return anestheticAssistant1Code;
    }

    public void setAnestheticAssistant1Code(String anestheticAssistant1Code) {
        this.anestheticAssistant1Code = anestheticAssistant1Code;
    }

    public String getAnestheticAssistant2Code() {
        return anestheticAssistant2Code;
    }

    public void setAnestheticAssistant2Code(String anestheticAssistant2Code) {
        this.anestheticAssistant2Code = anestheticAssistant2Code;
    }

    public String getAnestheticAssistant3Code() {
        return anestheticAssistant3Code;
    }

    public void setAnestheticAssistant3Code(String anestheticAssistant3Code) {
        this.anestheticAssistant3Code = anestheticAssistant3Code;
    }

    public String getWardCode() {
        return wardCode;
    }

    public void setWardCode(String wardCode) {
        this.wardCode = wardCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getCirculatingNurseCode() {
        return circulatingNurseCode;
    }

    public void setCirculatingNurseCode(String circulatingNurseCode) {
        this.circulatingNurseCode = circulatingNurseCode;
    }

    public String getScrubNurseCode() {
        return scrubNurseCode;
    }

    public void setScrubNurseCode(String scrubNurseCode) {
        this.scrubNurseCode = scrubNurseCode;
    }

    public String getRegisterPersonCode() {
        return registerPersonCode;
    }

    public void setRegisterPersonCode(String registerPersonCode) {
        this.registerPersonCode = registerPersonCode;
    }

    public String getApplicationDeptCode() {
        return applicationDeptCode;
    }

    public void setApplicationDeptCode(String applicationDeptCode) {
        this.applicationDeptCode = applicationDeptCode;
    }

    public String getApplicationPersonCode() {
        return applicationPersonCode;
    }

    public void setApplicationPersonCode(String applicationPersonCode) {
        this.applicationPersonCode = applicationPersonCode;
    }

    public String getInfectionType() {
        return infectionType;
    }

    public void setInfectionType(String infectionType) {
        this.infectionType = infectionType;
    }

    public String getIncisionType() {
        return incisionType;
    }

    public void setIncisionType(String incisionType) {
        this.incisionType = incisionType;
    }

    public String getIsOpenSurgery() {
        return isOpenSurgery;
    }

    public void setIsOpenSurgery(String isOpenSurgery) {
        this.isOpenSurgery = isOpenSurgery;
    }

    public String getIsEndoscopicSurgery() {
        return isEndoscopicSurgery;
    }

    public void setIsEndoscopicSurgery(String isEndoscopicSurgery) {
        this.isEndoscopicSurgery = isEndoscopicSurgery;
    }

    public String getInpatientOrOutpatient() {
        return inpatientOrOutpatient;
    }

    public void setInpatientOrOutpatient(String inpatientOrOutpatient) {
        this.inpatientOrOutpatient = inpatientOrOutpatient;
    }

    public String getIsPreoperativeVisits() {
        return isPreoperativeVisits;
    }

    public void setIsPreoperativeVisits(String isPreoperativeVisits) {
        this.isPreoperativeVisits = isPreoperativeVisits;
    }

    public String getIsPostoperativeVisits() {
        return isPostoperativeVisits;
    }

    public void setIsPostoperativeVisits(String isPostoperativeVisits) {
        this.isPostoperativeVisits = isPostoperativeVisits;
    }

    public String getCirculatingNurse2() {
        return circulatingNurse2;
    }

    public void setCirculatingNurse2(String circulatingNurse2) {
        this.circulatingNurse2 = circulatingNurse2;
    }

    public String getCirculatingNurse2Code() {
        return circulatingNurse2Code;
    }

    public void setCirculatingNurse2Code(String circulatingNurse2Code) {
        this.circulatingNurse2Code = circulatingNurse2Code;
    }

    public String getCirculatingNurse3() {
        return circulatingNurse3;
    }

    public void setCirculatingNurse3(String circulatingNurse3) {
        this.circulatingNurse3 = circulatingNurse3;
    }

    public String getCirculatingNurse3Code() {
        return circulatingNurse3Code;
    }

    public void setCirculatingNurse3Code(String circulatingNurse3Code) {
        this.circulatingNurse3Code = circulatingNurse3Code;
    }

    public String getScrubNurse2() {
        return scrubNurse2;
    }

    public void setScrubNurse2(String scrubNurse2) {
        this.scrubNurse2 = scrubNurse2;
    }

    public String getScrubNurse2Code() {
        return scrubNurse2Code;
    }

    public void setScrubNurse2Code(String scrubNurse2Code) {
        this.scrubNurse2Code = scrubNurse2Code;
    }

    public String getScrubNurse3() {
        return scrubNurse3;
    }

    public void setScrubNurse3(String scrubNurse3) {
        this.scrubNurse3 = scrubNurse3;
    }

    public String getScrubNurse3Code() {
        return scrubNurse3Code;
    }

    public void setScrubNurse3Code(String scrubNurse3Code) {
        this.scrubNurse3Code = scrubNurse3Code;
    }

    public String getGreenChannel() {
        return greenChannel;
    }

    public void setGreenChannel(String greenChannel) {
        this.greenChannel = greenChannel;
    }

    public String getCirculatingReliefNurse1() {
        return circulatingReliefNurse1;
    }

    public void setCirculatingReliefNurse1(String circulatingReliefNurse1) {
        this.circulatingReliefNurse1 = circulatingReliefNurse1;
    }

    public String getCirculatingReliefNurse1Code() {
        return circulatingReliefNurse1Code;
    }

    public void setCirculatingReliefNurse1Code(String circulatingReliefNurse1Code) {
        this.circulatingReliefNurse1Code = circulatingReliefNurse1Code;
    }

    public String getCirculatingReliefDatetime1() {
        return circulatingReliefDatetime1;
    }

    public void setCirculatingReliefDatetime1(String circulatingReliefDatetime1) {
        this.circulatingReliefDatetime1 = circulatingReliefDatetime1;
    }

    public String getCirculatingReliefNurse2() {
        return circulatingReliefNurse2;
    }

    public void setCirculatingReliefNurse2(String circulatingReliefNurse2) {
        this.circulatingReliefNurse2 = circulatingReliefNurse2;
    }

    public String getCirculatingReliefNurse2Code() {
        return circulatingReliefNurse2Code;
    }

    public void setCirculatingReliefNurse2Code(String circulatingReliefNurse2Code) {
        this.circulatingReliefNurse2Code = circulatingReliefNurse2Code;
    }

    public String getCirculatingReliefDatetime2() {
        return circulatingReliefDatetime2;
    }

    public void setCirculatingReliefDatetime2(String circulatingReliefDatetime2) {
        this.circulatingReliefDatetime2 = circulatingReliefDatetime2;
    }

    public String getCirculatingReliefNurse3() {
        return circulatingReliefNurse3;
    }

    public void setCirculatingReliefNurse3(String circulatingReliefNurse3) {
        this.circulatingReliefNurse3 = circulatingReliefNurse3;
    }

    public String getCirculatingReliefNurse3Code() {
        return circulatingReliefNurse3Code;
    }

    public void setCirculatingReliefNurse3Code(String circulatingReliefNurse3Code) {
        this.circulatingReliefNurse3Code = circulatingReliefNurse3Code;
    }

    public String getCirculatingReliefDatetime3() {
        return circulatingReliefDatetime3;
    }

    public void setCirculatingReliefDatetime3(String circulatingReliefDatetime3) {
        this.circulatingReliefDatetime3 = circulatingReliefDatetime3;
    }

    public String getScrubReliefNurse1() {
        return scrubReliefNurse1;
    }

    public void setScrubReliefNurse1(String scrubReliefNurse1) {
        this.scrubReliefNurse1 = scrubReliefNurse1;
    }

    public String getScrubReliefNurse1Code() {
        return scrubReliefNurse1Code;
    }

    public void setScrubReliefNurse1Code(String scrubReliefNurse1Code) {
        this.scrubReliefNurse1Code = scrubReliefNurse1Code;
    }

    public String getScrubReliefDatetime1() {
        return scrubReliefDatetime1;
    }

    public void setScrubReliefDatetime1(String scrubReliefDatetime1) {
        this.scrubReliefDatetime1 = scrubReliefDatetime1;
    }

    public String getScrubReliefNurse2() {
        return scrubReliefNurse2;
    }

    public void setScrubReliefNurse2(String scrubReliefNurse2) {
        this.scrubReliefNurse2 = scrubReliefNurse2;
    }

    public String getScrubReliefNurse2Code() {
        return scrubReliefNurse2Code;
    }

    public void setScrubReliefNurse2Code(String scrubReliefNurse2Code) {
        this.scrubReliefNurse2Code = scrubReliefNurse2Code;
    }

    public String getScrubReliefDatetime2() {
        return scrubReliefDatetime2;
    }

    public void setScrubReliefDatetime2(String scrubReliefDatetime2) {
        this.scrubReliefDatetime2 = scrubReliefDatetime2;
    }

    public String getScrubReliefNurse3() {
        return scrubReliefNurse3;
    }

    public void setScrubReliefNurse3(String scrubReliefNurse3) {
        this.scrubReliefNurse3 = scrubReliefNurse3;
    }

    public String getScrubReliefNurse3Code() {
        return scrubReliefNurse3Code;
    }

    public void setScrubReliefNurse3Code(String scrubReliefNurse3Code) {
        this.scrubReliefNurse3Code = scrubReliefNurse3Code;
    }

    public String getScrubReliefDatetime3() {
        return scrubReliefDatetime3;
    }

    public void setScrubReliefDatetime3(String scrubReliefDatetime3) {
        this.scrubReliefDatetime3 = scrubReliefDatetime3;
    }

    public String getPostoperationDiagnosisCode() {
        return postoperationDiagnosisCode;
    }

    public void setPostoperationDiagnosisCode(String postoperationDiagnosisCode) {
        this.postoperationDiagnosisCode = postoperationDiagnosisCode;
    }

    public String getOperationStateNotfinalReason() {
        return operationStateNotfinalReason;
    }

    public void setOperationStateNotfinalReason(String operationStateNotfinalReason) {
        this.operationStateNotfinalReason = operationStateNotfinalReason;
    }

    public String getPostoperativeDeath() {
        return postoperativeDeath;
    }

    public void setPostoperativeDeath(String postoperativeDeath) {
        this.postoperativeDeath = postoperativeDeath;
    }

    public String getCheckedPerson() {
        return checkedPerson;
    }

    public void setCheckedPerson(String checkedPerson) {
        this.checkedPerson = checkedPerson;
    }

    public String getCheckedPersonCode() {
        return checkedPersonCode;
    }

    public void setCheckedPersonCode(String checkedPersonCode) {
        this.checkedPersonCode = checkedPersonCode;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getIsPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(String isPrinted) {
        this.isPrinted = isPrinted;
    }

    public String getOperationFinishstate() {
        return operationFinishstate;
    }

    public void setOperationFinishstate(String operationFinishstate) {
        this.operationFinishstate = operationFinishstate;
    }

    public String getReliefAnestheticDoctor() {
        return reliefAnestheticDoctor;
    }

    public void setReliefAnestheticDoctor(String reliefAnestheticDoctor) {
        this.reliefAnestheticDoctor = reliefAnestheticDoctor;
    }

    public String getReliefAnestheticDoctorCode() {
        return reliefAnestheticDoctorCode;
    }

    public void setReliefAnestheticDoctorCode(String reliefAnestheticDoctorCode) {
        this.reliefAnestheticDoctorCode = reliefAnestheticDoctorCode;
    }

    public String getAnestheticDoctorShiftDatetime() {
        return anestheticDoctorShiftDatetime;
    }

    public void setAnestheticDoctorShiftDatetime(String anestheticDoctorShiftDatetime) {
        this.anestheticDoctorShiftDatetime = anestheticDoctorShiftDatetime;
    }

    public String getReliefAnestheticAssistant1() {
        return reliefAnestheticAssistant1;
    }

    public void setReliefAnestheticAssistant1(String reliefAnestheticAssistant1) {
        this.reliefAnestheticAssistant1 = reliefAnestheticAssistant1;
    }

    public String getReliefAnestheticAssistant1Code() {
        return reliefAnestheticAssistant1Code;
    }

    public void setReliefAnestheticAssistant1Code(String reliefAnestheticAssistant1Code) {
        this.reliefAnestheticAssistant1Code = reliefAnestheticAssistant1Code;
    }

    public String getAnestheticAssistant1ShiftDatetime() {
        return anestheticAssistant1ShiftDatetime;
    }

    public void setAnestheticAssistant1ShiftDatetime(String anestheticAssistant1ShiftDatetime) {
        this.anestheticAssistant1ShiftDatetime = anestheticAssistant1ShiftDatetime;
    }

    public String getReliefAnestheticAssistant2() {
        return reliefAnestheticAssistant2;
    }

    public void setReliefAnestheticAssistant2(String reliefAnestheticAssistant2) {
        this.reliefAnestheticAssistant2 = reliefAnestheticAssistant2;
    }

    public String getReliefAnestheticAssistant2Code() {
        return reliefAnestheticAssistant2Code;
    }

    public void setReliefAnestheticAssistant2Code(String reliefAnestheticAssistant2Code) {
        this.reliefAnestheticAssistant2Code = reliefAnestheticAssistant2Code;
    }

    public String getAnestheticAssistant2ShiftDatetime() {
        return anestheticAssistant2ShiftDatetime;
    }

    public void setAnestheticAssistant2ShiftDatetime(String anestheticAssistant2ShiftDatetime) {
        this.anestheticAssistant2ShiftDatetime = anestheticAssistant2ShiftDatetime;
    }

    public String getReliefAnestheticAssistant3() {
        return reliefAnestheticAssistant3;
    }

    public void setReliefAnestheticAssistant3(String reliefAnestheticAssistant3) {
        this.reliefAnestheticAssistant3 = reliefAnestheticAssistant3;
    }

    public String getReliefAnestheticAssistant3Code() {
        return reliefAnestheticAssistant3Code;
    }

    public void setReliefAnestheticAssistant3Code(String reliefAnestheticAssistant3Code) {
        this.reliefAnestheticAssistant3Code = reliefAnestheticAssistant3Code;
    }

    public String getAnestheticAssistant3ShiftDatetime() {
        return anestheticAssistant3ShiftDatetime;
    }

    public void setAnestheticAssistant3ShiftDatetime(String anestheticAssistant3ShiftDatetime) {
        this.anestheticAssistant3ShiftDatetime = anestheticAssistant3ShiftDatetime;
    }
}
