package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsIntentionDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import com.zfy.yuio.service.StatsIntentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public StatsEmplResult getIntentionWorks(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        DecimalFormat df = new DecimalFormat("0.00");
        List<StatsEmplResult> results = intentionDao.getIntentionWorks(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //计算总人数
            int totalPeople = results.stream().mapToInt(StatsEmplResult::getTotalPeople).sum();
            //计算最多人选择的岗位
            Optional<StatsEmplResult> most = results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople));
            String mostRate = df.format((float) (totalPeople - (totalPeople - most.get().getTotalPeople())) / (float) totalPeople * 100);
            most.get().setEmplRate(mostRate);
            result.setMost(most.get());
            //计算不同性别选择最多的岗位
            params.setMost("0");
            params.setGender("0");
            StatsEmplResult femaleMost = intentionDao.getIntentionWorksByGender(params);
            result.setFemaleMost(femaleMost);
            params.setGender("1");
            StatsEmplResult maleMost = intentionDao.getIntentionWorksByGender(params);
            result.setMaleMost(maleMost);
            //计算不同性别中其次选择最多的岗位
            params.setMost("1");
            StatsEmplResult maleSecond = intentionDao.getIntentionWorksByGender(params);
            result.setMaleSecond(maleSecond);
            params.setGender("0");
            StatsEmplResult femaleSecond = intentionDao.getIntentionWorksByGender(params);
            result.setFemaleSecond(femaleSecond);
        }
        return result;
    }
}
