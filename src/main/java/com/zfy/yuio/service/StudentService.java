package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParam;
import com.zfy.yuio.entity.Student;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
public interface StudentService {
    int add(Student student);

    List<Student> get();

    int del(String id);

    int upd(Student student);

    List<Student> getWithEStatusInfo(QueryParam queryParam);

    Student getByCode(String code);
}
