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

    private String signer;

    private String recordDateTime;

    @JsonIgnore
    private String formName;

    @JsonIgnore
    private String type;

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

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public String getRecordDateTime() {
        return recordDateTime;
    }

    public void setRecordDateTime(String recordDateTime) {
        this.recordDateTime = recordDateTime;
    }
}
