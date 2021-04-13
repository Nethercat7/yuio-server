package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Role;
import org.springframework.stereotype.Repository;

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
}
