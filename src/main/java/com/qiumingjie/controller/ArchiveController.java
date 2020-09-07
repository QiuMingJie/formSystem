package com.qiumingjie.controller;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.service.FormValuesService;
import com.qiumingjie.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Optional;

/**
 * @author QiuMingJie
 * @date 2020-07-01 14:27
 * @description 归档
 */
@RestController
@RequestMapping("/archive")
@Api(description = "归档和取消归档接口")
@Slf4j
public class ArchiveController {

    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    FormValuesService formValuesService;

    @Value("${archiveFormFilePath}")
    String archiveFormFilePath;

    @PostMapping("/archiveForm")
    @ApiOperation("归档接口")
    @Transactional
    public JsonHandler archiveForm(
            @ApiParam(value = "只需传formId字段")
             String formId,
            MultipartFile file) throws InstantiationException, IllegalAccessException {
        if (CommonUtils.empty(formId)) {
            return JsonHandler.fail("表单id为空，归档失败");
        }
        Optional<FormMain> byId = formMainRepository.findById(formId);
        if (!byId.isPresent()) {
            return JsonHandler.fail("获取表单失败");
        }
        FormMain formMain = byId.get();
//        if (!formMain.getSignFlag()) {
//            return JsonHandler.fail("归档失败，表单存在未签名信息");
//        }
        formMain.setArchiveFlag(true);
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(formId));
        Optional formTemplateOptional = repository.findById(formId);
        if (!formTemplateOptional.isPresent()) {
            return JsonHandler.fail("表单信息不存在");
        }
        FormTemplate formTemplate = (FormTemplate)formTemplateOptional.get();
        try {
            FileUtils.saveToDisk(archiveFormFilePath, DateUtils.format(new Date(),"yyyyMMddHHmmss")+"_"+file.getOriginalFilename(), file.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonHandler.fail("归档失败，保存归档文件失败"+e.getMessage());
        }
        repository.save(CopyUtils.formEntityTransfer(formTemplate, FormEnum.getEntityClazz(formTemplate)));
        formMainRepository.save(formMain);
        return JsonHandler.succeed(formValuesService.getForm(formId));
    }

    @PostMapping("/cancelArchiveForm")
    public JsonHandler cancelArchiveForm(@RequestBody Sign sign) {
        String formId = sign.getFormId();
        if (CommonUtils.empty(formId)) {
            return JsonHandler.fail("表单id为空，取消归档失败");
        }
        Optional<FormMain> formMainOptional = formMainRepository.findById(formId);
        if (!formMainOptional.isPresent()) {
            return JsonHandler.fail("获取表单失败");
        }
        FormMain formMain = formMainOptional.get();
        formMain.setArchiveFlag(false);
        formMainRepository.save(formMain);
        return JsonHandler.succeed("取消归档成功");
    }


}
