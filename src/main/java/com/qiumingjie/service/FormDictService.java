package com.qiumingjie.service;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.entities.evaluate.dict.FormDict;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-01-27 0:39
 * @description
 */
@Service
public class FormDictService {
    @Resource
    private FormDictRepository formDictRepository;

    public Optional<FormDict> existFormDict(String templateFormId) {
        return formDictRepository.findById(templateFormId);
    }

    public List<FormDict> getAllForm() {
        return formDictRepository.findAll();
    }
}

