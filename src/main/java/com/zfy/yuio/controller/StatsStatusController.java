package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.service.StatsStatusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 0:18
 */
@CrossOrigin
@RestController
@RequestMapping("stats/status")
public class StatsStatusController {
    @Autowired
    private StatsStatusService statusService;

    @PostMapping("getCityInfo")
    @RequiresPermissions("statistics:status:stats")
    public ResultBody getCityInfo(@RequestBody WriteEmplInfo params){
        return null;
    }

    @PostMapping("getWorkInfo")
    @RequiresPermissions("statistics:status:stats")
    public ResultBody getWorkInfo(@RequestBody WriteEmplInfo params){
        return null;
    }

    @PostMapping("getStudentPlan")
    @RequiresPermissions("statistics:status:stats")
    public ResultBody getStudentPlan(@RequestBody WriteEmplInfo params){
        return null;
    }
}
