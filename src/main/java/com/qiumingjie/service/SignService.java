package com.qiumingjie.service;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.RepositoryContext;
import com.qiumingjie.dao.formSystem.SignRepository;
import com.qiumingjie.dao.formSystem.table.FormMainRepository;
import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author QiuMingJie
 * @date 2020-07-01 10:57
 * @description
 */
@Service
public class SignService {
    @Autowired
    private FormMainRepository formMainRepository;

    @Autowired
    RepositoryContext repositoryContext;

    @Autowired
    SignRepository signRepository;

    @Autowired
    FormValuesService formValuesService;

    @Transactional(rollbackFor = RuntimeException.class)
    public JsonHandler sign(Sign sign, FormTemplate formTemplate, FormMain formMain) throws InstantiationException, IllegalAccessException {
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
        repository.save(CopyUtils.formEntityTransfer(formTemplate, FormEnum.getEntityClazz(formTemplate)));
        sign.setSignId(UUID.randomUUID().toString());
        signRepository.save(sign);
        formMainRepository.save(formMain);
        return JsonHandler.succeed(formValuesService.getForm(sign.getFormId()));
    }

}
