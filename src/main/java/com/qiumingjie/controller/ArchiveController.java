package com.qiumingjie.controller;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-07-01 14:27
 * @description 归档
 */
@RestController
@RequestMapping("/archive")
@Api(description = "归档和取消归档接口")
public class ArchiveController {

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    FormValuesService formValuesService;

    @PostMapping("/archiveForm")
    @ApiOperation("归档接口")
    public JsonHandler archiveForm(
            @ApiParam(value = "只需传formId字段")
            @RequestBody Sign sign) throws InstantiationException, IllegalAccessException {
        String formId = sign.getFormId();
        if (CommonUtils.empty(formId)) {
            return JsonHandler.fail("表单id为空，归档失败");
        }
        Optional<FormMain> byId = formMainRepository.findById(formId);
        if (!byId.isPresent()) {
            return JsonHandler.fail("获取表单失败");
        }
        FormMain formMain = byId.get();
        if (!formMain.getSignFlag()) {
            return JsonHandler.fail("归档失败，表单存在未签名信息");
        }
        formMain.setArchiveFlag(true);
        formMainRepository.save(formMain);
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
        Optional formTemplateOptional = repository.findById(sign.getFormId());
        if (!formTemplateOptional.isPresent()) {
            return JsonHandler.fail("表单信息不存在");
        }
        FormTemplate formTemplate = (FormTemplate)formTemplateOptional.get();
//        formTemplate.setArchiveFlag(true);
        repository.save(CopyUtils.formEntityTransfer(formTemplate, FormEnum.getEntityClazz(formTemplate)));
        return JsonHandler.succeed(formValuesService.getForm(sign.getFormId()));
    }

    @PostMapping("/cancelArchiveForm")
    public JsonHandler cancelArchiveForm(@RequestBody Sign sign) {
        String formId = sign.getFormId();
        if (CommonUtils.empty(formId)) {
            return JsonHandler.fail("表单id为空，取消归档失败");
        }
        Optional<FormMain> byId = formMainRepository.findById(formId);
        if (!byId.isPresent()) {
            return JsonHandler.fail("获取表单失败");
        }
        FormMain formMain = byId.get();
        formMain.setArchiveFlag(false);
        formMainRepository.save(formMain);
        return JsonHandler.succeed("取消归档成功");
    }


}
