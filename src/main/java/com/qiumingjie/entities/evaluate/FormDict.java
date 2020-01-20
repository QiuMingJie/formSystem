package com.qiumingjie.entities.evaluate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:16
 * @description 表格实体
 */

@Entity
@Table(name = "FORM_DICT")
public class FormDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FORM_ID")
    private String formId;

    @Column(name = "FORM_NAME")
    private String formName;

    @Column(name = "FORM_TYPE")
    private String formType;

    @Column(name = "USED")
    private Boolean used;

    @Column(name = "DELETE")
    private Boolean delete;

    @Column(name = "CREATE_DATE_TIME")
    private String createDateTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }
}
