package com.zfy.yuio.service;

import com.zfy.yuio.entity.Usr;

import java.util.List;

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

    /**
     *@Author Nethercat7
     *@Description Get user
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Usr>
     */
    List<Usr> get();
}
