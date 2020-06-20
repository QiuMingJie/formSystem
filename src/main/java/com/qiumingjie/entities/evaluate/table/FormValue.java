package com.qiumingjie.entities.evaluate.table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qiumingjie.entities.evaluate.dict.RelationKeys;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 22:00
 * @description 储存表单记录的值
 */
@Entity
@Table(name = "FORM_VALUE")
public class FormValue extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 实体form的id，为字典表id+五位数
     */
    @EmbeddedId
    private RelationKeys id;

    @JsonIgnore
    @Transient
    private String itemId;

    @Column
    private String value;

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

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.getId().setItemId(itemId);
        this.itemId = itemId;
    }
}
