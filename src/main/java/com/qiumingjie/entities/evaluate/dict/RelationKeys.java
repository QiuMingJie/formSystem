package com.qiumingjie.entities.evaluate.dict;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:08
 * @description
 */
@Embeddable
public class RelationKeys implements Serializable {

    public RelationKeys(String formId, String itemId) {
        this.formId = formId;
        this.itemId = itemId;
    }

    public RelationKeys() {
    }

    private String formId;

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
