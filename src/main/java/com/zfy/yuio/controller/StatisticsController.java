package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PostMapping("getEmploymentCityInfo")
    public ResultBody getEmploymentCityInfo(@RequestBody Map<String,Object> form){
        return new ResultBody(0,statisticsService.getEmploymentCityInfo(form),"success");
    }

    @PostMapping("getEmploymentWorkInfo")
    public ResultBody getEmploymentWorkInfo(@RequestBody Map<String,Object> form){
        return new ResultBody(0,statisticsService.getEmploymentWorkInfo(form),"success");
    }

    @PostMapping("getUnEmploymentStudentPlan")
    public ResultBody getUnEmploymentStudentPlan(@RequestBody Map<String,Object> form){
        return new ResultBody(0,statisticsService.getUnEmploymentStudentPlan(form),"success");
    }

    @PostMapping("getIntentionCityInfo")
    public ResultBody getIntentionCityInfo(@RequestBody Map<String,Object> form){
        return new ResultBody(0,statisticsService.getIntentionCityInfo(form),"success");
    }

    @PostMapping("getIntentionWorkInfo")
    public ResultBody getIntentionWorkInfo(@RequestBody Map<String,Object> form){
        return new ResultBody(0,statisticsService.getIntentionWorkInfo(form),"success");
    }

    @GetMapping("getGrade")
    public ResultBody getGrade(){
        return new ResultBody(0,statisticsService.getGrade(),"success");
    }
}
