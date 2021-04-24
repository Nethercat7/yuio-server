package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysWork;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:岗位管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:45
*/
@Repository
public interface SysWorkDao {
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
     *@Description 通过Id获取城市
     *@param id
     *@Return com.zfy.yuio.entity.SysWork
    */
    SysWork getById(String id);

    /**
     *@Author Nethercat7
     *@Description 通过PID获取城市
     *@param pid
     *@Return com.zfy.yuio.entity.SysWork
    */
    List<SysWork> getByPid(String pid);

    /**
     *@Author Nethercat7
     *@Description 通过Id获取岗位名称
     *@param id
     *@Return java.lang.String
    */
    String getWorkName(String id);
}
