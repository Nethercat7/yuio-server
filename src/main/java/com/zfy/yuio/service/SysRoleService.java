package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysRole;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:41
*/
public interface SysRoleService {
    /**
     *@Author Nethercat7
     *@Description Add params
     *@param params
     *@Return int
     */
    int add(SysRole params);

    /**
     *@Author Nethercat7
     *@Description Get Roles
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Role>
     */
    List<SysRole> get();

    /**
     *@Author Nethercat7
     *@Description Delete params
     *@param id
     *@Return int
     */
    int del(Long id);

    /**
     *@Author Nethercat7
     *@Description Update params
     *@param params
     *@Return int
     */
    int upd(SysRole params);
}
