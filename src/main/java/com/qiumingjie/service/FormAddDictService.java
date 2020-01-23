package com.qiumingjie.service;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.dict.ItemDictRepository;
import com.qiumingjie.dao.dict.RelationRepository;
import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.handler.JsonHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
        formDictRepository.save(formDictDto);
        itemDictRepository.saveAll(formDictDto.getItemDictList());
        relationRepository.saveAll(formDictDto.getRelationList());
        return JsonHandler.succeed(formDictDto);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler deleteFormDict(FormDictDto formDictDto) {
        formDictRepository.deleteById(formDictDto.getFormId());
        itemDictRepository.deleteInBatch(formDictDto.getItemDictList());
        relationRepository.deleteInBatch(formDictDto.getRelationList());
        return JsonHandler.succeed();
    }

    public JsonHandler getFormById(String formId) {
        formDictRepository.findById(formId);
        return null;
    }

}
