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
    int add(Student student);

    List<Student> get(int grade);

    int del(String id);

    int upd(Student student);

    Student getById(String id);

    List<Student> getByCollegeId(String id, int grade);

    List<Student> getWithEStatusInfo(QueryParam queryParam);

    Student getByCode(String code);
}
