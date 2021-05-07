package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysUser;

import java.util.List;
import java.util.Map;

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

    int changePwd(Map<String,Object> params);
}
