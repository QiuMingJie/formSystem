package com.qiumingjie.service;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.dict.ItemDictRepository;
import com.qiumingjie.dao.dict.RelationRepository;
import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.entities.evaluate.dict.FormDict;
import com.qiumingjie.entities.evaluate.dict.ItemDict;
import com.qiumingjie.entities.evaluate.dict.Relation;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:11
 * @description
 */
@Service
public class FormAddDictService {

    @Resource
    private FormDictRepository formDictRepository;

    @Resource
    private ItemDictRepository itemDictRepository;

    @Resource
    private RelationRepository relationRepository;

    private List<Map> itemHeadToNextItemInt;

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler addFormDict(FormDictDto formDictDto) {
        itemHeadToNextItemInt = itemDictRepository.findItemHeadAndNextInt();
        for (ItemDict itemDict : formDictDto.getItemDictList()) {
            if (CommonUtils.empty(itemDict.getType())) {
                itemDict.setType("I");
            }
            String itemDictHead = FormUtil.getItemDictHead(formDictDto.getFormDictId(), itemDict.getType());
            Integer nextIntFromListMap = getNextIntFromListMap(itemDictHead);
            ItemDict exist = itemDictRepository.findFirstByItemIdStartingWithAndContentContainsAndDeleteFlagIsNullAndUseFlagIsNullAndRemarkIsAndUnitsIsAndValueLevelIs(itemDictHead, itemDict.getContent(),itemDict.getRemark(),itemDict.getUnits(),itemDict.getValueLevel());
            if (CommonUtils.notEmpty(exist)) {
                itemDict.setItemId(exist.getItemId());
            } else {
                itemDict.setItemId(FormUtil.caculItemDictId(itemDictHead, nextIntFromListMap));
            }
        }
        formDictDto.initRelation();
        formDictRepository.save(CopyUtils.transfer(formDictDto, new FormDict()));
        itemDictRepository.saveAll(formDictDto.getItemDictList());
        relationRepository.saveAll(formDictDto.getRelationList());
        return JsonHandler.succeed(formDictDto);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler deleteFormDict(String formId, Boolean deleteItem) {
        StringBuilder soutResult = new StringBuilder();
        Optional<FormDict> formDict = formDictRepository.findById(formId);
        if (formDict.isPresent()) {
            soutResult.append("删除字典表:").append(formDict.get().getFormDictId()).append(formDict.get().getFormName());
            formDictRepository.deleteById(formId);
        } else {
            soutResult.append("字典表不存在").append(formId);
        }
        soutResult.append(FormUtil.soutBank);
        //删除关系表
        List<Relation> relationList = relationRepository.findAllById_FormDictId(formId);
        if (CommonUtils.notEmpty(relationList)) {
            for (Relation relation : relationList) {
                soutResult.append("删除对应关系表:").append(relation.getId().getFormDictId()).append("->").append(relation.getId().getItemId());
                relationRepository.delete(relation);
                soutResult.append(FormUtil.soutBank);
                //是否删除项目
                if (deleteItem) {
                    //安全删除，先判断是否有多个引用，有的话不删
                    List<Relation> relations = relationRepository.findAllById_ItemId(relation.getId().getItemId());
                    if (relations.size() == 0) {
                        Optional<ItemDict> itemDict = itemDictRepository.findById(relation.getId().getItemId());
                        if (itemDict.isPresent()) {
                            soutResult.append("删除项目字典表:").append(itemDict.get().getItemId()).append(itemDict.get().getContent());
                            itemDictRepository.deleteById(relation.getId().getItemId());
                        } else {
                            soutResult.append("不存在项目字典").append(relation.getId().getItemId());
                        }
                    }else {
                        soutResult.append("多个引用项目字典不删除").append(relation.getId().getItemId());
                    }
                    soutResult.append(FormUtil.soutBank);
                }
            }
        } else {
            soutResult.append("关联关系不存在");
            soutResult.append(FormUtil.soutBank);
        }
        return JsonHandler.succeed(soutResult);
    }

    public String gettest() {
        return "11";
    }
    public JsonHandler getFormById(String formId) {
        FormDictDto formDictDto = new FormDictDto();
        Optional<FormDict> formDict = formDictRepository.findById(formId);
        if (formDict.isPresent()) {
            formDictDto = CopyUtils.transfer(formDict.get(), formDictDto);
        }
        List<String> itemIdList = new ArrayList<>();
        List<Relation> allRelation = relationRepository.findAllById_FormDictId(formId);
        allRelation.forEach(x -> itemIdList.add(x.getId().getItemId()));
        formDictDto.setItemDictList(itemDictRepository.findAllById(itemIdList));
        return JsonHandler.succeed(formDictDto);
    }


    /**
     * 感觉头部遍历list获得下一个数字，之后将headToNextInt自动加1
     * <p>
     * itemHeadToNextItemInt itemIdHead->I0001,itemIdNextInt -> 2 || itemIdHead->M0001,itemIdNextInt -> 3
     *
     * @param itemDictHead I0001
     * @return 2
     */
    private Integer getNextIntFromListMap(String itemDictHead) {
        for (Map map : itemHeadToNextItemInt) {
            if (String.valueOf(map.get("itemIdHead")).equals(itemDictHead)) {
                map.put("itemIdNextInt", (Integer) map.get("itemIdNextInt") + 1);
                return (Integer) map.get("itemIdNextInt") - 1;
            }
        }
        Map newMap = new HashMap();
        newMap.put("itemIdHead", itemDictHead);
        newMap.put("itemIdNextInt", 2);
        itemHeadToNextItemInt.add(newMap);
        return 1;
    }
}
