package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.excel.ExcelStudent;
import com.zfy.yuio.entity.system.SysStudent;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
public interface SysStudentService {
    int add(SysStudent params);

    List<SysStudent> get(QueryParams params);

    int del(Long id);

    int upd(SysStudent params);

    SysStudent getById(Long id);

    int updProfile(SysStudent params);

    void addFromExcel(List<ExcelStudent> params);
}
