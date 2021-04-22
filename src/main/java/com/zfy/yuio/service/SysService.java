package com.zfy.yuio.service;

import com.zfy.yuio.entity.College;
import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.Student;

import java.util.List;
import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 0:40
*/
public interface SysService {
    /**
     *@Author Nethercat7
     *@Description 重置密码
     *@param map
     *@Return int
     */
    int resetPwd(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 登录
     *@param map
     *@Return int
    */
    int login(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 保存填写的就业情况信息
     *@param eStatus
     *@Return int
     */
    int saveEmploymentStatus(EStatus eStatus);

    /**
     *@Author Nethercat7
     *@Description 学生登录
     *@param student
     *@Return com.zfy.yuio.entity.ResultBody
    */
    ResultBody studentLogin(Student student);

    /**
     *@Author Nethercat7
     *@Description 通过ID获取就业情况统计信息
     *@param id
     *@Return com.zfy.yuio.entity.EStatus
     */
    EStatus getEStatusById(String id);


    /**
     *@Author Nethercat7
     *@Description 获取院系以及旗下的专业
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.College>
     */
    List<College> getCollegeAndMajor();

    /**
     *@Author Nethercat7
     *@Description 获取关联的院系、专业以及班级信息
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.College>
    */
    List<College> getFullOrg(int grade);

    List<Map<String,Object>> getGrade();
}
