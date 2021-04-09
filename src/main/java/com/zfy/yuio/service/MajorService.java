package com.zfy.yuio.service;

import com.zfy.yuio.entity.Major;

import java.util.List;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
public interface MajorService {
    /**
     *@Author Nethercat7
     *@Description 添加专业
     *@param major
     *@Return int
     */
    int add(Major major);

    /**
     *@Author Nethercat7
     *@Description 查找专业
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Major>
     */
    List<Major> get();

    /**
     *@Author Nethercat7
     *@Description 根据ID删除专业
     *@param id
     *@Return int
     */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description 修改专业信息
     *@param major
     *@Return int
     */
    int upd(Major major);
}
