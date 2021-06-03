package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.system.*;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.JWTUtil;
import com.zfy.yuio.utils.ShiroUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:系统功能模块
 * @Author:赵富源
 * @CreateDate:2021/4/12 0:40
 */
@Service
public class SysServiceImpl implements SysService {
    @Value("${pwd.hash}")
    private int hash;

    @Value("${pwd.default}")
    private String defaultPwd;

    @Autowired
    private SysDao sysDao;

    @Autowired
    private SysCollegeDao collegeDao;

    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysClassDao classDao;

    @Autowired
    private SysPermsDao permsDao;

    @Override
    public int resetPwd(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        //获取随机盐
        Map<String, String> info = sysDao.getPwd(isUser, key);
        String pwd = "";
        if (isUser) {
            String salt = info.get("user_salt");
            pwd = ShiroUtil.pwd2MD5(defaultPwd, salt, hash);
        } else {
            String salt = info.get("student_salt");
            pwd = ShiroUtil.pwd2MD5(defaultPwd, salt, hash);
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
            if (c.getCollegeStatus().equals("1")) {
                c.setDisabled(true);
            }
            List<SysMajor> majors = majorDao.getByPid(c.getCollegeId());
            for (SysMajor m : majors
            ) {
                if (m.getMajorStatus().equals("1")) {
                    m.setDisabled(true);
                }
            }
            c.setChildren(majors);
        }
        return colleges;
    }

    @Override
    public List<SysCollege> getFullOrg(int grade) {
        List<SysCollege> collegeList = collegeDao.get();
        //添加之间的关联
        for (SysCollege c : collegeList
        ) {
            if (c.getCollegeStatus().equals("1")) {
                c.setDisabled(true);
            }
            //获取院系下的专业
            List<SysMajor> majors = majorDao.getByPid(c.getCollegeId());
            for (SysMajor m : majors
            ) {
                if (m.getMajorStatus().equals("1")) {
                    m.setDisabled(true);
                }
                //获取专业下的班级
                List<SysClass> classes = classDao.getByPid(m.getMajorId(), grade);
                for (SysClass cls : classes
                ) {
                    if (cls.getClassStatus().equals("1")) {
                        cls.setDisabled(true);
                    }
                }
                m.setChildren(classes);
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
        String type = String.valueOf(params.get(("type")));
        Map<String, String> info;
        if (type.equals("usr")) {
            info = sysDao.getPwd(true, id);
            if (!ObjectUtils.isEmpty(info)) {
                String salt = info.get("user_salt");
                if (ShiroUtil.pwd2MD5(oldPwd, salt, hash).equals(info.get("user_pwd"))) {
                    String pwd = ShiroUtil.pwd2MD5(newPwd, salt, hash);
                    return sysDao.changePwd(true, id, pwd);
                } else {
                    return 2;
                }
            } else {
                return 0;
            }
        } else {
            info = sysDao.getPwd(false, id);
            if (!ObjectUtils.isEmpty(info)) {
                String salt = info.get("student_salt");
                if (ShiroUtil.pwd2MD5(oldPwd, salt, hash).equals(info.get("student_pwd"))) {
                    String pwd = ShiroUtil.pwd2MD5(newPwd, salt, hash);
                    return sysDao.changePwd(false, id, pwd);
                } else {
                    return 2;
                }
            } else {
                return 0;
            }
        }
    }

    @Override
    public List<SysPerms> getMenus(String type, Long id) {
        List<SysPerms> permsList = new ArrayList<>();
        List<SysPerms> perms;
        //选择查询类型
        if (type.equals("usr")) {
            perms = permsDao.getUserMenus(id);
        } else {
            perms = permsDao.getStudentMenus(id);
        }
        for (SysPerms p : perms
        ) {
            if (p.getPermsPid() == 0) {
                permsList.add(p);
            }
        }
        for (SysPerms m : permsList
        ) {
            m.setChildren(getChildren(m.getPermsId(), perms));
        }
        return permsList;
    }

    private List<SysPerms> getChildren(Long pid, List<SysPerms> list) {
        List<SysPerms> children = new ArrayList<>();
        for (SysPerms p : list
        ) {
            if (p.getPermsPid().equals(pid)) {
                children.add(p);
            }
        }

        for (SysPerms m : children
        ) {
            m.setChildren(getChildren(m.getPermsId(), list));
        }
        return children;
    }

    private ResultBody studentLogin(String code, String pwd) {
        SysStudent loginInfo = sysDao.getStudentLoginInfo(code);
        if (loginInfo != null) {
            String currentPwd = loginInfo.getStudentPwd();
            String salt = loginInfo.getStudentSalt();
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(pwd, salt, hash))) return new ResultBody(2, "密码不正确", "error");
            if (loginInfo.getStudentStatus().equals("1")) return new ResultBody(3, "禁止登录", "error");
        } else {
            return new ResultBody(1, "账号不存在", "error");
        }
        return new ResultBody(0, JWTUtil.createToken(loginInfo.getStudentId(), loginInfo.getStudentName(), loginInfo.getStudentCode(), "student"));
    }

    private ResultBody usrLogin(String account, String pwd) {
        SysUser loginInfo = sysDao.getUsrLoginInfo(account);
        if (loginInfo != null) {
            String currentPwd = loginInfo.getUserPwd();
            String salt = loginInfo.getUserSalt();
            if (!currentPwd.equals(ShiroUtil.pwd2MD5(pwd, salt, hash))) return new ResultBody(2, "密码不正确", "error");
            if (loginInfo.getUserStatus().equals("1")) return new ResultBody(3, "禁止登录", "error");
        } else {
            return new ResultBody(1, "账号不存在", "error");
        }
        return new ResultBody(0, JWTUtil.createToken(loginInfo.getUserId(), loginInfo.getUserName(), loginInfo.getUserCode(), "usr"));
    }
}
