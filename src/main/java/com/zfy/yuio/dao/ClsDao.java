package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Cls;
import org.springframework.stereotype.Repository;

/**
 *@Description:班级管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 0:11
*/
@Repository
public interface ClsDao {
    /**
     *@Author Nethercat7
     *@Description 添加班级
     *@param cls
     *@Return int
    */
    int add(Cls cls);
}
