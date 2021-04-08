package com.zfy.yuio.service;

import com.zfy.yuio.entity.College;

/**
 *@Description:院系
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
}
