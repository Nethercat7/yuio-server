package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.SysUser;
import com.zfy.yuio.service.SysUserService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:08
*/
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao userDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(4,0);

    @Override
    public int add(SysUser params) {
        String userId= snowflakeIdGeneratorUtil.getId();
        //Add role before add user
        for (String role:params.getRoles()
             ) {
            String urrId= snowflakeIdGeneratorUtil.getId();
            userDao.addRole(urrId,userId,role);
        }
        params.setUserId(userId);
        //set random salt
        params.setUserSalt(ShiroUtil.getSalt(7));
        //set default password
        params.setUserPwd(ShiroUtil.pwd2MD5("123456",params.getUserSalt(),1739));
        return userDao.add(params);
    }

    @Override
    public List<SysUser> get() {
        List<SysUser> usrList=userDao.get();
        for (SysUser u:usrList
             ) {
            u.setRoles(userDao.getRoles(u.getUserId()));
        }
        return usrList;
    }

    @Override
    public int del(String id) {
        userDao.delRole(id);
        return userDao.del(id);
    }

    @Override
    public int upd(SysUser params) {
        //先删除关系表中的用户角色信息
        userDao.delRole(params.getUserId());
        //再重新添加
        for (String r: params.getRoles()
             ) {
            userDao.addRole(snowflakeIdGeneratorUtil.getId(),params.getUserId(),r);
        }
        return userDao.upd(params);
    }

    @Override
    public SysUser getByCode(String param) {
        return userDao.getByCode(param);
    }
}
