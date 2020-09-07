package com.qiumingjie.service;

import com.qiumingjie.dao.formSystem.dict.FormDictRepository;
import com.qiumingjie.entities.formSystem.evaluate.dict.FormDict;
import com.qiumingjie.utils.CommonUtils;
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

    public List<FormDict> getFormByRole(String roleName) {
        if (CommonUtils.empty(roleName)) {
            return null;
        }
        String formDictHeadByRoleName = getFormDictHeadByRoleName(roleName);
        if ("all".equals(formDictHeadByRoleName)) {
            return getAllForm();
        }
        if (CommonUtils.empty(formDictHeadByRoleName)) {
            return null;
        }
        return formDictRepository.findAllByFormDictIdLike(formDictHeadByRoleName+"%");
    }

    /**
     * 医生-->E0002
     * 护士-->E0003
     * 管理员-->all
     *
     * @return
     */
    public String getFormDictHeadByRoleName(String roleName) {
        if (roleName.contains("护士")) {
            return "E0002";
        }
        if (roleName.contains("医生")) {
            return "E0003";
        }
        if (roleName.contains("管理")) {
            return "all";
        }
        return "";
    }

}

