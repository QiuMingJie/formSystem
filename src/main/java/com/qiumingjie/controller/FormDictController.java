package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.info.RoleInfoRepository;
import com.qiumingjie.dao.formSystem.info.UserInfoRepository;
import com.qiumingjie.dto.FormDataDto;
import com.qiumingjie.dto.FormDictDto;
import com.qiumingjie.dto.UserAndRoleDto;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormAddDictService;
import com.qiumingjie.service.FormAddValueService;
import com.qiumingjie.service.FormDictService;
import com.qiumingjie.service.UserAndRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@Api(description = "用于操作字典表！")
@RequestMapping("/form")
@Slf4j
public class FormDictController {
    @Autowired
    private FormDictService formDictService;

    @Autowired
    private FormAddDictService formAddDictService;

    @Autowired
    private FormAddValueService formAddValueService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private RoleInfoRepository roleInfoRepository;

    @Autowired
    private UserAndRoleService userAndRoleService;

    @ApiOperation("新增字典表的方法")
    @RequestMapping("/addFormDict")
    public JsonHandler addFormDict(@RequestBody FormDictDto formDictDto) {
        return formAddDictService.addFormDict(formDictDto);
    }

    /**
     * @param formId     表单id
     * @param deleteItem 是否删除项目，true/false
     * @return 运行过程
     */
    @ApiOperation("删除字典表")
    @RequestMapping(value = "/deleteFormDict", method = RequestMethod.GET)
    public JsonHandler deleteFormDict(String formId, Boolean deleteItem) {
        return formAddDictService.deleteFormDict(formId, deleteItem);
    }

    /**
     * @param formId 表单id
     * @return 表单的基本信息
     */
    @ApiOperation("获取字典表单信息")
    @RequestMapping(value = "/getFormDict", method = RequestMethod.GET)
    public JsonHandler getFormById(String formId) {
        return formAddDictService.getFormById(formId);
    }

    @ApiOperation("保存表单实体")
    @RequestMapping(value = "/saveOrUpdateForm", method = RequestMethod.POST)
    public JsonHandler saveOrUpdateForm(@RequestBody FormDataDto formDataDto) {
        return formAddValueService.saveOrUpdateForm(formDataDto);
    }

    @ApiOperation("获取表单实体信息")
    @RequestMapping(value = "/getForm", method = RequestMethod.GET)
    public JsonHandler getForm(String formId) {
        return formAddValueService.getForm(formId);
    }

    @ApiOperation("删除表单实体")
    @RequestMapping(value = "/deleteForm", method = RequestMethod.GET)
    public JsonHandler deleteForm(String formId) {
        return formAddValueService.deleteForm(formId);
    }

    @RequestMapping(value = "/getAllFromDict", method = RequestMethod.GET)
    public JsonHandler getAllFormDict() {
        return JsonHandler.succeed(formDictService.getAllForm());
    }


    @RequestMapping(value = "/getFormDictByUserId", method = RequestMethod.GET)
    public JsonHandler getFormDictByUserId(Integer userId) {
        log.info("111");
        UserAndRoleDto userAndRoleInfoByUserId = userAndRoleService.getUserAndRoleInfoByUserId(userId);
        String roleName = userAndRoleInfoByUserId.getRoleInfo().getSmRoleName();
        return JsonHandler.succeed(roleName,formDictService.getFormByRole(roleName));
    }
}
