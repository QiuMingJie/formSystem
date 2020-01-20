package com.qiumingjie.entities.evaluate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 22:00
 * @description 储存表单记录的值
 */
@Table(name = "FORM_VALUE")
public class FormValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Relation relation;

    @Column
    private String value;

    @Column(name = "CREATE_DATE_TIME")
    private String createDateTime;

    @Column(name = "delete")
    private Boolean delete;

    @Column(name = "MODIFY_DATE_TIME")
    private String modifyDateTime;

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public String getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(String modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }
}
