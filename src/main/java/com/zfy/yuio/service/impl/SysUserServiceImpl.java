package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.system.SysUser;
import com.zfy.yuio.service.SysUserService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:User mgt
 * @Author:赵富源
 * @CreateDate:2021/4/12 17:08
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Value("${pwd.salt}")
    private int salt;

    @Value("${pwd.hash}")
    private int hash;

    @Value("${pwd.default}")
    private String defaultPwd;

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
            params.setUserSalt(ShiroUtil.getSalt(salt));
            params.setUserPwd(ShiroUtil.pwd2MD5(defaultPwd, params.getUserSalt(), hash));
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
            if(u.getUserStatus().equals("1")){
                u.setDisabled(true);
            }
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
    public void addFromExcel(List<SysUser> params) {
        for (SysUser u : params
        ) {
            u.setUserId(snowflakeIdGeneratorUtil.nextId());
            //set password
            u.setUserSalt(ShiroUtil.getSalt(salt));
            u.setUserPwd(ShiroUtil.pwd2MD5(defaultPwd, u.getUserSalt(), hash));
        }
        userDao.addFromExcel(params);
    }

    @Override
    public List<SysUser> getByCollege(Long id) {
        List<SysUser> users= userDao.getByCollege(id);
        for (SysUser u:users
             ) {
            if(u.getUserStatus().equals("1")){
                u.setDisabled(true);
            }
        }
        return users;
    }

    @Override
    public void output2Excel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "user_data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try{
            List<SysUser> usrList = userDao.get();
            for (SysUser u : usrList
            ) {
                if(u.getUserStatus().equals("1")){
                    u.setDisabled(true);
                }
                u.setRoles(userDao.getRoles(u.getUserId()));
            }
            EasyExcel.write(response.getOutputStream(), SysUser.class).sheet("Sheet1").doWrite(usrList);
        }catch (IOException e){
            e.printStackTrace();
        }
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
