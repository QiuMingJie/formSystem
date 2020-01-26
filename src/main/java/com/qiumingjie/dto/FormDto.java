package com.qiumingjie.dto;

import com.qiumingjie.entities.evaluate.dict.FormDict;
import com.qiumingjie.entities.evaluate.dict.ItemDict;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:18
 * @description 返回给前端
 */
public class FormDto extends FormDict {
    private List<ItemDict> itemDictList = new ArrayList<>();

    public List<ItemDict> getItemDictList() {
        return itemDictList;
    }

    public void setItemDictList(List<ItemDict> itemDictList) {
        this.itemDictList = itemDictList;
    }
}
