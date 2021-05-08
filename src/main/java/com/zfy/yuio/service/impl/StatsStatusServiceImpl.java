package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsStatusDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.service.StatsStatusService;
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
public class StatsStatusServiceImpl implements StatsStatusService {
    @Autowired
    private StatsStatusDao statusDao;

    @Autowired
    private SysStudentDao studentDao;

    @Override
    public StatsEmplResult getCityInfo(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("1");
        List<StatsEmplResult> results = statusDao.getCityInfo(params);
        result.setResults(results);
        return result;
    }

    @Override
    public StatsEmplResult getWorkInfo(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        DecimalFormat df = new DecimalFormat("0.00");
        params.setEmplStatus("1");
        //获取就业岗位信息
        List<StatsEmplResult> results = statusDao.getWorkInfo(params);
        if (!ObjectUtils.isEmpty(results)) {
            result.setResults(results);
            //计算总人数
            int totalPeople = results.stream().mapToInt(StatsEmplResult::getTotalPeople).sum();
            //计算人数最多的就业岗位
            Optional<StatsEmplResult> most = results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople));
            String mostRate = df.format((float) (totalPeople - (totalPeople - most.get().getTotalPeople())) / (float) totalPeople * 100);
            most.get().setEmplRate(mostRate);
            result.setMost(most.get());
            //获取女性人数最多的岗位
            params.setMost("0");
            params.setGender("0");
            StatsEmplResult female = statusDao.getMaxWorkInfoByGender(params);
            result.setFemaleMost(female);
            //获取男性人数最多的岗位
            params.setGender("1");
            StatsEmplResult male = statusDao.getMaxWorkInfoByGender(params);
            result.setMaleMost(male);
            //获取不同性别其次选择最多的岗位
            params.setMost("1");
            StatsEmplResult maleSecond = statusDao.getMaxWorkInfoByGender(params);
            result.setMaleSecond(maleSecond);
            params.setGender("0");
            StatsEmplResult femaleSecond = statusDao.getMaxWorkInfoByGender(params);
            result.setFemaleSecond(femaleSecond);
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
            //获取所有人总最多选择的计划
            Optional<StatsEmplResult> most = results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople));
            result.setMost(most.get());
            //获取不同性别中选择最多的计划
            params.setMost("0");
            params.setGender("0");
            StatsEmplResult femaleMost = statusDao.getMostStudentPlanByGender(params);
            result.setFemaleMost(femaleMost);
            params.setGender("1");
            StatsEmplResult maleMost = statusDao.getMostStudentPlanByGender(params);
            result.setMaleMost(maleMost);
            //获取不同性别中其次选择最多的计划
            params.setMost("1");
            StatsEmplResult maleSecond = statusDao.getMostStudentPlanByGender(params);
            result.setMaleSecond(maleSecond);
            params.setGender("0");
            StatsEmplResult femaleSecond = statusDao.getMostStudentPlanByGender(params);
            result.setFemaleSecond(femaleSecond);
        }
        return result;
    }
}
