package com.qiumingjie.entities.formSystem.evaluate.table;

import lombok.Data;

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
@Data
public class FormTemplate extends BaseEntity implements Serializable {

    @Id
    private String formId;

    private String operationId;

    private String templateFormId;

    private String templateName;

    private Integer userId;

    private String recordDateTime;

    //表单的值
    @Column(columnDefinition = "varchar(max)")
    private String value;

    //给前端储存的
    private String info;
    /**
     * 患者部分
     */
    private String patientId;


}
