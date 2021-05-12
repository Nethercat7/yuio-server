package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsStatusDao;
import com.zfy.yuio.dao.SysWorkDao;
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

    @Autowired
    private SysWorkDao workDao;

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
            /*  暂时禁用，等待后续开发。
            //将数据转换为 行业[岗位1,...n] 的List形式
            List<StatsEmplResult> rs = new ArrayList<StatsEmplResult>();//用于存放最顶层的行业信息
            //按照行业ID分类
            Map<Long, List<StatsEmplResult>> industries = results.stream().collect(Collectors.groupingBy(StatsEmplResult::getWorkPid));
            //获取ID集
            Set<Long> keys = industries.keySet();
            for (Long key : keys
            ) {
                //行业实体
                StatsEmplResult r = new StatsEmplResult();
                //获取该行业下的岗位
                List<StatsEmplResult> industry = industries.get(key);
                //获取行业的名字
                String name = workDao.getById(key).getWorkName();
                r.setResults(industry);
                r.setWorkName(name);
                rs.add(r);
            }*/
            //添加上面的信息
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
    public StatsEmplResult getStudentPlan(QueryParams params) {
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
}
