package com.qiumingjie.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;

/**
 * @author QiuMingJie
 * @date 2021/5/7 14:37
 * @description
 */
@ApiModel("手机安排前端类")
@Data
public class OperationPlanDto {

    @Id
    private String id;
    @ApiModelProperty(name = "科室")
    private String dept;
    @ApiModelProperty(name = "床号")
    private String bed;
    @ApiModelProperty(name = "住院号")
    private String inpatientId;
    @ApiModelProperty(name = "姓名")
    private String name;
    @ApiModelProperty(name = "年龄")
    private String age;
    @ApiModelProperty(name = "术间号")
    private String room;
    @ApiModelProperty(name = "台次")
    private String no;
    @ApiModelProperty(name = "手术医生")
    private String operationDoctor;
    @ApiModelProperty(name = "麻醉医生")
    private String anestheticDoctor;
    @ApiModelProperty(name = "洗手护士")
    private String scrubNurse;
    @ApiModelProperty(name = "巡回护士")
    private String circulatingNurse;
}
