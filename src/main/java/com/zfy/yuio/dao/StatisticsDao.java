package com.zfy.yuio.dao;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Statistics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:32
 */
@Repository
public interface StatisticsDao {
    List<Statistics> getEmploymentCityInfo(EStatus eStatus);

    List<Statistics> getEmploymentWorkInfo(EStatus eStatus);

    List<Statistics> getUnEmploymentStudentPlan(EStatus eStatus);

    List<Statistics> getIntentionCityInfo(EStatus eStatus);

    List<Statistics> getIntentionWorkInfo(EStatus eStatus);

    List<Integer> getGrade();
}
