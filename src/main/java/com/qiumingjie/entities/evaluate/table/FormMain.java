package com.qiumingjie.entities.evaluate.table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-21 17:15
 * @description
 */
@Entity
public class FormMain extends FormTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FORM_ID")
    private String formId;

    private String creator;

    private String recordDateTime;

    private String formType;

    /**
     * 签名标志，为true则已经签名，不可以再改
     */
    private Boolean signFlag;

    @JsonIgnore
    private String formName;

    @JsonIgnore
    private String type;

    @Override
    public Boolean getSignFlag() {
        return signFlag;
    }

    @Override
    public void setSignFlag(Boolean signFlag) {
        this.signFlag = signFlag;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(String recordDateTime) {
        this.recordDateTime = recordDateTime;
    }
}
