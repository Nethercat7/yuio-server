package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParam;
import com.zfy.yuio.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:04
 */
@Repository
public interface StudentDao {
    /**
     * @param student
     * @Author Nethercat7
     * @Description 添加班级
     * @Return int
     */
    int add(Student student);

    /**
     * @param
     * @Author Nethercat7
     * @Description 获取所有班级
     * @Return java.util.List<com.zfy.yuio.entity.Student>
     */
    List<Student> get(int grade);

    /**
     * @param id
     * @Author Nethercat7
     * @Description 通过ID删除班级
     * @Return int
     */
    int del(String id);

    /**
     * @param student
     * @Author Nethercat7
     * @Description 修改班级信息
     * @Return int
     */
    int upd(Student student);

    /**
     * @param id
     * @Author Nethercat7
     * @Description 通过ID获取学生信息
     * @Return com.zfy.yuio.entity.Student
     */
    Student getById(String id);

    /**
     * @param id
     * @Author Nethercat7
     * @Description 查询该院系下的所有学生信息
     * @Return java.util.List<com.zfy.yuio.entity.Student>
     */
    List<Student> getByCollegeId(String id);

    /**
     * @param id
     * @param grade
     * @Author Nethercat7
     * @Description 查询学生信息以及就业情况填写信息
     * @Return java.util.List<com.zfy.yuio.entity.Student>
     */
    List<Student> getWithEStatusInfo(QueryParam queryParam);

    /**
     * @param
     * @Author Nethercat7
     * @Description 获取学生年级
     * @Return java.util.List<java.lang.Integer>
     */
    List<Integer> getStudentGrade();
}
