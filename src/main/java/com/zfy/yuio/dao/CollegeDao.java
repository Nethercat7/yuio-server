package com.zfy.yuio.dao;

import com.zfy.yuio.entity.College;
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

    /**
     *@Author Nethercat7
     *@Description 根据ID删除院系
     *@param id
     *@Return int
    */
    int del(String id);
}
