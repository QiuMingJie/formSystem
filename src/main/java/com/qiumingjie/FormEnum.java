package com.qiumingjie;

import com.qiumingjie.entities.formSystem.evaluate.table.FormTemplate;
import com.qiumingjie.entities.formSystem.record.*;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.Validate;

/**
 * @author QiuMingJie
 * @date 2020-06-28 21:11
 * @description 表单枚举
 */
public enum FormEnum {
    //
    E0002_0001("E0002_0001", "器械清点", "4", RecMachineCount.class),
    E0002_0002("E0002_0002", "手术护理记录单", "4", RecOpraNurseRec.class),
    E0002_0003("E0002_0003", "手术室手术病人访式表", "3", RecOpraVisiteTable.class),
    E0002_0004("E0002_0004", "手术患者术前压疮风险评估单（手术室）", "1", RecPressureRisk.class),
    E0002_0006("E0002_0006", "输血护理观察记录单", " - 1", RecBloodTransfusionRec.class),
    E0002_0007("E0002_0007", "手术患者转交接记录单", " - 1", RecOpraPatientTransRec.class),

    E0003_0003("E0003_0003", "麻醉术前访视记录单", "1", RecAnesthesiaBrforeOpra.class),
    E0003_0004("E0003_0004", "麻醉术后访视记录", "3", RecAnesthesiaInterview.class),
    E0003_0005("E0003_0005", "麻醉知情同意书", "1", RecAnesthesiaKonwed.class),
    E0003_0006("E0003_0006", "术后镇痛知情同意书", "1", RecAnesthesiaAfterOpraKonwed.class),
    E0003_0007("E0003_0007", "使用自费、高费用项目同意书", " - 1", RecUseExpensiveKnowed.class),
    E0003_0008("E0003_0008", "自费药品、医保乙类药品及大型检查申请审批表", " - 1", RecLargeExamApprove.class),
    E0003_0009("E0003_0009", "医保乙类、丙类诊疗项目、材料及贵重耗材申请审批表", " - 1", RecConsumApprove.class);


    FormEnum(String templateFormId, String desc, String signNum, Class entityClazz) {
        this.templateFormId = templateFormId;
        this.desc = desc;
        this.entityClazz = entityClazz;
        this.signNum = signNum;
    }

    public static FormEnum getEmuByCode(String formDictId) {
        FormEnum[] values = FormEnum.values();
        for (FormEnum value : values) {
            if (value.templateFormId.equals(formDictId)) {
                return value;
            }
        }
        return null;
    }

    public static Class getEntityClazz(FormTemplate formTemplate) {
        if (CommonUtils.empty(formTemplate.getTemplateFormId())) {
            Validate.error("表单id为空，获取实体失败");
        }
        return getEmuByCode(formTemplate.getTemplateFormId()).getEntityClazz();
    }

    /**
     * distCode
     */
    private String templateFormId;

    private String desc;

    private Class entityClazz;

    private String signNum;


    public String getTemplateFormId() {
        return templateFormId;
    }

    public void setTemplateFormId(String templateFormId) {
        this.templateFormId = templateFormId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class getEntityClazz() {
        return entityClazz;
    }

    public void setEntityClazz(Class entityClazz) {
        this.entityClazz = entityClazz;
    }

    public String getSignNum() {
        return signNum;
    }

    public void setSignNum(String signNum) {
        this.signNum = signNum;
    }
}
