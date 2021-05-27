package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.ExcelCityStatus;
import com.zfy.yuio.entity.statstics.ExcelPlanStats;
import com.zfy.yuio.entity.statstics.ExcelWorkStats;
import com.zfy.yuio.entity.statstics.StatsEmplResult;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:赵富源
 * @CreateDate:2021/4/19 17:18
 */
public interface StatsStatusService {
    List<StatsEmplResult> getCityInfo(QueryParams params);

    StatsEmplResult getWorkInfo(QueryParams params);

    StatsEmplResult getUnEmplStudentPlan(QueryParams params);

    StatsEmplResult getEmplStudentPlan(QueryParams params);

    void outputCityInfo(List<ExcelCityStatus> excelCityStatuses, HttpServletResponse response);

    void outputWorkInfo(ExcelWorkStats params, HttpServletResponse response);

    void outputStudentPlan(ExcelPlanStats params, HttpServletResponse response);

}
