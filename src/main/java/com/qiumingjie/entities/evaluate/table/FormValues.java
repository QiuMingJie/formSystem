package com.qiumingjie.entities.evaluate.table;

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
@Table(name = "FORM_VALUES")
public class FormValues {
    @Id
    private String formId;

    private String templateFormId;

    @Column(length = 8000)
    private String value;

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
