package com.zfy.yuio.service;

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
}
