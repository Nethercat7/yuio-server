package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:18
 */
public interface StatsStatusService {
    StatsEmplResult getCityInfo(QueryParams params);

    StatsEmplResult getWorkInfo(QueryParams params);

    StatsEmplResult getStudentPlan(QueryParams params);
}
