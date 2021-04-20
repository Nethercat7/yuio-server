package com.zfy.yuio.service;

import java.util.List;
import java.util.Map;

/**
 *@Description:数据统计模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/19 17:18
*/
public interface StatisticsService {
    /**
     *@Author Nethercat7
     *@Description 获取整个学校总就业情况
     *@param
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getTotalEmploymentInfo();

    /**
     *@Author Nethercat7
     *@Description 获取各学院的就业情况
     *@param
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getCollegeEmploymentInfo();

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
