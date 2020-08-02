package com.qiumingjie.entities.formSystem.evaluate.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-21 17:15
 * @description 字典表
 */
@Entity
@Data
public class FormMain extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String formId;

    private String operationId;

    private String templateFormId;

    private String templateName;

    private String patientId;

    private String creator;

    private String recordDateTime;

    private String formType;

    /**
     * 归档标志
     */
    private Boolean archiveFlag;

    /**
     * 签名标志，为true则已经签名，不可以再改
     */
    private Boolean signFlag;

    @JsonIgnore
    private String type;
}
