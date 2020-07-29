package com.qiumingjie.entities.formSystem.evaluate.table;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-21 17:44
 * @description 表格模板表，
 */
@MappedSuperclass
public class FormTemplate extends BaseEntity implements Serializable {

    @Id
    private String formId;

    private String operationId;

    private String templateFormId;

    private String templateName;

    private String creator;


    private String recordDateTime;

    @Column(columnDefinition = "varchar(max)")
    private String value;

    private String info;
    /**
     * 患者部分
     */
    private String patientId;

    @Column(columnDefinition = "varchar(max)")
    private String afterSignValue;

    /**
     * 签名部分
     */
    private Boolean signFlag;


    /**
     * 归档标志
     */
    private Boolean archiveFlag;

    public String getAfterSignValue() {
        return afterSignValue;
    }

    public void setAfterSignValue(String afterSignValue) {
        this.afterSignValue = afterSignValue;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Boolean getSignFlag() {
        return signFlag;
    }

    public void setSignFlag(Boolean signFlag) {
        this.signFlag = signFlag;
    }

    public Boolean getArchiveFlag() {
        return archiveFlag;
    }

    public void setArchiveFlag(Boolean archiveFlag) {
        this.archiveFlag = archiveFlag;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getTemplateFormId() {
        return templateFormId;
    }

    public void setTemplateFormId(String templateFormId) {
        this.templateFormId = templateFormId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
