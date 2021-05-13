package com.zfy.yuio.service;

import com.zfy.yuio.entity.excel.ExcelRole;
import com.zfy.yuio.entity.system.SysRole;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:赵富源
 *@CreateDate:2021/4/13 22:41
*/
public interface SysRoleService {
    /**
     *@Author 赵富源
     *@Description Add params
     *@param params
     *@Return int
     */
    int add(SysRole params);

    /**
     *@Author 赵富源
     *@Description Get Roles
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Role>
     */
    List<SysRole> get();

    /**
     *@Author 赵富源
     *@Description Delete params
     *@param id
     *@Return int
     */
    int del(Long id);

    /**
     *@Author 赵富源
     *@Description Update params
     *@param params
     *@Return int
     */
    int upd(SysRole params);

    void addFromExcel(List<ExcelRole> params);

    List<SysRole> getByKeyword(String keyword);
}
