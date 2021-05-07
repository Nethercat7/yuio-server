package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.*;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.JWTUtil;
import com.zfy.yuio.utils.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
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

    @Autowired
    private SysStudentDao studentDao;

    @Autowired
    private SysCollegeDao collegeDao;

    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysClassDao classDao;

    @Autowired
    private SysUserDao userDao;

    @Override
    public int resetPwd(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        //获取随机盐
        Map<String, String> info = sysDao.getPwd(isUser, key);
        String pwd = "";
        if (isUser) {
            String salt = info.get("user_salt");
            pwd = ShiroUtil.pwd2MD5("123456", salt, 1739);
        } else {
            String salt = info.get("student_salt");
            pwd = ShiroUtil.pwd2MD5("123456", salt, 1739);
        }
        return sysDao.resetPwd(isUser, key, pwd);
    }

    @Override
    public ResultBody login(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        String pwd = String.valueOf(map.get("pwd"));
        if (isUser) return usrLogin(key, pwd);
        return studentLogin(key, pwd);
    }

    @Override
    public List<SysCollege> getCollegeAndMajor() {
        List<SysCollege> colleges = collegeDao.get();
        for (SysCollege c : colleges
        ) {
            c.setChildren(majorDao.getByPid(c.getCollegeId()));
        }
        return colleges;
    }

    @Override
    public List<SysCollege> getFullOrg(int grade) {
        List<SysCollege> collegeList = collegeDao.get();
        //添加之间的关联
        for (SysCollege c : collegeList
        ) {
            //获取院系下的专业
            List<SysMajor> majors = majorDao.getByPid(c.getCollegeId());
            for (SysMajor m : majors
            ) {
                //获取专业下的班级
                m.setChildren(classDao.getByPid(m.getMajorId(), grade));
            }
            c.setChildren(majors);
        }
        return collegeList;
    }

    @Override
    public List<Integer> getGrade() {
        return sysDao.getGrade();
    }

    @Override
    public int changePwd(Map<String, Object> params) {
        Long id = Long.valueOf(String.valueOf(params.get("id")));
        String oldPwd = String.valueOf(params.get("oldPwd"));
        String newPwd = String.valueOf(params.get("newPwd"));
        String type=String.valueOf(params.get(("type")));
        if(type.equals("usr")){
            SysUser user = userDao.getPwdInfo(id);
            if (!ObjectUtils.isEmpty(user)) {
                String salt = user.getUserSalt();
                if (ShiroUtil.pwd2MD5(oldPwd, salt, 1739).equals(user.getUserPwd())) {
                    String pwd = ShiroUtil.pwd2MD5(newPwd, salt, 1739);
                    return userDao.changePwd(id, pwd);
                } else {
                    return 2;
                }
            } else {
                return 0;
            }
        }else{
            SysStudent student = studentDao.getPwdInfo(id);
            if (!ObjectUtils.isEmpty(student)) {
                String salt = student.getStudentSalt();
                if (ShiroUtil.pwd2MD5(oldPwd, salt, 1739).equals(student.getStudentPwd())) {
                    String pwd = ShiroUtil.pwd2MD5(newPwd, salt, 1739);
                    return studentDao.changePwd(id, pwd);
                } else {
                    return 2;
                }
            } else {
                return 0;
            }
        }
    }

    private ResultBody studentLogin(String code, String pwd) {
        SysStudent loginInfo = sysDao.getStudentLoginInfo(code);
        if (loginInfo != null) {
            String currentPwd = loginInfo.getStudentPwd();
            String salt = loginInfo.getStudentSalt();
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(pwd, salt, 1739))) return new ResultBody(2, "密码不正确", "error");
        } else {
            return new ResultBody(1, "账号不存在", "error");
        }
        return new ResultBody(0, JWTUtil.createToken(loginInfo.getStudentId(), loginInfo.getStudentName(), loginInfo.getStudentCode(),"student"));
    }

    private ResultBody usrLogin(String account, String pwd) {
        SysUser loginInfo = sysDao.getUsrLoginInfo(account);
        if (loginInfo != null) {
            String currentPwd = loginInfo.getUserPwd();
            String salt = loginInfo.getUserSalt();
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(pwd, salt, 1739))) return new ResultBody(2, "密码不正确", "error");
        } else {
            return new ResultBody(1, "账号不存在", "error");
        }
        return new ResultBody(0, JWTUtil.createToken(loginInfo.getUserId(), loginInfo.getUserName(), loginInfo.getUserCode(),"usr"));
    }
}
