package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysCity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:45
*/
@Repository
public interface SysCityDao {
    /**
     *@Author Nethercat7
     *@Description 添加城市
     *@param params
     *@Return int
    */
    int add(SysCity params);

    /**
     *@Author Nethercat7
     *@Description 获取城市信息
     *@param
     *@Return List<SysCity>
    */
    List<SysCity> get();

    /**
     *@Author Nethercat7
     *@Description 通过Id删除城市
     *@param id
     *@Return int
    */
    int del(Long id);

    /**
     *@Author Nethercat7
     *@Description 修改城市
     *@param params
     *@Return int
    */
    int upd(SysCity params);

    /**
     *@Author Nethercat7
     *@Description 通过Id获取城市
     *@param id
     *@Return com.zfy.yuio.entity.SysCity
    */
    SysCity getById(Long id);

    /**
     *@Author Nethercat7
     *@Description 通过PID获取城市
     *@param pid
     *@Return com.zfy.yuio.entity.SysCity
    */
    List<SysCity> getByPid(String pid);

    /**
     *@Author Nethercat7
     *@Description 通过Id获取城市名称
     *@param id
     *@Return java.lang.String
    */
    String getCityName(Long id);
}
