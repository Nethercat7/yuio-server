package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Usr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:用户管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:05
*/
@Repository
public interface UsrDao {
    /**
     *@Author Nethercat7
     *@Description Add user
     *@param usr
     *@Return int
    */
    int add(Usr usr);

    /**
     *@Author Nethercat7
     *@Description Get user
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Usr>
    */
    List<Usr> get();

    /**
     *@Author Nethercat7
     *@Description Delete user
     *@param id
     *@Return int
    */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description Update user
     *@param usr
     *@Return int
    */
    int upd(Usr usr);

    /**
     *@Author Nethercat7
     *@Description Add role for user
     *@param urrId
     *@param urrUsrId
     *@param urrRoleId
     *@Return int
    */
    int addRole(String urrId,String urrUsrId,String urrRoleId);

    /**
     *@Author Nethercat7
     *@Description Get role by user id
     *@param id
     *@Return java.util.List<java.lang.String>
    */
    List<String> getRoles(String id);

    /**
     *@Author Nethercat7
     *@Description Delete role by user id
     *@param id
     *@Return int
    */
    int delRole(String id);
}
