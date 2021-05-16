package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;

public interface StatsRateService {
    StatsEmplResult getEmplInfo(QueryParams params);
}
