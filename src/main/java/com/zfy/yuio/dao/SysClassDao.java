package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysClass;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:班级管理模块
 *@Author:Nethercat7
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
}
