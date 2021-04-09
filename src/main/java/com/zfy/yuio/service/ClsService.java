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
}
