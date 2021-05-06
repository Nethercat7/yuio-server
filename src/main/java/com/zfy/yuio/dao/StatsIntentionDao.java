package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:32
 */
@Repository
public interface StatsIntentionDao {
    List<StatsEmplResult> getIntentionCities(QueryParams params);
}
