package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:18
 */
public interface StatsStatusService {
    List<StatsEmplResult> getCityInfo(QueryParams params);

    StatsEmplResult getWorkInfo(QueryParams params);

    StatsEmplResult getUnEmplStudentPlan(QueryParams params);

    StatsEmplResult getEmplStudentPlan(QueryParams params);
}
