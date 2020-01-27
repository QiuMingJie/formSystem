package com.qiumingjie.entities.evaluate.dict;

import com.qiumingjie.entities.evaluate.table.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:39
 * @description 项目字典表
 */
@Entity
public class ItemDict extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ITEM_ID")
    private String itemId;

    @Column(name = "CONTENT")
    private String content;

    /**
     * 项目类型
     */
    @Column(name = "TYPE")
    private String type;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
