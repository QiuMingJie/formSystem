package com.qiumingjie.entities.evaluate;

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
public class ItemDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ITEM_ID")
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
    private String used;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }
}
