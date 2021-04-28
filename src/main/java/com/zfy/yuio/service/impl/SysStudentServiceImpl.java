package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
@Service
public class SysStudentServiceImpl implements SysStudentService {
    //随机盐的个数
    private static final int SALT = 7;
    //散列次数
    private static final int HASH = 1739;

    @Autowired
    private SysStudentDao studentDao;

    @Autowired
    private SysUserDao userDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(3, 0);

    @Override
    public int add(SysStudent params) {
        params.setStudentId(snowflakeIdGeneratorUtil.getId());
        //为当前学生设置院系、专业和班级
        setBaseInfo(params);
        //设置随机盐
        params.setStudentSalt(ShiroUtil.getSalt(SALT));
        //默认密码
        params.setStudentPwd(ShiroUtil.pwd2MD5("123456", params.getStudentSalt(), HASH));
        //设置角色为学生,字符串的ID为数据库初始角色“学生”的ID
        userDao.addRole(snowflakeIdGeneratorUtil.getId(),params.getStudentId(),"506870876013088768");
        return studentDao.add(params);
    }

    @Override
    public List<SysStudent> get() {
        List<SysStudent> students = studentDao.get(0);
        for (SysStudent s : students
        ) {
            List<String> container = new ArrayList<>();
            container.add(s.getStudentCollegeId());
            container.add(s.getStudentMajorId());
            container.add(s.getStudentClassId());
            s.setContainer(container);
        }
        return students;
    }

    @Override
    public SysStudent getByCode(String code) {
        return studentDao.getByCode(code);
    }

    @Override
    public int del(String id) {
        return studentDao.del(id);
    }

    @Override
    public int upd(SysStudent params) {
        //为当前学生设置院系、专业和班级
        setBaseInfo(params);
        return studentDao.upd(params);
    }

    @Override
    public List<SysStudent> getWithEStatusInfo(QueryParams queryParams) {
        List<SysStudent> students = studentDao.getWithEStatusInfo(queryParams);
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getEmplId())) {
                student.setWrite("0");
            } else {
                student.setWrite("1");
            }
            //设置院系、专业和班级信息
            List<String> container = new ArrayList<>();
            container.add(student.getStudentCollegeId());
            container.add(student.getStudentMajorId());
            container.add(student.getStudentClassId());
            student.setContainer(container);
        }
        return students;
    }

    private void setBaseInfo(SysStudent params) {
        String collegeId = params.getContainer().get(0);
        String majorId = params.getContainer().get(1);
        String classId = params.getContainer().get(2);
        params.setStudentCollegeId(collegeId);
        params.setStudentMajorId(majorId);
        params.setStudentClassId(classId);
    }
}
