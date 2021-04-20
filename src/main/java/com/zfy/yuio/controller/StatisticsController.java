package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResultBody getTotalEmploymentInfo(@RequestParam("grade") int grade){
        return new ResultBody(0,statisticsService.getTotalEmploymentInfo(grade),"success");
    }

    @GetMapping("getCollegeEmploymentInfo")
    public ResultBody getCollegeEmploymentInfo(@RequestParam("grade") int grade){
        return new ResultBody(0,statisticsService.getCollegeEmploymentInfo(grade),"success");
    }

    @GetMapping("getEmploymentCityInfo")
    public ResultBody getEmploymentCityInfo(){
        return new ResultBody(0,statisticsService.getEmploymentCityInfo(),"success");
    }

    @GetMapping("getEmploymentWorkInfo")
    public ResultBody getEmploymentWorkInfo(){
        return new ResultBody(0,statisticsService.getEmploymentWorkInfo(),"success");
    }

    @GetMapping("getUnEmploymentStudentPlan")
    public ResultBody getUnEmploymentStudentPlan(){
        return new ResultBody(0,statisticsService.getUnEmploymentStudentPlan(),"success");
    }

    @GetMapping("getIntentionCityInfo")
    public ResultBody getIntentionCityInfo(){
        return new ResultBody(0,statisticsService.getIntentionCityInfo(),"success");
    }

    @GetMapping("getIntentionWorkInfo")
    public ResultBody getIntentionWorkInfo(){
        return new ResultBody(0,statisticsService.getIntentionWorkInfo(),"success");
    }

    @GetMapping("getGrade")
    public ResultBody getGrade(){
        return new ResultBody(0,statisticsService.getGrade(),"success");
    }
}
