package com.qiumingjie.service;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.RepositoryContext;
import com.qiumingjie.dao.SignRepository;
import com.qiumingjie.dao.table.FormMainRepository;
import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormTemplate;
import com.qiumingjie.entities.sign.Sign;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CopyUtils;
import com.qiumingjie.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Transient;
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

    @Transient
    public JsonHandler sign(Sign sign, FormTemplate formTemplate, FormMain formMain) throws InstantiationException, IllegalAccessException {
        JpaRepository repository = repositoryContext.getRepository(FormUtil.getFormDictId(sign.getFormId()));
        repository.save(CopyUtils.formEntityTransfer(formTemplate, FormEnum.getEntityClazz(formTemplate)));
        sign.setSignId(UUID.randomUUID().toString());
        signRepository.save(sign);
        formMainRepository.save(formMain);
        return JsonHandler.succeed(formValuesService.getForm(sign.getFormId()));
    }

}
