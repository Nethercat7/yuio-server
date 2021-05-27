package com.zfy.yuio.controller;

import com.zfy.yuio.entity.statstics.ExcelCityStatus;
import com.zfy.yuio.entity.statstics.ExcelPlanStats;
import com.zfy.yuio.entity.statstics.ExcelWorkStats;
import com.zfy.yuio.service.StatsDataOutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *@Description:导出统计数据
 *@Author:Nethercat7
 *@CreateDate:2021/5/27 17:35
*/
@CrossOrigin
@RestController
@RequestMapping("stats/output")
public class StatsDataOutputController {
    @Autowired
    private StatsDataOutputService outputService;

    @PostMapping("city")
    public void outputCityInfo(@RequestBody List<ExcelCityStatus> excelCityStatusList, HttpServletResponse response){
        outputService.outputCityInfo(excelCityStatusList,response);
    }

    @PostMapping("work")
    public void outputWorkInfo(@RequestBody ExcelWorkStats params, HttpServletResponse response){
        outputService.outputWorkInfo(params,response);
    }

    @PostMapping("plan")
    public void outputStudentPlan(@RequestBody ExcelPlanStats params, HttpServletResponse response){
        outputService.outputStudentPlan(params,response);
    }
}
