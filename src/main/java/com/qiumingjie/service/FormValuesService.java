package com.qiumingjie.service;

import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.dao.table.FormValuesRepository;
import com.qiumingjie.entities.evaluate.dict.FormDict;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormValues;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:37
 * @description
 */
@Service
public class FormValuesService {
    @Resource
    private FormValuesRepository formValuesRepository;

    @Resource
    private FormDictService formDictService;

    @Resource
    private FormMainRepository formMainRepository;

    public Optional<FormValues> getById(String id) {
        return formValuesRepository.findById(id);
    }

    public List<FormValues> getAllForm() {
        return formValuesRepository.findAll();
    }

    public JsonHandler saveOrUpdateNew(FormValues formValues) {
        if (CommonUtils.empty(formValues.getFormId())) {
            //不存在formId则是新建操作！
            if (CommonUtils.empty(formValues.getTemplateFormId())) {
                return JsonHandler.fail("新建表单失败：获取模板表单id失败");
            }
            Optional<FormDict> formDict=formDictService.existFormDict(formValues.getTemplateFormId());
            if (!formDict.isPresent()) {
                return JsonHandler.fail("新建表单失败：表单模板不存在");
            }
            //暂时不知道怎么获取创建者
//            formValues.setCreator("？？");
            FormMain formMainByFormIdOrderByFormIdDesc =formMainRepository.findFormMainBytemplateIdLike(formValues.getFormId()).get(0);
            if (CommonUtils.empty(formMainByFormIdOrderByFormIdDesc) || formMainByFormIdOrderByFormIdDesc.getFormId() == null) {
                formValues.setFormId(FormUtil.caculFormEntityId(formValues.getTemplateFormId()));
            }else {
                formValues.setFormId(FormUtil.caculFormEntityId(formMainByFormIdOrderByFormIdDesc.getFormId()));
            }
        }
        FormMain formMain = CopyUtils.transfer(formValues, new FormMain());
        formMainRepository.save(formMain);
        formValuesRepository.saveAndFlush(formValues);
        return JsonHandler.succeed(formValuesRepository.findById(formValues.getFormId()).get());
    }

    public void deleteForm(String id) {
         formValuesRepository.deleteById(id);
    }

}
