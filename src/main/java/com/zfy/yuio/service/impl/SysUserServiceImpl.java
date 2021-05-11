package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.excel.ExcelUser;
import com.zfy.yuio.entity.system.SysUser;
import com.zfy.yuio.service.SysUserService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:User mgt
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 17:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao userDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(4, 0);

    @Override
    public int add(SysUser params) {
        params.setUserId(snowflakeIdGeneratorUtil.nextId());
        params.setUserSalt(ShiroUtil.getSalt(7));
        params.setUserPwd(ShiroUtil.pwd2MD5("123456", params.getUserSalt(), 1739));
        int status = userDao.add(params);
        if (status == 1) saveUserRole(params);
        return status;
    }

    @Override
    public List<SysUser> get() {
        List<SysUser> usrList = userDao.get();
        for (SysUser u : usrList
        ) {
            u.setRoles(userDao.getRoles(u.getUserId()));
        }
        return usrList;
    }

    @Override
    public int del(Long id) {
        userDao.delRole(id);
        return userDao.del(id);
    }

    @Override
    public int upd(SysUser params) {
        //先删除关系表中的用户角色信息
        userDao.delRole(params.getUserId());
        //再重新添加
        saveUserRole(params);
        return userDao.upd(params);
    }

    @Override
    public SysUser getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public List<SysUser> getByKeyword(String keyword) {
        return userDao.getByKeyword(keyword);
    }

    @Override
    public int updProfile(SysUser params) {
        return userDao.updProfile(params);
    }

    @Override
    public void addFromExcel(List<ExcelUser> params) {
        for (ExcelUser u:params
             ) {
            u.setUserId(snowflakeIdGeneratorUtil.nextId());
            //set password
            u.setUserSalt(ShiroUtil.getSalt(7));
            u.setUserPwd(ShiroUtil.pwd2MD5("123456",u.getUserSalt(),1739));
        }
        userDao.addFromExcel(params);
    }

    private void saveUserRole(SysUser params) {
        for (Long role : params.getRoles()
        ) {
            userDao.addRole(params.getUserId(), role);
        }
    }
}
