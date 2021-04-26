package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParam;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:04
 */
@Repository
public interface SysStudentDao {
    int add(SysStudent params);

    List<SysStudent> get(int grade);

    int del(String id);

    int upd(SysStudent params);

    SysStudent getById(String id);

    List<SysStudent> getByCollegeId(String id, int grade);

    List<SysStudent> getWithEStatusInfo(QueryParam queryParam);

    SysStudent getByCode(String code);

    List<SysUser> getUsers();
}
