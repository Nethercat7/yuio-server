package com.zfy.yuio.service;

import com.zfy.yuio.entity.Usr;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:07
*/
public interface UsrService {
    /**
     *@Author Nethercat7
     *@Description Add user
     *@param usr
     *@Return int
     */
    int add(Usr usr);
}
