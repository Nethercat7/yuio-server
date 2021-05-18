package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelClass;
import com.zfy.yuio.entity.system.SysClass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:班级管理模块
 *@Author:赵富源
 *@CreateDate:2021/4/10 0:11
*/
@Repository
public interface SysClassDao {
    int add(SysClass params);

    List<SysClass> get();

    int del(Long id);

    int upd(SysClass params);

    List<SysClass> getByPid(Long pid, int grade);

    List<SysClass> getByKeyword(String keyword);

    List<SysClass> getByGrade(int grade);

    Long getIdByName(String name);

    void addFromExcel(List<ExcelClass> params);

    SysClass getById(Long id);

    Long genGetCollegeId(Long id);
}
