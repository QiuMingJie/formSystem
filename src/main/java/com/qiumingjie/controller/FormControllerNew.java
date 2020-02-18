package com.qiumingjie.controller;

import com.qiumingjie.dao.dict.FormDictRepository;
import com.qiumingjie.dao.table.FormValuesRepository;
import com.qiumingjie.entities.evaluate.table.FormValues;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-02-17 15:33
 * @description
 */
@RestController
@RequestMapping("/form")
public class FormControllerNew {

    @Autowired
    FormValuesService formValuesService;

    @Autowired
    FormValuesRepository formValuesRepository;

    @Autowired
    FormDictRepository formDictRepository;

    /**
     * 暴力存表发获取表单接口
     * @param id
     * @return
     */
    @RequestMapping(value = "/getFormNew", method = RequestMethod.GET)
    public JsonHandler getFormNew(String id) {
        Optional<FormValues> byId = formValuesService.getById(id);
        return byId.map(JsonHandler::succeed).orElseGet(() -> JsonHandler.fail("表单不存在"));
    }

    @RequestMapping(value = "/saveOrUpdateFormNew",method = RequestMethod.POST)
    public JsonHandler saveOrUpdateNew(@RequestBody FormValues formValues) {
        if (CommonUtils.empty(formValues.getTemplateFormId())&&CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("模板表不存在或获取表失败");
        }
        if (CommonUtils.empty(formValues.getTemplateFormId())) {
            formValues.setTemplateFormId(FormUtil.getFormDictId(formValues.getFormId()));
        }
        formValues.setTemplateName(formDictRepository.findById(formValues.getTemplateFormId()).get().getFormName());
        return JsonHandler.succeed(formValuesService.saveOrUpdateNew(formValues));
    }

    @RequestMapping(value = "/deleteFormNew" ,method = RequestMethod.POST)
    public JsonHandler deleteFormNew(@RequestBody FormValues formValues) {
        if (CommonUtils.empty(formValues)||CommonUtils.empty(formValues.getFormId())) {
            return JsonHandler.fail("删除表单为空");
        }
        formValuesService.deleteForm(formValues.getFormId());
        return JsonHandler.succeed();
    }

    @RequestMapping(value = "/getAllFormNew", method = RequestMethod.GET)
    public JsonHandler getFormNew() {
        return JsonHandler.succeed(formValuesService.getAllForm());
    }
}



















