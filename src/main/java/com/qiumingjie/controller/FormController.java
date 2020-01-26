package com.qiumingjie.controller;

import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormAddDictService;
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
    private FormAddDictService formAddDictService;

    /**
     * 新增字典表的方法
     * @param formDictDto 字典表基本信息
     * @return
     */
    @RequestMapping("/addForm")
    public JsonHandler addFormDict(@RequestBody FormDictDto formDictDto) {
       return   formAddDictService.addFormDict(formDictDto);
    }

    /**
     * 删除表
     * @param formId 表单id
     * @param deleteItem 是否删除项目，true/false
     * @return 运行过程
     */
    @RequestMapping(value = "/deleteForm",method = RequestMethod.GET)
    public JsonHandler deleteFormDict(String formId,Boolean deleteItem) {
        return formAddDictService.deleteFormDict(formId,deleteItem);
    }

    /**
     * 获取表单
     * @param formId 表单id
     * @return 表单的基本信息
     */
    @RequestMapping(value = "/getFormById",method = RequestMethod.GET)
    public JsonHandler getFormById(String formId) {
        return formAddDictService.getFormById(formId);
    }



}
