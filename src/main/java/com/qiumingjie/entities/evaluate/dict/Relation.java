package com.qiumingjie.entities.evaluate.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:49
 * @description 每一个评估单关联的项目
 */
@Entity
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "FORM_ID")
    private String formId;

    @Id
    @Column(name = "ITEM_ID")
    private String itemId;

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
