package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysUser;

import java.util.List;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:07
*/
public interface SysUserService {
    int add(SysUser params);

    List<SysUser> get();

    int del(String id);

    int upd(SysUser params);

    SysUser getByCode(String param);
}
