package com.zfy.yuio.controller;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatsIntentionService;
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
@RequestMapping("stats/intention")
public class StatsIntentionController {
    @Autowired
    private StatsIntentionService intentionService;

    @PostMapping("getCityInfo")
    @RequiresPermissions("statistics:intention:stats")
    public ResultBody getCityInfo(@RequestBody QueryParams params){
        return new ResultBody(0,intentionService.getIntentionCities(params));
    }

    @PostMapping("getWorkInfo")
    @RequiresPermissions("statistics:intention:stats")
    public ResultBody getWorkInfo(@RequestBody QueryParams params){
        return new ResultBody(0,intentionService.getIntentionWorks(params));
    }
}
