package com.qiumingjie.controller;

import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.sign.Sign;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ArchiveController {

    @Autowired
    private FormMainRepository formMainRepository;

    @PostMapping("/archiveForm")
    public JsonHandler archiveForm(@RequestBody Sign sign) {
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
            return JsonHandler.fail("归档失败，表单未签名");
        }
        formMain.setArchiveFlag(true);
        formMainRepository.save(formMain);
        return JsonHandler.succeed("归档成功");
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
