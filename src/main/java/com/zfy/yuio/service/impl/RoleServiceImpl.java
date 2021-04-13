package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.RoleDao;
import com.zfy.yuio.entity.Role;
import com.zfy.yuio.service.RoleService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
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

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(5,0);

    @Override
    public int add(Role role) {
        //set id
        role.setRoleId(snowflakeIdGeneratorUntil.getId());
        //set pid
        role.setRolePid("0");
        return roleDao.add(role);
    }

    @Override
    public List<Role> get() {
        return roleDao.get();
    }

    @Override
    public int del(String id) {
        return roleDao.del(id);
    }

    @Override
    public int upd(Role role) {
        return roleDao.upd(role);
    }
}
