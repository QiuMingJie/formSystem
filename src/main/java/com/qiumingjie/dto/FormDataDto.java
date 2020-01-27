package com.qiumingjie.dto;

import com.qiumingjie.entities.evaluate.table.FormMain;
import com.qiumingjie.entities.evaluate.table.FormValue;

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
}
