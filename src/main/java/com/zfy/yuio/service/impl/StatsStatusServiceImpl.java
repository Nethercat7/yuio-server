package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsStatusDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import com.zfy.yuio.service.StatsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Comparator;
import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:19
 */
@Service
public class StatsStatusServiceImpl implements StatsStatusService {
    @Autowired
    private StatsStatusDao statusDao;

    @Override
    public List<StatsEmplResult> getCityInfo(QueryParams params) {
        params.setEmplStatus("1");
        return statusDao.getCityInfo(params);
    }

    @Override
    public StatsEmplResult getWorkInfo(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("1");
        //获取就业岗位信息
        List<StatsEmplResult> results = statusDao.getWorkInfo(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //计算工作岗位最多的人数
            result.setMax(results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople)).get().getTotalPeople());
            //获取总工作岗位排行
            List<StatsEmplResult> totalWorkRank=statusDao.getWorkRank(params);
            result.setTotalWorkRank(totalWorkRank);
            //获取女生工作岗位排行
            params.setGender("0");
            List<StatsEmplResult> femaleWorkRank=statusDao.getWorkRank(params);
            result.setFemaleWorkRank(femaleWorkRank);
            //获取男生工作岗位排行
            params.setGender("1");
            List<StatsEmplResult> maleWorkRank=statusDao.getWorkRank(params);
            result.setMaleWorkRank(maleWorkRank);
        }
        return result;
    }

    @Override
    public StatsEmplResult getStudentPlan(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("0");
        List<StatsEmplResult> results = statusDao.getStudentPlan(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
        }
        return result;
    }
}
