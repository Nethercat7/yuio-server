package com.zfy.yuio.controller;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.statstics.ExcelCityStatus;
import com.zfy.yuio.entity.statstics.ExcelPlanStats;
import com.zfy.yuio.entity.statstics.ExcelWorkStats;
import com.zfy.yuio.service.StatsStatusService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @PostMapping("outputCityInfo")
    public void outputCityInfo(@RequestBody List<ExcelCityStatus> excelCityStatusList, HttpServletResponse response){
        statusService.outputCityInfo(excelCityStatusList,response);
    }

    @PostMapping("outputWorkInfo")
    public void outputWorkInfo(@RequestBody ExcelWorkStats params, HttpServletResponse response){
        statusService.outputWorkInfo(params,response);
    }

    @PostMapping("outputStudentPlan")
    public void outputStudentPlan(@RequestBody ExcelPlanStats params,HttpServletResponse response){
        statusService.outputStudentPlan(params,response);
    }
}
