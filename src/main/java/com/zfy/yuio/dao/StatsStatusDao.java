package com.zfy.yuio.dao;

import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.entity.StatsEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsStatusDao {
    List<StatsEmplResult> getCityInfo(StatsEmplInfo eStatus);

    List<StatsEmplResult> getWorkInfo(StatsEmplInfo eStatus);

    List<StatsEmplResult> getStudentPlan(StatsEmplInfo eStatus);
}
