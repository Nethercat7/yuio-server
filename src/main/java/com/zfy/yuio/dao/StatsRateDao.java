package com.zfy.yuio.dao;

import com.zfy.yuio.entity.WriteEmplInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRateDao {
    List<WriteEmplInfo> getEmplInfo(int grade);
    List<WriteEmplInfo> getCollegeEmplInfo(Long id, int grade);
}
