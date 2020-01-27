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
import com.qiumingjie.utils.Norm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler addFormDict(FormDictDto formDictDto) {
        formDictDto.initRelation();
        formDictRepository.save(CopyUtils.convertExtend(formDictDto, new FormDict()));
        itemDictRepository.saveAll(formDictDto.getItemDictList());
        relationRepository.saveAll(formDictDto.getRelationList());
        return JsonHandler.succeed(formDictDto);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler deleteFormDict(String formId, Boolean deleteItem) {
        StringBuilder soutResult = new StringBuilder();
        Optional<FormDict> formDict = formDictRepository.findById(formId);
        if (formDict.isPresent()) {
            soutResult.append("删除字典表:").append(formDict.get().getFormId()).append(formDict.get().getFormName());
            formDictRepository.deleteById(formId);
        } else {
            soutResult.append("字典表不存在").append(formId);
        }
        soutResult.append(Norm.soutBank);
        //删除关系表
        List<Relation> relationList = relationRepository.findAllById_FormId(formId);
        if (CommonUtils.notEmpty(relationList)) {
            for (Relation relation : relationList) {
                soutResult.append("删除对应关系表:").append(relation.getId().getFormId()).append("->").append(relation.getId().getItemId());
                relationRepository.delete(relation);
                soutResult.append(Norm.soutBank);
                //是否删除项目
                if (deleteItem) {
                    Optional<ItemDict> itemDict = itemDictRepository.findById(relation.getId().getItemId());
                    if (itemDict.isPresent()) {
                        soutResult.append("删除项目字典表:").append(itemDict.get().getItemId()).append(itemDict.get().getContent());
                        itemDictRepository.deleteById(relation.getId().getItemId());
                    } else {
                        soutResult.append("不存在项目字典").append(relation.getId().getItemId());
                    }
                    soutResult.append(Norm.soutBank);
                }
            }
        } else {
            soutResult.append("关联关系不存在");
            soutResult.append(Norm.soutBank);
        }
        return JsonHandler.succeed(soutResult);
    }

    public JsonHandler getFormById(String formId) {
        FormDictDto formDictDto = new FormDictDto();
        Optional<FormDict> formDict = formDictRepository.findById(formId);
        if (formDict.isPresent()) {
            if (CopyUtils.convertExtend(formDictDto, formDict) instanceof FormDictDto) {
                formDictDto= (FormDictDto)CopyUtils.convertExtend(formDictDto, formDict.get());
            }else {
                JsonHandler.fail("父类子类转化异常");
            }
        }
        List<String> itemIdList=new ArrayList<>();
        List<Relation> allRelation = relationRepository.findAllById_FormId(formId);
        allRelation.forEach(x->itemIdList.add(x.getId().getItemId()));
        formDictDto.setItemDictList(itemDictRepository.findAllById(itemIdList));
        return JsonHandler.succeed(formDictDto);
    }

}
