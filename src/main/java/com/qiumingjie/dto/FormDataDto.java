package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.evaluate.table.FormMain;
import com.qiumingjie.entities.formSystem.evaluate.table.FormValue;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.Validate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2020-01-20 21:18
 * @description 返回给前端
 */
public class FormDataDto extends FormMain implements Serializable {


    private String templateFormId;

    private List<FormValue> formValues = new ArrayList<>();

    public String getTemplateFormId() {
        return templateFormId;
    }

    public void setTemplateFormId(String templateFormId) {
        this.templateFormId = templateFormId;
    }

    public List<FormValue> getFormValues() {
        return formValues;
    }

    public void setFormValues(List<FormValue> formValues) {
        this.formValues = formValues;
    }

    public void initFormValueFormId() {
        if (CommonUtils.empty(this.getFormId())) {
            Validate.error("表单实体id对应项目id失败");
        }
        if (CommonUtils.notEmpty(formValues)) {
            formValues.forEach(x -> x.getId().setFormDictId(this.getFormId()));
        }
    }
}
