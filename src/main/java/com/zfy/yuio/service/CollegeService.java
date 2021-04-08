package com.zfy.yuio.service;

import com.zfy.yuio.entity.College;

import java.util.List;

/**
 *@Description:院系管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
public interface CollegeService {
    /**
     *@Author Nethercat7
     *@Description 添加院系
     *@param college
     *@Return int
     */
    int add(College college);

    /**
     *@Author Nethercat7
     *@Description 查找院系
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.College>
     */
    List<College> get();
}
