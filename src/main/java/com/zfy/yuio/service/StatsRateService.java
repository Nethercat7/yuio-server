package com.zfy.yuio.service;

import com.zfy.yuio.entity.StatsEmplResult;

import java.util.List;

public interface StatsRateService {
    StatsEmplResult getEmplInfo(int grade);

    List<StatsEmplResult> getCollegeEmplInfo(int grade);
}
