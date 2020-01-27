package com.qiumingjie.service;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.entities.evaluate.dict.FormDict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-01-27 0:39
 * @description
 */
@Service
public class FormDictService {
    @Resource
    FormDictRepository formDictRepository;

    public Boolean existFormDict(String templateFormId) {
        Optional<FormDict> formDict = formDictRepository.findById(templateFormId);
        return formDict.isPresent();
    }
}

