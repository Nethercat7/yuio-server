package com.zfy.yuio.service;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Statistics;

import java.util.List;
import java.util.Map;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:18
 */
public interface StatisticsService {
    Map<String, Object> getTotalEmploymentInfo(int grade);

    Map<String, Object> getCollegeEmploymentInfo(int grade);

    List<Statistics> getEmploymentCityInfo(EStatus eStatus);

    List<Statistics> getEmploymentWorkInfo(EStatus eStatus);

    List<Statistics> getUnEmploymentStudentPlan(EStatus eStatus);

    List<Map<String, Object>> getIntentionCityInfo(Map<String, Object> map);

    List<Map<String, Object>> getIntentionWorkInfo(Map<String, Object> map);

    List<Map<String, Object>> getGrade();
}
