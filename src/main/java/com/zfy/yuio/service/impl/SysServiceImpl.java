package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDao;
import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.Student;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.JWTUtil;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Description:系统功能模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 0:40
 */
@Service
public class SysServiceImpl implements SysService {
    @Autowired
    private SysDao sysDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(7, 0);

    @Override
    public int resetPwd(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        //获取随机盐
        Map<String, String> info = sysDao.getPwd(isUser, key);
        String pwd = "";
        if (isUser) {
            //do user op
            String salt = info.get("usr_slat");
            pwd = ShiroUtil.pwd2MD5("123456", salt, 1739);
        } else {
            String salt = info.get("student_salt");
            pwd = ShiroUtil.pwd2MD5("123456", salt, 1739);
        }
        return sysDao.resetPwd(isUser, key, pwd);
    }

    @Override
    public int login(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        String pwd = String.valueOf(map.get("pwd"));
        Map<String, String> info = sysDao.getPwd(isUser, key);
        if (info != null) {
            String currentPwd = "";
            String salt = "";
            if (isUser) {
                currentPwd = info.get("user_pwd");
                salt = info.get("user_salt");
            } else {
                currentPwd = info.get("student_pwd");
                salt = info.get("student_salt");
            }
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(pwd, salt, 1739))) {
                return 2;
            }
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int saveEmploymentStatus(EStatus eStatus) {
        eStatus.setEsId(snowflakeIdGeneratorUtil.getId());
        return sysDao.saveEmploymentStatus(eStatus);
    }

    @Override
    public ResultBody studentLogin(Student student) {
        Student loginInfo = sysDao.getStudentLoginInfo(student);
        String inputPwd = student.getStudentPwd();
        if (loginInfo != null) {
            String currentPwd = loginInfo.getStudentPwd();
            String salt = loginInfo.getStudentSalt();
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(inputPwd, salt, 1739))) return new ResultBody(2,"密码不正确","error");
        } else {
            return new ResultBody(1,"账号不存在","error");
        }
        return new ResultBody(0,JWTUtil.createToken(loginInfo.getStudentId(),loginInfo.getStudentName(),loginInfo.getStudentCode()));
    }
}
