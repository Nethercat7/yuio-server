package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatsRateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("stats/rate")
public class StatsRateController {
    @Autowired
    private StatsRateService statsRateService;

    @GetMapping("getEmplInfo")
    @RequiresPermissions("statistics:rate:stats")
    public ResultBody getEmplInfo(@RequestParam("grade") int grade){
        return new ResultBody(0,statsRateService.getEmplInfo(grade),"success");
    }

    @GetMapping("getCollegeEmplInfo")
    @RequiresPermissions("statistics:rate:stats")
    public ResultBody getCollegeEmplInfo(@RequestParam("grade") int grade){
        return new ResultBody(0,statsRateService.getCollegeEmplInfo(grade),"success");
    }
}
