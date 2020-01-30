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

    private String units;

    /**
     * 用于程度比较，程度越严重，值越大
     */
    private Integer valueLevel;

    /**
     * 项目类型
     * 评估类型:I
     * 措施类型:M
     * 公共类型:C
     */
    @Column(name = "TYPE",columnDefinition = "I",nullable = false)
    private String type;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
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

    public Integer getValueLevel() {
        return valueLevel;
    }

    public void setValueLevel(Integer valueLevel) {
        this.valueLevel = valueLevel;
    }
}
