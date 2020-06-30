package com.qiumingjie.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-06-30 11:36
 * @description
 */
@Entity
@Table(name = "FormCollection")
public class FormCollection  {

    @Id
    String formId;

    String patientId;

    /**
     * 归档标志
     */
    Boolean isCollection;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Boolean getCollection() {
        return isCollection;
    }

    public void setCollection(Boolean collection) {
        isCollection = collection;
    }
}
