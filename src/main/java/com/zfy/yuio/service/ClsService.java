package com.zfy.yuio.service;

import com.zfy.yuio.entity.Cls;

import java.util.List;

/**
 *@Description:班级管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 0:14
*/
public interface ClsService {
    /**
     *@Author Nethercat7
     *@Description 添加班级
     *@param cls
     *@Return int
     */
    int add(Cls cls);

    /**
     *@Author Nethercat7
     *@Description 获取所有班级
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Cls>
     */
    List<Cls> get();

    /**
     *@Author Nethercat7
     *@Description 通过ID删除班级
     *@param id
     *@Return int
     */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description 修改班级信息
     *@param cls
     *@Return int
     */
    int upd(Cls cls);
}
