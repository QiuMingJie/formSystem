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
    //表单id
    private String formId;

    //操作者id，创建者id
    private String operationId;

    //模板id
    private String templateFormId;

    //表单名
    private String templateName;

    //用户id
    private Integer userId;

    private String recordDateTime;

    //表单的值
    @Column(columnDefinition = "varchar(max)")
    private String value;

    //
    private String info;
    /**
     * 患者部分
     */
    private String patientId;


}
