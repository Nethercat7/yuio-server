package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysPerms;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:11
*/
public interface SysMenuService {

    int add(SysPerms params);


    List<SysPerms> get();


    int del(String id);

    int upd(SysPerms params);

    List<String> getUserPerms(String id);
}
