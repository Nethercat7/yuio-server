package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.service.StatsIntentionService;
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
@RequestMapping("stats/intention")
public class StatsIntentionController {
    @Autowired
    private StatsIntentionService intentionService;

    @PostMapping("getCityInfo")
    @RequiresPermissions("statistics:intention:stats")
    public ResultBody getCityInfo(@RequestBody StatsEmplInfo params){
        return new ResultBody(0,intentionService.getCityInfo(params),"success");
    }

    @PostMapping("getWorkInfo")
    @RequiresPermissions("statistics:intention:stats")
    public ResultBody getWorkInfo(@RequestBody StatsEmplInfo params){
        return new ResultBody(0,intentionService.getWorkInfo(params),"success");
    }
}
