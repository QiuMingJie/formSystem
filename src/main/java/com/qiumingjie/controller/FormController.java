package com.qiumingjie.controller;

import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormAddDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/deleteForm")
    public JsonHandler deleteFormDict(@RequestBody FormDictDto formDictDto) {
        return formAddDictService.deleteFormDict(formDictDto);
    }

    @RequestMapping("/getFormById")
    public JsonHandler getFormById(@RequestBody FormDictDto formDictDto) {
        return formAddDictService.getFormById(formDictDto.getFormId());
    }

}
