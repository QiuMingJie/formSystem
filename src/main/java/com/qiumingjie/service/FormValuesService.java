package com.qiumingjie.service;

import com.qiumingjie.dao.RepositoryContext;
import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.entities.evaluate.dict.FormDict;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormTemplate;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.data.jpa.repository.JpaRepository;
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
    private RepositoryContext repositoryContext;

    @Resource
    private FormDictService formDictService;

    @Resource
    private FormMainRepository formMainRepository;


    public JsonHandler saveOrUpdateNew(FormTemplate formValues) {
        JpaRepository repository = repositoryContext.getRepository(formValues.getTemplateFormId());
        if (CommonUtils.empty(formValues.getFormId())) {
            //不存在formId则是新建操作！
            if (CommonUtils.empty(formValues.getTemplateFormId())) {
                return JsonHandler.fail("新建表单失败：获取模板表单id失败");
            }
            Optional<FormDict> formDict = formDictService.existFormDict(formValues.getTemplateFormId());
            if (!formDict.isPresent()) {
                return JsonHandler.fail("新建表单失败：表单模板不存在");
            }
            //暂时不知道怎么获取创建者
//            formValues.setCreator("？？");
            List<FormMain> formMainBytemplateIdLike = formMainRepository.findFormMainBytemplateIdLike(formValues.getTemplateFormId());
            if (CommonUtils.empty(formMainBytemplateIdLike) || formMainBytemplateIdLike.size() == 0) {
                formValues.setFormId(FormUtil.caculFormEntityId(formValues.getTemplateFormId()));
            } else {
                formValues.setFormId(FormUtil.caculFormEntityId(formMainBytemplateIdLike.get(0).getFormId()));
            }
        }
        FormMain formMain = CopyUtils.transfer(formValues, new FormMain());
        formMainRepository.save(formMain);
        repository.saveAndFlush(formValues);
        return JsonHandler.succeed(repository.findById(formValues.getFormId()).get());
    }

    public void deleteForm(String id) {
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(id));
        repository.deleteById(id);
    }

}
