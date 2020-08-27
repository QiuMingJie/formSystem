package com.qiumingjie.dto;

import com.qiumingjie.entities.formSystem.info.OpsQueue;
import com.qiumingjie.entities.formSystem.info.PatientInfo;
import com.qiumingjie.entities.formSystem.info.UserInfo;
import lombok.Data;

/**
 * @author QiuMingJie
 * @date 2020-08-27 9:27
 * @description
 */
@Data
public class PatientAndOperationAndUserInfoDto {
    OpsQueue opsQueue;
    PatientInfo patientInfo;
    UserInfo userInfo;

}
