package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsIntentionDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.service.StatsIntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:19
 */
@Service
public class StatsIntentionServiceImpl implements StatsIntentionService {
    @Autowired
    private StatsIntentionDao intentionDao;

    @Override
    public List<StatsEmplResult> getIntentionCities(QueryParams params) {
        return intentionDao.getIntentionCities(params);
    }

    @Override
    public List<StatsEmplResult> getIntentionWorks(QueryParams params) {
        return intentionDao.getIntentionWorks(params);
    }
}
