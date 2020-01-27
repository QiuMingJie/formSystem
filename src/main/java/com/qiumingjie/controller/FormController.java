package com.qiumingjie.controller;

import com.qiumingjie.dto.FormDataDto;
import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormAddDictService;
import com.qiumingjie.service.FormAddValueService;
import com.qiumingjie.service.FormDictService;
import com.qiumingjie.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:11
 * @description
 */
@RestController
@RequestMapping("/form")
public class FormController {

    @Autowired
    FormDictService formDictService;


    @Autowired
    private FormAddDictService formAddDictService;

    @Autowired
    private FormAddValueService formAddValueService;

    /**
     * 新增字典表的方法
     * @param formDictDto 字典表基本信息
     * @return
     */
    @RequestMapping("/addFormDict")
    public JsonHandler addFormDict(@RequestBody FormDictDto formDictDto) {
       return   formAddDictService.addFormDict(formDictDto);
    }

    /**
     * 删除表
     * @param formId 表单id
     * @param deleteItem 是否删除项目，true/false
     * @return 运行过程
     */
    @RequestMapping(value = "/deleteFormDict",method = RequestMethod.GET)
    public JsonHandler deleteFormDict(String formId,Boolean deleteItem) {
        return formAddDictService.deleteFormDict(formId,deleteItem);
    }

    /**
     * 获取表单
     * @param formId 表单id
     * @return 表单的基本信息
     */
    @RequestMapping(value = "/getFormDict",method = RequestMethod.GET)
    public JsonHandler getFormById(String formId) {
        return formAddDictService.getFormById(formId);
    }

    @RequestMapping(value = "/addForm", method = RequestMethod.POST)
    public JsonHandler addForm(FormDataDto formDataDto) {
        if (CommonUtils.empty(formDataDto.getTemplateFormId())) {
            return JsonHandler.fail("获取模板表单id失败");
        }
        if (!formDictService.existFormDict(formDataDto.getTemplateFormId())) {
            return JsonHandler.fail("获取表单模板失败");
        }
        return formAddValueService.addFrom(formDataDto);
    }



}
