package com.zfy.yuio.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *@Description:数据统计模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/19 17:32
*/
@Repository
public interface StatisticsDao {
    /**
     *@Author Nethercat7
     *@Description 获取就业城市信息
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    List<Map<String,Object>> getEmploymentCityInfo();

    /**
     *@Author Nethercat7
     *@Description 获取就业岗位信息
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    List<Map<String,Object>> getEmploymentWorkInfo();

    /**
     *@Author Nethercat7
     *@Description 获取未就业学生的规划
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    List<Map<String,Object>> getUnEmploymentStudentPlan();

    /**
     *@Author Nethercat7
     *@Description 获取意向城市信息
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getIntentionCityInfo();

    /**
     *@Author Nethercat7
     *@Description 获取意向岗位信息
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getIntentionWorkInfo();
}
