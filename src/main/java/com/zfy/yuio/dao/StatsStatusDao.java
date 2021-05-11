package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsStatusDao {
    List<StatsEmplResult> getCityInfo(QueryParams params);

    List<StatsEmplResult> getWorkInfo(QueryParams params);

    List<StatsEmplResult> getStudentPlan(QueryParams params);

    List<StatsEmplResult> getWorkRank(QueryParams params);
}
