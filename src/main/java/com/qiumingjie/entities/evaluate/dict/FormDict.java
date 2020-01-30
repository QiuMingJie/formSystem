package com.qiumingjie.entities.evaluate.dict;

import com.qiumingjie.entities.evaluate.table.BaseEntity;

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
public class FormDict extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FORM_DICT_ID")
    private String formDictId;

    @Column(name = "FORM_NAME")
    private String formName;

    @Column(name = "FORM_TYPE")
    private String formType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFormDictId() {
        return formDictId;
    }

    public void setFormDictId(String formDictId) {
        this.formDictId = formDictId;
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
}
