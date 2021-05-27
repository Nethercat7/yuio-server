package com.zfy.yuio.service;

import com.zfy.yuio.entity.statstics.ExcelCityStatus;
import com.zfy.yuio.entity.statstics.ExcelPlanStats;
import com.zfy.yuio.entity.statstics.ExcelWorkStats;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface StatsDataOutputService {
    void outputCityInfo(List<ExcelCityStatus> excelCityStatuses, HttpServletResponse response);

    void outputWorkInfo(ExcelWorkStats params, HttpServletResponse response);

    void outputStudentPlan(ExcelPlanStats params, HttpServletResponse response);
}
