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
 * @Description:就业情况模块
 * @Author:赵富源
 * @CreateDate:2021/4/19 17:45
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
        List<StatsEmplResult> results = statusDao.getWorkInfo(params);//用于stream分类
        if (!ObjectUtils.isEmpty(results)) {
            //添加岗位信息
            result.setResults(results);
            //计算工作岗位最多的人数
            result.setMax(results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople)).get().getTotalPeople());
            //获取总工作岗位排行
            List<StatsEmplResult> totalWorkRank = statusDao.getWorkRank(params);
            result.setTotalRank(totalWorkRank);
            //获取女生工作岗位排行
            params.setGender("0");
            List<StatsEmplResult> femaleWorkRank = statusDao.getWorkRank(params);
            result.setFemaleRank(femaleWorkRank);
            //获取男生工作岗位排行
            params.setGender("1");
            List<StatsEmplResult> maleWorkRank = statusDao.getWorkRank(params);
            result.setMaleRank(maleWorkRank);
        }
        return result;
    }

    @Override
    public StatsEmplResult getUnEmplStudentPlan(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("0");
        List<StatsEmplResult> results = statusDao.getStudentPlan(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //获取总学生计划排行
            List<StatsEmplResult> totalPlanRank = statusDao.getPlanRank(params);
            result.setTotalRank(totalPlanRank);
            //获取女生计划排行
            params.setGender("0");
            List<StatsEmplResult> femalePlanRank = statusDao.getPlanRank(params);
            result.setFemaleRank(femalePlanRank);
            //获取男生计划排行
            params.setGender("1");
            List<StatsEmplResult> malePlanRank = statusDao.getPlanRank(params);
            result.setMaleRank(malePlanRank);
        }
        return result;
    }

    @Override
    public StatsEmplResult getEmplStudentPlan(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("1");
        List<StatsEmplResult> results = statusDao.getStudentPlan(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //获取总学生计划排行
            List<StatsEmplResult> totalPlanRank = statusDao.getPlanRank(params);
            result.setTotalRank(totalPlanRank);
            //获取女生计划排行
            params.setGender("0");
            List<StatsEmplResult> femalePlanRank = statusDao.getPlanRank(params);
            result.setFemaleRank(femalePlanRank);
            //获取男生计划排行
            params.setGender("1");
            List<StatsEmplResult> malePlanRank = statusDao.getPlanRank(params);
            result.setMaleRank(malePlanRank);
        }
        return result;
    }
}
