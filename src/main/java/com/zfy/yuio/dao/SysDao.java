package com.zfy.yuio.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/11 23:56
*/
@Repository
public interface SysDao {
    /**
     *@Author Nethercat7
     *@Description 重置密码
     *@param type
     *@param key
     *@param pwd
     *@Return int
     */
    int resetPwd(int type,String key,String pwd);

    /**
     *@Author Nethercat7
     *@Description 获取密码信息
     *@param type
     *@param key
     *@Return java.util.Map<java.lang.String,java.lang.String>
    */
    Map<String,String> getPwd(int type,String key);
}
