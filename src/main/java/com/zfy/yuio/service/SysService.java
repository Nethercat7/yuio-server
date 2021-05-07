package com.zfy.yuio.service;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.entity.SysPerms;

import java.util.List;
import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 0:40
*/
public interface SysService {

    int resetPwd(Map<String,Object> map);

    ResultBody login(Map<String,Object> map);

    List<SysCollege> getCollegeAndMajor();

    List<SysCollege> getFullOrg(int grade);

    List<Integer> getGrade();

    int changePwd(Map<String,Object> params);

    List<SysPerms> getMenus(String type,Long id);
}
