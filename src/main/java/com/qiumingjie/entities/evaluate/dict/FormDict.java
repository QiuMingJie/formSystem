package com.qiumingjie.entities.evaluate.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "USE_FLAG")
    private Boolean useFlag;

    @Column(name = "DELETE_FLAG")
    private Boolean deleteFlag;

    @Column(name = "CREATE_DATE_TIME")
    private Date createDateTime;

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Boolean getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Boolean useFlag) {
        this.useFlag = useFlag;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }
}
