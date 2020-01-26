package com.qiumingjie.entities.evaluate.dict;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

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

    @Column(name = "CONTENT")
    private String content;

    /**
     * 项目类型
     */
    @Column(name = "TYPE")
    private String type;

    @Column(name = "CREATE_DATE_TIME")
    private Date createDateTime;

    @Column(name = "USE_flag")
    private String useFlag;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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


    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }
}
