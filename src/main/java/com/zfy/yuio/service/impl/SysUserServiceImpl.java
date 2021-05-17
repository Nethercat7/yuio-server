package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.excel.ExcelUser;
import com.zfy.yuio.entity.system.SysUser;
import com.zfy.yuio.service.SysUserService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description:User mgt
 * @Author:赵富源
 * @CreateDate:2021/4/12 17:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao userDao;

    @Autowired
    private SysStudentDao studentDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(4, 0);

    @Override
    public int add(SysUser params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setUserId(snowflakeIdGeneratorUtil.nextId());
            params.setUserSalt(ShiroUtil.getSalt(7));
            params.setUserPwd(ShiroUtil.pwd2MD5("123456", params.getUserSalt(), 1739));
            userDao.add(params);
            saveUserRole(params);
        }
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
        //重复性验证
        int status = validator(params, 1);
        if (status == 0) {
            //先删除关系表中的用户角色信息
            userDao.delRole(params.getUserId());
            //再重新添加
            saveUserRole(params);
            userDao.upd(params);
        }
        return status;
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
        int status = validator(params, 1);
        if (status == 0) {
            userDao.updProfile(params);
        }
        return status;
    }

    @Override
    public void addFromExcel(List<ExcelUser> params) {
        for (ExcelUser u : params
        ) {
            u.setUserId(snowflakeIdGeneratorUtil.nextId());
            //set password
            u.setUserSalt(ShiroUtil.getSalt(7));
            u.setUserPwd(ShiroUtil.pwd2MD5("123456", u.getUserSalt(), 1739));
        }
        userDao.addFromExcel(params);
    }

    @Override
    public List<SysUser> getByCollege(Long id) {
        return userDao.getByCollege(id);
    }

    private int validator(SysUser params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(userDao.verify(params.getUserCode()))) return 1;
            if (!ObjectUtils.isEmpty(params.getUserPhone())) {
                Long sPhone=studentDao.verify(params.getUserPhone());
                Long uPhone=userDao.verify(params.getUserPhone());
                if (!ObjectUtils.isEmpty(sPhone)||!ObjectUtils.isEmpty(uPhone)) return 2;
            }
        } else {
            SysUser user = userDao.getById(params.getUserId());
            if (!user.getUserCode().equals(params.getUserCode())) {
                if (!ObjectUtils.isEmpty(userDao.verify(params.getUserCode()))) return 1;
            } else if (!ObjectUtils.isEmpty(params.getUserPhone())) {
                if (!ObjectUtils.isEmpty(user.getUserPhone())) {
                    if (!user.getUserPhone().equals(params.getUserPhone())) {
                        Long sPhone=studentDao.verify(params.getUserPhone());
                        Long uPhone=userDao.verify(params.getUserPhone());
                        if (!ObjectUtils.isEmpty(sPhone)||!ObjectUtils.isEmpty(uPhone)) return 2;
                    }
                } else {
                    Long sPhone=studentDao.verify(params.getUserPhone());
                    Long uPhone=userDao.verify(params.getUserPhone());
                    if (!ObjectUtils.isEmpty(sPhone)||!ObjectUtils.isEmpty(uPhone)) return 2;
                }
            }
        }
        return 0;
    }

    private void saveUserRole(SysUser params) {
        for (Long role : params.getRoles()
        ) {
            userDao.addRole(params.getUserId(), role);
        }
    }
}
