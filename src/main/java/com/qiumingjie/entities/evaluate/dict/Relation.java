package com.qiumingjie.entities.evaluate.dict;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:49
 * @description 每一个评估单关联的项目
 */
@Entity
public class Relation implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RelationKeys id;

    private Date createDateTime;


    public Date getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(Date createDateTime) {
        this.createDateTime = createDateTime;
    }

    public RelationKeys getId() {
        return id;
    }

    public void setId(RelationKeys id) {
        this.id = id;
    }

    public Relation(RelationKeys id) {
        this.id = id;
    }

    public Relation(String formId, String itemId,Date createDateTime) {
        this.setId(new RelationKeys(formId, itemId));
        this.setCreateDateTime(createDateTime);
    }

    public Relation() {
    }
}
