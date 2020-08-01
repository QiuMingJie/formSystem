package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.Sign;
import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.entities.formSystem.info.PatientInfo;
import lombok.Data;

import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-03-16 16:08
 * @description
 */
@Data
public class FormTemplateDto extends FormTemplate {

    /**
     * 归档标志
     */
    private Boolean archiveFlag;

    /**
     * 签名标志，为true则已经签名，不可以再改
     */
    private Boolean signFlag;

    private OpsQueue operation;

    private PatientInfo patientInfo;

    private List<Sign> signList;


}
