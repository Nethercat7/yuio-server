package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysRoleDao;
import com.zfy.yuio.entity.SysRole;
import com.zfy.yuio.service.SysRoleService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:Role mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:41
*/
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao roleDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(5,0);

    @Override
    public int add(SysRole params) {
        //set id
        params.setRoleId(snowflakeIdGeneratorUtil.getId());
        //set pid
        params.setRolePid("0");
        //保存角色权限
        for (String perms:params.getPerms()
             ) {
            roleDao.addPerms(snowflakeIdGeneratorUtil.getId(),params.getRoleId(),perms);
        }
        return roleDao.add(params);
    }

    @Override
    public List<SysRole> get() {
        List<SysRole> roles= roleDao.get();
        //获取当前角色所拥有的权限
        for (SysRole r:roles
             ) {
            r.setPerms(roleDao.getRolePerms(r.getRoleId()));
        }
        return roles;
    }

    @Override
    public int del(String id) {
        //先删除角色权限
        roleDao.delPerms(id);
        return roleDao.del(id);
    }

    @Override
    public int upd(SysRole params) {
        //先删除该角色下的所有权限
        roleDao.delPerms(params.getRoleId());
        //再添加权限
        for (String perms:params.getPerms()
             ) {
            roleDao.addPerms(snowflakeIdGeneratorUtil.getId(),params.getRoleId(),perms);
        }
        return roleDao.upd(params);
    }
}
