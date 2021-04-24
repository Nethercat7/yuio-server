package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.entity.ResultBody;

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
    ResultBody login(Map<String,Object> map);

    /**
     *@Author Nethercat7
     *@Description 保存填写的就业情况信息
     *@param eStatus
     *@Return int
     */
    int saveEmploymentStatus(StatsEmplInfo eStatus);

    /**
     *@Author Nethercat7
     *@Description 通过ID获取就业情况统计信息
     *@param id
     *@Return com.zfy.yuio.entity.StatsEmplInfo
     */
    StatsEmplInfo getEStatusById(String id);


    /**
     *@Author Nethercat7
     *@Description 获取院系以及旗下的专业
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.SysCollege>
     */
    List<SysCollege> getCollegeAndMajor();

    /**
     *@Author Nethercat7
     *@Description 获取关联的院系、专业以及班级信息
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.SysCollege>
    */
    List<SysCollege> getFullOrg(int grade);

    List<Map<String,Object>> getGrade();
}
