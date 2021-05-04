package com.zfy.yuio.dao;

import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.entity.WriteEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsStatusDao {
    List<WriteEmplResult> getCityInfo(WriteEmplInfo eStatus);

    List<WriteEmplResult> getWorkInfo(WriteEmplInfo eStatus);

    List<WriteEmplResult> getStudentPlan(WriteEmplInfo eStatus);
}
