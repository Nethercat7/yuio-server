package com.zfy.yuio.service;

import com.zfy.yuio.entity.excel.ExcelClass;
import com.zfy.yuio.entity.system.SysClass;

import java.util.List;

/**
 *@Description:班级管理模块
 *@Author:赵富源
 *@CreateDate:2021/4/10 0:14
*/
public interface SysClassService {
    int add(SysClass params);

    List<SysClass> get();

    int del(Long id);

    int upd(SysClass params);

    List<SysClass> getByKeyword(String keyword);

    void addFromExcel(List<ExcelClass> params);
}
