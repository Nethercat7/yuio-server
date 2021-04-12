package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Usr;
import org.springframework.stereotype.Repository;

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
}
