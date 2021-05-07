package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.SysStudent;

import java.util.List;
import java.util.Map;

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

    int changePwd(Map<String,Object> params);
}
