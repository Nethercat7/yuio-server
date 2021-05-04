package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysClass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:班级管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 0:11
*/
@Repository
public interface SysClsDao {
    /**
     *@Author Nethercat7
     *@Description 添加班级
     *@param params
     *@Return int
    */
    int add(SysClass params);

    /**
     *@Author Nethercat7
     *@Description 获取所有班级
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.SysClass>
    */
    List<SysClass> get();

    /**
     *@Author Nethercat7
     *@Description 通过ID删除班级
     *@param id
     *@Return int
    */
    int del(Long id);

    /**
     *@Author Nethercat7
     *@Description 修改班级信息
     *@param params
     *@Return int
    */
    int upd(SysClass params);

    /**
     *@Author Nethercat7
     *@Description 通过院系ID获取专业
     *@param pid
     *@Return java.util.List<com.zfy.yuio.entity.SysClass>
     */
    List<SysClass> getByPid(Long pid, int grade);
}
