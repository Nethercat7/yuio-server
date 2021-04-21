package com.zfy.yuio.service;

import com.zfy.yuio.entity.Student;

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
     *@param grade
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getTotalEmploymentInfo(int grade);

    /**
     *@Author Nethercat7
     *@Description 获取各学院的就业情况
     *@param grade
     *@Return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> getCollegeEmploymentInfo(int grade);

    /**
     *@Author Nethercat7
     *@Description 获取就业城市信息
     *@param map
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getEmploymentCityInfo(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 获取就业岗位信息
     *@param map
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getEmploymentWorkInfo(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 获取未就业学生的规划
     *@param map
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getUnEmploymentStudentPlan(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 获取意向城市信息
     *@param map
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getIntentionCityInfo(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 获取意向岗位信息
     *@param map
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     */
    List<Map<String,Object>> getIntentionWorkInfo(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 获取年级
     *@param
     *@Return java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    */
    List<Map<String,Object>> getGrade();

    /**
     *@Author Nethercat7
     *@Description 获取各学生的就业情况信息填写状况
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Student>
     */
    List<Student> getEStatusStudentInfo(Map<String,Object> map);
}
