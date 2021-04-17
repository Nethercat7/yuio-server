package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:学生管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 16:04
*/
@Repository
public interface StudentDao {
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

    /**
     *@Author Nethercat7
     *@Description 通过ID获取学生信息
     *@param id
     *@Return com.zfy.yuio.entity.Student
    */
    Student getById(String id);
}
