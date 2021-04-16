package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:39
*/
@Repository
public interface RoleDao {
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

    /**
     *@Author Nethercat7
     *@Description Update role
     *@param role
     *@Return int
     */
    int upd(Role role);

    /**
     *@Author Nethercat7
     *@Description 添加角色权限
     *@param rprId
     *@param rprRoleId
     *@param rprPermsId
     *@Return int
    */
    int addPerms(String rprId,String rprRoleId,String rprPermsId);

    /**
     *@Author Nethercat7
     *@Description 通过角色Id获取该角色所拥有的权限
     *@param id
     *@Return java.util.List<java.lang.String>
    */
    List<String> getRolePerms(String id);

    /**
     *@Author Nethercat7
     *@Description 通过Id删除权限
     *@param id
     *@Return int
    */
    int delPerms(String id);
}
