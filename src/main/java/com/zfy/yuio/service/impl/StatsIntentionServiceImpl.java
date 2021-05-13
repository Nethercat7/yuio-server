package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsIntentionDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import com.zfy.yuio.service.StatsIntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description:数据意向模块
 * @Author:赵富源
 * @CreateDate:2021/4/19 18:07
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
    public StatsEmplResult getIntentionWorks(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        List<StatsEmplResult> results = intentionDao.getIntentionWorks(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //获取总工作岗位排名
            List<StatsEmplResult> totalWorkRank = intentionDao.getWorkRank(params);
            result.setTotalRank(totalWorkRank);
            //获取女生工作岗位排名
            params.setGender("0");
            List<StatsEmplResult> femaleWorkRank = intentionDao.getWorkRank(params);
            result.setFemaleRank(femaleWorkRank);
            //获取男生工作岗位排名
            params.setGender("1");
            List<StatsEmplResult> maleWorkRank = intentionDao.getWorkRank(params);
            result.setMaleRank(maleWorkRank);
        }
        return result;
    }
}
