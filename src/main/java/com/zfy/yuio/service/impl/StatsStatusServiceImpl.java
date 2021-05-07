package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsStatusDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.service.StatsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public StatsEmplResult getWorkInfo(QueryParams params) {
        StatsEmplResult result = new StatsEmplResult();
        params.setEmplStatus("1");
        //获取就业岗位信息
        List<StatsEmplResult> results = statusDao.getWorkInfo(params);
        result.setResults(results);
        //计算人数最多的就业岗位
        Optional<StatsEmplResult> max = results.stream().max(Comparator.comparing(StatsEmplResult::getTotalPeople));
        result.setMax(max.get());
        //获取女性人数最多的岗位
        params.setGender("0");
        StatsEmplResult female = statusDao.getMaxWorkInfoByGender(params);
        result.setFemaleMax(female);
        //获取男性人数最多的岗位
        params.setGender("1");
        StatsEmplResult male = statusDao.getMaxWorkInfoByGender(params);
        result.setMaleMax(male);
        return result;
    }

    @Override
    public StatsEmplResult getStudentPlan(QueryParams params) {
        return null;
    }
}
