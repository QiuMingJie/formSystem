package com.qiumingjie.dao;

import com.qiumingjie.FormEnum;
import com.qiumingjie.dao.record.*;
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
    AnesthesiaAfterOpraKonwedRep AnesthesiaAfterOpraKonwed;

    @Resource
    AnesthesiaBrforeOpraRep AnesthesiaBrforeOpra;
    @Resource
    MachineCountRep MachineCount;
    @Resource
    OpraNurseRecRep OpraNurseRec;
    @Resource
    OpraVisiteTableRep OpraVisiteTable;
    @Resource
    PressureRiskRep PressureRisk;
    @Resource
    BloodTransfusionRecRep BloodTransfusionRec;
    @Resource
    OpraPatientTransRecRep OpraPatientTransRec;
    @Resource
    AnesthesiaInterviewRep AnesthesiaInterview;
    @Resource
    AnesthesiaKonwedRep AnesthesiaKonwed;
    @Resource
    UseExpensiveKnowedRep UseExpensiveKnowed;
    @Resource
    LargeExamApproveRep LargeExamApprove;
    @Resource
    ConsumApproveRep ConsumApprove;



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

    public AnesthesiaAfterOpraKonwedRep getAnesthesiaAfterOpraKonwed() {
        return AnesthesiaAfterOpraKonwed;
    }

    public void setAnesthesiaAfterOpraKonwed(AnesthesiaAfterOpraKonwedRep anesthesiaAfterOpraKonwed) {
        AnesthesiaAfterOpraKonwed = anesthesiaAfterOpraKonwed;
    }

    public AnesthesiaBrforeOpraRep getAnesthesiaBrforeOpra() {
        return AnesthesiaBrforeOpra;
    }

    public void setAnesthesiaBrforeOpra(AnesthesiaBrforeOpraRep anesthesiaBrforeOpra) {
        AnesthesiaBrforeOpra = anesthesiaBrforeOpra;
    }

    public MachineCountRep getMachineCount() {
        return MachineCount;
    }

    public void setMachineCount(MachineCountRep machineCount) {
        MachineCount = machineCount;
    }

    public OpraNurseRecRep getOpraNurseRec() {
        return OpraNurseRec;
    }

    public void setOpraNurseRec(OpraNurseRecRep opraNurseRec) {
        OpraNurseRec = opraNurseRec;
    }

    public OpraVisiteTableRep getOpraVisiteTable() {
        return OpraVisiteTable;
    }

    public void setOpraVisiteTable(OpraVisiteTableRep opraVisiteTable) {
        OpraVisiteTable = opraVisiteTable;
    }

    public PressureRiskRep getPressureRisk() {
        return PressureRisk;
    }

    public void setPressureRisk(PressureRiskRep pressureRisk) {
        PressureRisk = pressureRisk;
    }

    public BloodTransfusionRecRep getBloodTransfusionRec() {
        return BloodTransfusionRec;
    }

    public void setBloodTransfusionRec(BloodTransfusionRecRep bloodTransfusionRec) {
        BloodTransfusionRec = bloodTransfusionRec;
    }

    public OpraPatientTransRecRep getOpraPatientTransRec() {
        return OpraPatientTransRec;
    }

    public void setOpraPatientTransRec(OpraPatientTransRecRep opraPatientTransRec) {
        OpraPatientTransRec = opraPatientTransRec;
    }

    public AnesthesiaInterviewRep getAnesthesiaInterview() {
        return AnesthesiaInterview;
    }

    public void setAnesthesiaInterview(AnesthesiaInterviewRep anesthesiaInterview) {
        AnesthesiaInterview = anesthesiaInterview;
    }

    public AnesthesiaKonwedRep getAnesthesiaKonwed() {
        return AnesthesiaKonwed;
    }

    public void setAnesthesiaKonwed(AnesthesiaKonwedRep anesthesiaKonwed) {
        AnesthesiaKonwed = anesthesiaKonwed;
    }

    public UseExpensiveKnowedRep getUseExpensiveKnowed() {
        return UseExpensiveKnowed;
    }

    public void setUseExpensiveKnowed(UseExpensiveKnowedRep useExpensiveKnowed) {
        UseExpensiveKnowed = useExpensiveKnowed;
    }

    public LargeExamApproveRep getLargeExamApprove() {
        return LargeExamApprove;
    }

    public void setLargeExamApprove(LargeExamApproveRep largeExamApprove) {
        LargeExamApprove = largeExamApprove;
    }

    public ConsumApproveRep getConsumApprove() {
        return ConsumApprove;
    }

    public void setConsumApprove(ConsumApproveRep consumApprove) {
        ConsumApprove = consumApprove;
    }
}
