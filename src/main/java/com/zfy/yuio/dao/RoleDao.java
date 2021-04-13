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
}
