package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.entities.formSystem.info.PatientInfo;

/**
 * @author QiuMingJie
 * @date 2020-03-16 16:35
 * @description 包含病人基本信息和手术信息
 */
public class PatientAndOperationInfoDto extends PatientInfo {
    private OpsQueue operationInfo;

    public OpsQueue getOperationInfo() {
        return operationInfo;
    }

    public void setOperationInfo(OpsQueue operationInfo) {
        this.operationInfo = operationInfo;
    }
}
