package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysMajor;

import java.util.List;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
public interface SysMajorService {
    /**
     *@Author Nethercat7
     *@Description 添加专业
     *@param params
     *@Return int
     */
    int add(SysMajor params);

    /**
     *@Author Nethercat7
     *@Description 查找专业
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.SysMajor>
     */
    List<SysMajor> get();

    /**
     *@Author Nethercat7
     *@Description 根据ID删除专业
     *@param id
     *@Return int
     */
    int del(Long id);

    /**
     *@Author Nethercat7
     *@Description 修改专业信息
     *@param params
     *@Return int
     */
    int upd(SysMajor params);
}
