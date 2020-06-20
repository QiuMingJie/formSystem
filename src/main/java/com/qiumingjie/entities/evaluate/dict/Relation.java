package com.qiumingjie.entities.evaluate.dict;

import com.qiumingjie.entities.evaluate.table.BaseEntity;

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
public class Relation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RelationKeys id;

    public Relation(String formDictId, String itemId, Date createDateTime) {
        this.setId(new RelationKeys(formDictId, itemId));
//        this.setCreateDateTime(createDateTime);
    }

    public Relation() {
    }

    public RelationKeys getId() {
        return id;
    }

    public void setId(RelationKeys id) {
        this.id = id;
    }
}
