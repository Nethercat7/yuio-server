package com.zfy.yuio.dao;

import com.zfy.yuio.entity.system.SysWork;
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
    int del(Long id);

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
     *@Return com.zfy.yuio.entity.system.SysWork
    */
    SysWork getById(Long id);

    List<SysWork> getByKeyword(String keyword);
}
