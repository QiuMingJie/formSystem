package com.qiumingjie.entities.evaluate.table;

import com.qiumingjie.entities.evaluate.dict.RelationKeys;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 22:00
 * @description 储存表单记录的值
 */
@Entity
@Table(name = "FORM_VALUE")
public class FormValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体form的id，为字典表id+五位数
     */
    @EmbeddedId
    private RelationKeys id;

    @Column
    private String value;

    @Column(name = "CREATE_DATE_TIME")
    private String createDateTime;

    @Column(name = "delete_flag")
    private Boolean deleteFlag;

    @Column(name = "MODIFY_DATE_TIME")
    private String modifyDateTime;


    public RelationKeys getId() {
        return id;
    }

    public void setId(RelationKeys id) {
        this.id = id;
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

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getModifyDateTime() {
        return modifyDateTime;
    }

    public void setModifyDateTime(String modifyDateTime) {
        this.modifyDateTime = modifyDateTime;
    }
}
