package com.zfy.yuio.service;

import com.zfy.yuio.entity.Role;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:41
*/
public interface RoleService {
    /**
     *@Author Nethercat7
     *@Description Add role
     *@param role
     *@Return int
     */
    int add(Role role);

    /**
     *@Author Nethercat7
     *@Description Get Roles
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Role>
     */
    List<Role> get();

    /**
     *@Author Nethercat7
     *@Description Delete role
     *@param id
     *@Return int
     */
    int del(String id);
}
