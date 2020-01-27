package com.qiumingjie.service;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.dict.ItemDictRepository;
import com.qiumingjie.dao.dict.RelationRepository;
import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.dao.table.FormValueRepository;
import com.qiumingjie.dto.FormDataDto;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author QiuMingJie
 * @date 2020-01-27 0:19
 * @description
 */
@Service
public class FormAddValueService {

    @Resource
    private FormDictRepository formDictRepository;

    @Resource
    private FormMainRepository formMainRepository;

    @Resource
    private FormValueRepository formValueRepository;

    @Resource
    private ItemDictRepository itemDictRepository;

    @Resource
    private RelationRepository relationRepository;


    public JsonHandler addFrom(FormDataDto formDataDto) {
        String templateFromId = formDataDto.getTemplateFormId();
//        formDataDto.setCreateDateTime(new Date());
        //暂时不知道怎么获取创建者
        formDataDto.setCreator("!!");
        FormMain formMainByFormIdOrderByFormIdDesc = formMainRepository.findFormMainByFormIdOrderByFormIdDesc(formDataDto.getFormId());
        if (CommonUtils.empty(formMainByFormIdOrderByFormIdDesc) || formMainByFormIdOrderByFormIdDesc.getFormId() == null) {

        }
        return null;
    }
}
