package com.qiumingjie.dto;

import com.qiumingjie.entities.evaluate.table.FormTemplate;
import com.qiumingjie.entities.info.OpsQueue;
import com.qiumingjie.entities.info.PatientInfo;

/**
 * @author QiuMingJie
 * @date 2020-03-16 16:08
 * @description
 */
public class FormTemplateDto extends FormTemplate {

    private OpsQueue operation;

    private PatientInfo patientInfo;

    public OpsQueue getOperation() {
        return operation;
    }

    public void setOperation(OpsQueue operation) {
        this.operation = operation;
    }

    public PatientInfo getPatientInfo() {
        return patientInfo;
    }

    public void setPatientInfo(PatientInfo patientInfo) {
        this.patientInfo = patientInfo;
    }
}
