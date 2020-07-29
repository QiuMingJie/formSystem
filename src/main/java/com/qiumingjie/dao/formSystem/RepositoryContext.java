package com.qiumingjie.dao.formSystem;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.formSystem.record.*;
import com.qiumingjie.utils.ClassUtils;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.Validate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * @author QiuMingJie
 * @date 2020-06-30 10:09
 * @description
 */
@Component
public class RepositoryContext {

    @Resource
    AnesthesiaAfterOpraKonwedRep RecAnesthesiaAfterOpraKonwed;

    @Resource
    AnesthesiaBrforeOpraRep RecAnesthesiaBrforeOpra;
    @Resource
    MachineCountRep RecMachineCount;
    @Resource
    OpraNurseRecRep RecOpraNurseRec;
    @Resource
    OpraVisiteTableRep RecOpraVisiteTable;
    @Resource
    PressureRiskRep RecPressureRisk;
    @Resource
    BloodTransfusionRecRep RecBloodTransfusionRec;
    @Resource
    OpraPatientTransRecRep RecOpraPatientTransRec;
    @Resource
    AnesthesiaInterviewRep RecAnesthesiaInterview;
    @Resource
    AnesthesiaKonwedRep RecAnesthesiaKonwed;
    @Resource
    UseExpensiveKnowedRep RecUseExpensiveKnowed;
    @Resource
    LargeExamApproveRep RecLargeExamApprove;
    @Resource
    ConsumApproveRep RecConsumApprove;



    public JpaRepository getRepository(String formDictCode) {
        try {
            FormEnum emuByCode = FormEnum.getEmuByCode(formDictCode);
            if (CommonUtils.empty(emuByCode)) {
                Validate.error("获取字典表枚举失败");
            }
            String entityName = emuByCode.getEntityClazz().getSimpleName();
            Field anesthesiaAfterOpraKonwed = ClassUtils.getField(this.getClass(), entityName);
            String name = anesthesiaAfterOpraKonwed.getName();
            ClassUtils.getValue(this,name,false);
            return (JpaRepository) anesthesiaAfterOpraKonwed.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public AnesthesiaAfterOpraKonwedRep getRecAnesthesiaAfterOpraKonwed() {
        return RecAnesthesiaAfterOpraKonwed;
    }

    public void setRecAnesthesiaAfterOpraKonwed(AnesthesiaAfterOpraKonwedRep recAnesthesiaAfterOpraKonwed) {
        RecAnesthesiaAfterOpraKonwed = recAnesthesiaAfterOpraKonwed;
    }

    public AnesthesiaBrforeOpraRep getRecAnesthesiaBrforeOpra() {
        return RecAnesthesiaBrforeOpra;
    }

    public void setRecAnesthesiaBrforeOpra(AnesthesiaBrforeOpraRep recAnesthesiaBrforeOpra) {
        RecAnesthesiaBrforeOpra = recAnesthesiaBrforeOpra;
    }

    public MachineCountRep getRecMachineCount() {
        return RecMachineCount;
    }

    public void setRecMachineCount(MachineCountRep recMachineCount) {
        RecMachineCount = recMachineCount;
    }

    public OpraNurseRecRep getRecOpraNurseRec() {
        return RecOpraNurseRec;
    }

    public void setRecOpraNurseRec(OpraNurseRecRep recOpraNurseRec) {
        RecOpraNurseRec = recOpraNurseRec;
    }

    public OpraVisiteTableRep getRecOpraVisiteTable() {
        return RecOpraVisiteTable;
    }

    public void setRecOpraVisiteTable(OpraVisiteTableRep recOpraVisiteTable) {
        RecOpraVisiteTable = recOpraVisiteTable;
    }

    public PressureRiskRep getRecPressureRisk() {
        return RecPressureRisk;
    }

    public void setRecPressureRisk(PressureRiskRep recPressureRisk) {
        RecPressureRisk = recPressureRisk;
    }

    public BloodTransfusionRecRep getRecBloodTransfusionRec() {
        return RecBloodTransfusionRec;
    }

    public void setRecBloodTransfusionRec(BloodTransfusionRecRep recBloodTransfusionRec) {
        RecBloodTransfusionRec = recBloodTransfusionRec;
    }

    public OpraPatientTransRecRep getRecOpraPatientTransRec() {
        return RecOpraPatientTransRec;
    }

    public void setRecOpraPatientTransRec(OpraPatientTransRecRep recOpraPatientTransRec) {
        RecOpraPatientTransRec = recOpraPatientTransRec;
    }

    public AnesthesiaInterviewRep getRecAnesthesiaInterview() {
        return RecAnesthesiaInterview;
    }

    public void setRecAnesthesiaInterview(AnesthesiaInterviewRep recAnesthesiaInterview) {
        RecAnesthesiaInterview = recAnesthesiaInterview;
    }

    public AnesthesiaKonwedRep getRecAnesthesiaKonwed() {
        return RecAnesthesiaKonwed;
    }

    public void setRecAnesthesiaKonwed(AnesthesiaKonwedRep recAnesthesiaKonwed) {
        RecAnesthesiaKonwed = recAnesthesiaKonwed;
    }

    public UseExpensiveKnowedRep getRecUseExpensiveKnowed() {
        return RecUseExpensiveKnowed;
    }

    public void setRecUseExpensiveKnowed(UseExpensiveKnowedRep recUseExpensiveKnowed) {
        RecUseExpensiveKnowed = recUseExpensiveKnowed;
    }

    public LargeExamApproveRep getRecLargeExamApprove() {
        return RecLargeExamApprove;
    }

    public void setRecLargeExamApprove(LargeExamApproveRep recLargeExamApprove) {
        RecLargeExamApprove = recLargeExamApprove;
    }

    public ConsumApproveRep getRecConsumApprove() {
        return RecConsumApprove;
    }

    public void setRecConsumApprove(ConsumApproveRep recConsumApprove) {
        RecConsumApprove = recConsumApprove;
    }
}
