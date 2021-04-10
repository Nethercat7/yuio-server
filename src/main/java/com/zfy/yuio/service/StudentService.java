package com.zfy.yuio.service;

import com.zfy.yuio.entity.Student;

import java.util.List;

/**
 *@Description:学生管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 16:08
*/
public interface StudentService {
    /**
     *@Author Nethercat7
     *@Description 添加班级
     *@param student
     *@Return int
     */
    int add(Student student);

    /**
     *@Author Nethercat7
     *@Description 获取所有班级
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Student>
     */
    List<Student> get();

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
     *@param student
     *@Return int
     */
    int upd(Student student);
}
