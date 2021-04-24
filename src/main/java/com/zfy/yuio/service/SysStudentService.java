package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParam;
import com.zfy.yuio.entity.SysStudent;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
public interface SysStudentService {
    int add(SysStudent params);

    List<SysStudent> get();

    int del(String id);

    int upd(SysStudent params);

    List<SysStudent> getWithEStatusInfo(QueryParam queryParam);

    SysStudent getByCode(String code);
}
