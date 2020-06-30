package com.qiumingjie;

import com.qiumingjie.entities.record.*;

/**
 * @author QiuMingJie
 * @date 2020-06-28 21:11
 * @description 表单枚举
 */
public enum FormEnum {
    //
    E0002_0001("E0002_0001", "器械清点", "4", MachineCount.class),
    E0002_0002("E0002_0002", "手术护理记录单", "4", OpraNurseRec.class),
    E0002_0003("E0002_0003", "手术室手术病人访式表", "3", OpraVisiteTable.class),
    E0002_0004("E0002_0004", "手术患者术前压疮风险评估单（手术室）", "1", PressureRisk.class),
    E0002_0006("E0002_0006", "输血护理观察记录单", " - 1", BloodTransfusionRec.class),
    E0002_0007("E0002_0007", "手术患者转交接记录单", " - 1", OpraPatientTransRec.class),

    E0003_0003("E0003_0003", "麻醉术前访视记录单", "1", AnesthesiaBrforeOpra.class),
    E0003_0004("E0003_0004", "麻醉经过及术后访视", "3", AnesthesiaInterview.class),
    E0003_0005("E0003_0005", "麻醉知情同意书", "1", AnesthesiaKonwed.class),
    E0003_0006("E0003_0006", "术后镇痛知情同意书", "1", AnesthesiaAfterOpraKonwed.class),
    E0003_0007("E0003_0007", "使用自费、高费用项目同意书", " - 1", UseExpensiveKnowed.class),
    E0003_0008("E0003_0008", "自费药品、医保乙类药品及大型检查申请审批表", " - 1", LargeExamApprove.class),
    E0003_0009("E0003_0009", "医保乙类、丙类诊疗项目、材料及贵重耗材申请审批表", " - 1", ConsumApprove.class);


    FormEnum(String formDictId, String desc, String signNum, Class handler) {
        this.formDictId = formDictId;
        this.desc = desc;
        this.handler = handler;
        this.signNum = signNum;
    }

    public static FormEnum getEmuByCode(String formDictId) {
        FormEnum[] values = FormEnum.values();
        for (FormEnum value : values) {
            if (value.formDictId.equals(formDictId)) {
                return value;
            }
        }
        return null;
    }

    /**
     * distCode
     */
    private String formDictId;

    private String desc;

    private Class handler;

    private String signNum;


    public String getFormDictId() {
        return formDictId;
    }

    public void setFormDictId(String formDictId) {
        this.formDictId = formDictId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Class getHandler() {
        return handler;
    }

    public void setHandler(Class handler) {
        this.handler = handler;
    }

    public String getSignNum() {
        return signNum;
    }

    public void setSignNum(String signNum) {
        this.signNum = signNum;
    }
}
