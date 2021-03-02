package com.qiumingjie.entities.formSystem.info;

import lombok.Data;

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
@Table(name = "V_OPS_QUEUE")
@Data
public class OpsQueue {

    @Id
    private String operationId;

    @NotEmpty(message = "patientId不可以为空")
    @Column(length = 100, name = "patientID", columnDefinition = "varchar(100)")
    private String patientId;
    @Column(length = 100, columnDefinition = "varchar(100)", name = "outpatientID")
    private String outpatientId;
    @Column(length = 100, columnDefinition = "varchar(100)", name = "inpatientID")
    private String inpatientId;
    @Column(length = 100, columnDefinition = "varchar(100)", name = "patient_dept")
    private String patientDept;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientWard;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String patientBed;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationRoom;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String roomName;
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
    @Column(length = 100, columnDefinition = "varchar(100)", name = "emergencyOrNot")
    private String emergencyOrNot;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationDept;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String applicationPerson;
    @Column(name = "condition ", length = 100, columnDefinition = "varchar(100)")
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
    @Column(length = 100, columnDefinition = "varchar(100)",name = "patient_DepRoom")
    private String patientDeptRoom;
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
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation1_code")
    private String intendedOperation1Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation2_code")
    private String intendedOperation2Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation3_code")
    private String intendedOperation3Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation4_code")
    private String intendedOperation4Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation5_code")
    private String intendedOperation5Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "intended_operation6_code")
    private String intendedOperation6Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationMethodPostCode;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_method_post2_code")
    private String operationMethodPost2Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_method_post3_code")
    private String operationMethodPost3Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_method_post4_code")
    private String operationMethodPost4Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_method_post5_code")
    private String operationMethodPost5Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_method_post6_code")
    private String operationMethodPost6Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticMethodCode;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationDoctorCode;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_assistant1_code")
    private String operationAssistant1Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_assistant2_code")
    private String operationAssistant2Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_assistant3_code")
    private String operationAssistant3Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_assistant4_code")
    private String operationAssistant4Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "operation_assistant5_code")
    private String operationAssistant5Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String anestheticDoctorCode;
    @Column(length = 100, columnDefinition = "varchar(100)",name="anesthetic_assistant1_code")
    private String anestheticAssistant1Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name="anesthetic_assistant2_code")
    private String anestheticAssistant2Code;
    @Column(length = 100, columnDefinition = "varchar(100)",name="anesthetic_assistant3_code")
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
    @Column(length = 100, columnDefinition = "varchar(100)",name = "circulating_nurse2_code")
    private String circulatingNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "circulating_nurse3_code")
    private String circulatingNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse2;
    @Column(length = 100, columnDefinition = "varchar(100)",name="scrub_nurse2_code")
    private String scrubNurse2Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String scrubNurse3;
    @Column(length = 100, columnDefinition = "varchar(100)",name = "scrub_nurse3_code")
    private String scrubNurse3Code;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String greenChannel;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String circulatingReliefNurse1;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "circulating_relief_nurse1_code")
//    private String circulatingReliefNurse1Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String circulatingReliefDatetime1;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String circulatingReliefNurse2;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "circulating_relief_nurse2_code")
//    private String circulatingReliefNurse2Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String circulatingReliefDatetime2;
//    @Column(length = 100, columnDefinition = "varchar(100))
//    private String circulatingReliefNurse3;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "circulating_relief_nurse3_code")
//    private String circulatingReliefNurse3Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String circulatingReliefDatetime3;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefNurse1;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "scrub_relief_nurse1_code")
//    private String scrubReliefNurse1Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefDatetime1;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefNurse2;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "scrub_relief_nurse2_code")
//    private String scrubReliefNurse2Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefDatetime2;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefNurse3;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "scrub_relief_nurse3_code")
//    private String scrubReliefNurse3Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String scrubReliefDatetime3;
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
    @Column(length = 100, columnDefinition = "varchar(100)", name = "isPrinted")
    private String isPrinted;
//    @Column(length = 100, columnDefinition = "varchar(100)", name = "DaySurgery")
//    private String daySurgery;
    @Column(length = 100, columnDefinition = "varchar(100)")
    private String operationFinishstate;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String reliefAnestheticDoctor;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String reliefAnestheticDoctorCode;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String anestheticDoctorShiftDatetime;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String reliefAnestheticAssistant1;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "anesthetic_assistant1_code")
//    private String reliefAnestheticAssistant1Code;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "anesthetic_assistant1_shift_datetime")
//    private String anestheticAssistant1ShiftDatetime;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String reliefAnestheticAssistant2;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "anesthetic_assistant2_code")
//    private String reliefAnestheticAssistant2Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String anestheticAssistant2ShiftDatetime;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String reliefAnestheticAssistant3;
//    @Column(length = 100, columnDefinition = "varchar(100)",name = "anesthetic_assistant3_code")
//    private String reliefAnestheticAssistant3Code;
//    @Column(length = 100, columnDefinition = "varchar(100)")
//    private String anestheticAssistant3ShiftDatetime;
}