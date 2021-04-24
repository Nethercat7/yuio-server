package com.zfy.yuio.dao;

import com.zfy.yuio.entity.StatsEmplInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatsRateDao {
    List<StatsEmplInfo> getEmplInfo(int grade);
    List<StatsEmplInfo> getCollegeEmplInfo(String id,int grade);
}
