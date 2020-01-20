package com.qiumingjie.entities.evaluate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:39
 * @description 项目字典表
 */
@Entity(name = "ITEM_DICT")
public class ItemDict {

    private static final long serialVersionUID = 1L;

    @Id
    private String itemId;

    @Column(name = "DESC")
    private String desc;

    /**
     * 项目类型
     */
    @Column(name = "TYPE")
    private String type;

    @Column(name = "CREATE_DATE_TIME")
    private String createDateTime;

    @Column(name = "USED")
    private Boolean used;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(String createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Boolean getUsed() {
        return used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }
}
