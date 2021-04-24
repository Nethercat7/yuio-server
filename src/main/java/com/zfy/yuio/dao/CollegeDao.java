package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysCollege;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:院系管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
@Repository
public interface CollegeDao {
    /**
     *@Author Nethercat7
     *@Description 添加院系
     *@param params
     *@Return int
    */
    int add(SysCollege params);

    /**
     *@Author Nethercat7
     *@Description 查找院系
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.SysCollege>
    */
    List<SysCollege> get();

    /**
     *@Author Nethercat7
     *@Description 根据ID删除院系
     *@param id
     *@Return int
    */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description 修改院系信息
     *@param params
     *@Return int
    */
    int upd(SysCollege params);

    /**
     *@Author Nethercat7
     *@Description 通过ID获取院系信息
     *@param id
     *@Return com.zfy.yuio.entity.SysCollege
    */
    SysCollege getById(String id);

    /**
     *@Author Nethercat7
     *@Description 根据ID获取学院名称
     *@param id
     *@Return
    */
    String getNameById(String id);
}
