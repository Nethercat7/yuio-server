package com.zfy.yuio.controller;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatsStatusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:数据统计模块
 * @Author:赵富源
 * @CreateDate:2021/4/12 0:18
 */
@CrossOrigin
@RestController
@RequestMapping("stats/status")
public class StatsStatusController {
    @Autowired
    private StatsStatusService statusService;

    @PostMapping("getCityInfo")
    @RequiresPermissions("statistics:status:view")
    public ResultBody getCityInfo(@RequestBody QueryParams params){
        return new ResultBody(0,statusService.getCityInfo(params));
    }

    @PostMapping("getWorkInfo")
    @RequiresPermissions("statistics:status:view")
    public ResultBody getWorkInfo(@RequestBody QueryParams params){
        return new ResultBody(0,statusService.getWorkInfo(params));
    }

    @PostMapping("getUnEmplStudentPlan")
    @RequiresPermissions("statistics:status:view")
    public ResultBody getUnEmplStudentPlan(@RequestBody QueryParams params){
        return new ResultBody(0,statusService.getUnEmplStudentPlan(params));
    }

    @PostMapping("getEmplStudentPlan")
    @RequiresPermissions("statistics:status:view")
    public ResultBody getEmplStudentPlan(@RequestBody QueryParams params){
        return new ResultBody(0,statusService.getEmplStudentPlan(params));
    }
}
