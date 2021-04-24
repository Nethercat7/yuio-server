package com.zfy.yuio.service;

import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.entity.StatsEmplResult;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:18
 */
public interface StatsIntentionService {
    List<StatsEmplResult> getCityInfo(StatsEmplInfo params);
    List<StatsEmplResult> getWorkInfo(StatsEmplInfo params);
}
