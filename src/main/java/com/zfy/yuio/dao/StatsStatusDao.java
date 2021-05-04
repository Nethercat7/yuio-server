package com.zfy.yuio.dao;

import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.entity.StatsEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsStatusDao {
    List<StatsEmplResult> getCityInfo(WriteEmplInfo eStatus);

    List<StatsEmplResult> getWorkInfo(WriteEmplInfo eStatus);

    List<StatsEmplResult> getStudentPlan(WriteEmplInfo eStatus);
}
