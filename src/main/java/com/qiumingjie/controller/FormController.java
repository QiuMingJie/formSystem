package com.qiumingjie.controller;

import com.qiumingjie.dto.FormDataDto;
import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormAddDictService;
import com.qiumingjie.service.FormAddValueService;
import com.qiumingjie.service.FormDictService;
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
    private FormDictService formDictService;

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
     * 删除字典表
     * @param formId 表单id
     * @param deleteItem 是否删除项目，true/false
     * @return 运行过程
     */
    @RequestMapping(value = "/deleteFormDict",method = RequestMethod.GET)
    public JsonHandler deleteFormDict(String formId,Boolean deleteItem) {
        return formAddDictService.deleteFormDict(formId,deleteItem);
    }

    /**
     * 获取字典表单信息
     * @param formId 表单id
     * @return 表单的基本信息
     */
    @RequestMapping(value = "/getFormDict",method = RequestMethod.GET)
    public JsonHandler getFormById(String formId) {
        return formAddDictService.getFormById(formId);
    }

    /**
     * 保存表单实体
     * @param formDataDto
     * @return
     */
    @RequestMapping(value = "/saveOrUpdateForm", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateForm(FormDataDto formDataDto) {
        return formAddValueService.saveOrUpdateForm(formDataDto);
    }

    /**
     * 获取表单实体信息
     * @param formId
     * @return
     */
    @RequestMapping(value = "/getForm", method = RequestMethod.GET)
    public JsonHandler getForm(String  formId) {
        return formAddValueService.getForm(formId);
    }

    /**
     * 删除表单实体
     * @param formId
     * @return
     */
    @RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
    public JsonHandler deleteForm(String  formId) {
        return formAddValueService.deleteForm(formId);
    }





}
