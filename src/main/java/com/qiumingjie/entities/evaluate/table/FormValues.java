package com.qiumingjie.entities.evaluate.table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:30
 * @description 直接暴力存表
 */
@Entity
@DynamicUpdate
@Table(name = "FORM_VALUES")
public class FormValues extends FormTemplate {
    @Id
    private String formId;

    private String templateFormId;

    private String templateName;

    private String creator;

    private String signer;

    private String recordDateTime;

    @Column(length = 8000)
    private String value;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSigner() {
        return signer;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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

    public String getFormId() {
        return formId;
    }

    public String getTemplateFormId() {
        return templateFormId;
    }

    public void setTemplateFormId(String templateFormId) {
        this.templateFormId = templateFormId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
