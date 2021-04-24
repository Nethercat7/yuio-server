package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysWork;

import java.util.List;

/**
 *@Description:岗位管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:47
*/
public interface SysWorkService {
    /**
     *@Author Nethercat7
     *@Description 添加城市
     *@param params
     *@Return int
     */
    int add(SysWork params);

    /**
     *@Author Nethercat7
     *@Description 获取城市信息
     *@param
     *@Return List<SysWork>
     */
    List<SysWork> get();

    /**
     *@Author Nethercat7
     *@Description 通过Id删除城市
     *@param id
     *@Return int
     */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description 修改城市
     *@param params
     *@Return int
     */
    int upd(SysWork params);

    /**
     *@Author Nethercat7
     *@Description 城市信息初始化
     *@param params
     *@Return
    */
    void initial(SysWork params);
}
