package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.*;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.JWTUtil;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
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
    private SysClsDao classDao;

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
    public ResultBody login(Map<String, Object> map) {
        boolean isUser = Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key = String.valueOf(map.get("key"));
        String pwd = String.valueOf(map.get("pwd"));
        if (isUser) return usrLogin(key, pwd);
        return studentLogin(key, pwd);
    }

    @Override
    public int saveEmploymentStatus(StatsEmplInfo eStatus) {
        eStatus.setEmplId(snowflakeIdGeneratorUtil.getId());
        SysStudent student = studentDao.getById(eStatus.getEmplStudentId());
        //如果是已存在的就进行更新
        if (!ObjectUtils.isEmpty(student)) {
            return sysDao.updEStatus(eStatus);
        }
        eStatus.setEmplClassId(student.getStudentClassId());
        eStatus.setEmplMajorId(student.getStudentMajorId());
        eStatus.setEmplCollegeId(student.getStudentCollegeId());
        eStatus.setEmplGrade(student.getStudentGrade());
        return sysDao.saveEmploymentStatus(eStatus);
    }

    @Override
    public StatsEmplInfo getEStatusById(String id) {
        return sysDao.getEStatusById(id);
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
    public List<Map<String, Object>> getGrade() {
        List<Integer> grade = sysDao.getGrade();
        List<Map<String, Object>> gradeList = new ArrayList<>();
        for (Integer g : grade
        ) {
            Map<String, Object> map = new HashMap<>();
            map.put("label", g + "级");
            map.put("value", g);
            gradeList.add(map);
        }
        return gradeList;
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
