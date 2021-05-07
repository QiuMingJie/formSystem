package com.qiumingjie.controller;

import com.qiumingjie.dao.formSystem.OperationPlanRepository;
import com.qiumingjie.handler.JsonHandler;
import com.qiumingjie.utils.CommonUtils;
import com.qiumingjie.utils.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuMingJie
 * @date 2021/5/7 14:30
 * @description 显示手麻系统中各个手术安排信息。
 */
@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationPlanRepository operationPlanRepository;

    @ApiOperation("显示手麻系统中各个手术安排信息")
    @RequestMapping(value = "/getOperationPlan", method = RequestMethod.GET)
    public JsonHandler getOperationPlan(String requestDatetimeStart,String requestDatetimeEnd,String operationPlace) {
        if (CommonUtils.empty(requestDatetimeStart)||CommonUtils.empty(requestDatetimeEnd)||CommonUtils.empty(operationPlace)) {
            return JsonHandler.fail("开始结束时间或手术执行地点不能为空");
        }
        return JsonHandler.succeed(operationPlanRepository.getOperationPlan(DateUtils.parse(requestDatetimeStart,"yyyy-MM-dd"), DateUtils.parse(requestDatetimeEnd,"yyyy-MM-dd"), operationPlace));
    }
}
