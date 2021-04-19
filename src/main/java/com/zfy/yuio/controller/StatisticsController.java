package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 0:18
 */
@CrossOrigin
@RestController
@RequestMapping("statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("getTotalEmploymentInfo")
    public ResultBody getTotalEmploymentInfo(){
        return new ResultBody(0,statisticsService.getTotalEmploymentInfo(),"success");
    }

    @GetMapping("getCollegeEmploymentInfo")
    public ResultBody getCollegeEmploymentInfo(){
        return new ResultBody(0,statisticsService.getCollegeEmploymentInfo(),"success");
    }
}
