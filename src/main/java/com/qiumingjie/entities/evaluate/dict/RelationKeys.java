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

    public RelationKeys(String formDictId, String itemId) {
        this.formDictId = formDictId;
        this.itemId = itemId;
    }

    public RelationKeys() {
    }

    private String formDictId;

    private String itemId;

    public String getFormDictId() {
        return formDictId;
    }

    public void setFormDictId(String formDictId) {
        this.formDictId = formDictId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
