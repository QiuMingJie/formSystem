package com.qiumingjie.dto;

import com.qiumingjie.entities.evaluate.dict.FormDict;
import com.qiumingjie.entities.evaluate.dict.ItemDict;
import com.qiumingjie.entities.evaluate.dict.Relation;
import com.qiumingjie.utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-22 12:42
 * @description 表格存在数据库中的方式
 */
public class FormDictDto extends FormDict {

    private List<ItemDict> itemDictList = new ArrayList<>();

    private List<Relation> relationList = new ArrayList<>();

    /**
     * 初始化对应表
     */
    public void initRelation() {
        if (CommonUtils.notEmpty(itemDictList)) {
            for (ItemDict itemDict : itemDictList) {
                relationList.add(new Relation(this.getFormDictId(), itemDict.getItemId(), null));
            }
        }
    }

    public List<ItemDict> getItemDictList() {
        return itemDictList;
    }

    public void setItemDictList(List<ItemDict> itemDictList) {
        this.itemDictList = itemDictList;
    }

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }
}
