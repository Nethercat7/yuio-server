package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.WriteEmplInfo;
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
    public ResultBody getCityInfo(@RequestBody WriteEmplInfo params){
        return null;
    }

    @PostMapping("getWorkInfo")
    @RequiresPermissions("statistics:intention:stats")
    public ResultBody getWorkInfo(@RequestBody WriteEmplInfo params){
        return null;
    }
}
