package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:39
*/
@Repository
public interface SysRoleDao {
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
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description Update params
     *@param params
     *@Return int
     */
    int upd(SysRole params);

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
