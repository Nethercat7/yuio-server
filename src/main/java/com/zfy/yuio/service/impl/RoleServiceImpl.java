package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.RoleDao;
import com.zfy.yuio.entity.Role;
import com.zfy.yuio.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(5,0);

    @Override
    public int add(Role role) {
        //set id
        role.setRoleId(snowflakeIdGeneratorUtil.getId());
        //set pid
        role.setRolePid("0");
        //保存角色权限
        for (String perms:role.getPerms()
             ) {
            roleDao.addPerms(snowflakeIdGeneratorUtil.getId(),role.getRoleId(),perms);
        }
        return roleDao.add(role);
    }

    @Override
    public List<Role> get() {
        List<Role> roles= roleDao.get();
        //获取当前角色所拥有的权限
        for (Role r:roles
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
    public int upd(Role role) {
        //先删除该角色下的所有权限
        roleDao.delPerms(role.getRoleId());
        //再添加权限
        for (String perms:role.getPerms()
             ) {
            roleDao.addPerms(snowflakeIdGeneratorUtil.getId(),role.getRoleId(),perms);
        }
        return roleDao.upd(role);
    }
}
