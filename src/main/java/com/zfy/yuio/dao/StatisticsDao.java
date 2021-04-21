package com.zfy.yuio.dao;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Statistics;
import com.zfy.yuio.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    List<Map<String, Object>> getIntentionCityInfo(int grade, String id);

    List<Map<String, Object>> getIntentionWorkInfo(int grade, String id);

    List<Integer> getGrade();

    List<Student> getEStatusStudentInfo(String id, int grade);
}
