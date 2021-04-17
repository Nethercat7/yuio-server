package com.zfy.yuio.service;

import com.zfy.yuio.entity.EStatus;

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
}
