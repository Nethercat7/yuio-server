package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.excel.ExcelStudent;
import com.zfy.yuio.entity.system.SysStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:赵富源
 * @CreateDate:2021/4/10 16:04
 */
@Repository
public interface SysStudentDao {
    int add(SysStudent params);

    List<SysStudent> get(QueryParams params);

    int del(Long id);

    int upd(SysStudent params);

    SysStudent getById(Long id);

    int addRole(Long studentId,Long roleId);

    int updProfile(SysStudent params);

    void addFromExcel(List<ExcelStudent> params);

    Long verify(String key);

    void addTutor(List<String> teacherCode,String studentCode);
}
