package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysUser;

import java.util.List;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:07
*/
public interface SysUserService {
    int add(SysUser params);

    List<SysUser> get();

    int del(Long id);

    int upd(SysUser params);

    SysUser getById(Long id);

    List<SysUser> getByKeyword(String keyword);

    int updProfile(SysUser params);
}
