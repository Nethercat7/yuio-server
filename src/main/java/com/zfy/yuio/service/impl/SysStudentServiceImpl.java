package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.dao.SysPermsDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.SysUserDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:学生管理模块
 * @Author:赵富源
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

    @Autowired
    private SysClassDao classDao;

    @Autowired
    private SysPermsDao permsDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(3, 0);

    @Override
    public int add(SysStudent params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setStudentId(snowflakeIdGeneratorUtil.nextId());
            //设置随机盐
            params.setStudentSalt(ShiroUtil.getSalt(SALT));
            //默认密码
            params.setStudentPwd(ShiroUtil.pwd2MD5("123456", params.getStudentSalt(), HASH));
            studentDao.add(params);
            studentDao.addRole(params.getStudentId(), 506870876013088768L);
            studentDao.addTutor(params.getStudentTutorsCode(), params.getStudentCode());
        }
        return status;
    }

    @Override
    public List<SysStudent> get(QueryParams params) {
        List<SysStudent> students = studentDao.get(params);
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getStudentEmplInfo())) {
                student.setStudentEmplWrite("0");
            } else {
                student.setStudentEmplWrite("1");
            }
        }
        List<String> perms = permsDao.getUserPerms(params.getUserCode());
        //如果没有查看所有学生的权限，那么只能查看自己所带的学生。
        if (!perms.contains("system:student:getAll")) {
            students = students.stream().filter(s -> s.getStudentTutorsCode().contains(params.getUserCode())).collect(Collectors.toList());
        }
        return students;
    }


    @Override
    public int del(Long id) {
        return studentDao.del(id);
    }

    @Override
    public int upd(SysStudent params) {
        int status = validator(params, 1);
        if (status == 0) {
            studentDao.upd(params);
            //删除学生与导师的关系
            studentDao.delStudentTutors(params.getStudentCode());
            if (!ObjectUtils.isEmpty(params.getStudentTutorsCode())) {
                //添加学生与导师的关系
                studentDao.addTutor(params.getStudentTutorsCode(), params.getStudentCode());
            }
        }
        return status;
    }

    @Override
    public SysStudent getById(Long id) {
        SysStudent student = studentDao.getById(id);
        if (!ObjectUtils.isEmpty(student)) {
            if (ObjectUtils.isEmpty(student.getStudentEmplInfo())) {
                student.setStudentEmplWrite("0");
            } else {
                student.setStudentEmplWrite("1");
            }
        }
        return student;
    }

    @Override
    public int updProfile(SysStudent params) {
        int status = validator(params, 1);
        if (status == 0) {
            studentDao.updProfile(params);
            //删除学生与导师的关系
            studentDao.delStudentTutors(params.getStudentCode());
            if (!ObjectUtils.isEmpty(params.getStudentTutorsCode())) {
                //添加学生与导师的关系
                studentDao.addTutor(params.getStudentTutorsCode(), params.getStudentCode());
            }
        }
        return status;
    }

    @Override
    public void addFromExcel(List<SysStudent> params) {
        //Add status and class id for students
        for (SysStudent s : params
        ) {
            s.setStudentId(snowflakeIdGeneratorUtil.nextId());
            s.setStudentClassId(classDao.getIdByName(s.getStudentClass().getClassName()));
            //Set default password
            s.setStudentSalt(ShiroUtil.getSalt(7));
            s.setStudentPwd(ShiroUtil.pwd2MD5("123456", s.getStudentSalt(), 1739));
        }
        studentDao.addFromExcel(params);
        //Add student role
        for (SysStudent s : params
        ) {
            studentDao.addRole(s.getStudentId(), 506870876013088768L);
        }
    }

    @Override
    public void output2Excel(QueryParams params, HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "Student_Data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try {
            List<SysStudent> students = studentDao.get(params);
            //数据转换
            for (SysStudent s : students
            ) {
                if (ObjectUtils.isEmpty(s.getStudentEmplInfo())) {
                    s.setStudentEmplWrite("0");
                } else {
                    s.setStudentEmplWrite("1");
                    s.setStudentEmplConpany(s.getStudentEmplInfo().getEmplCompany());
                    s.setStudentEmplProtocol(s.getStudentEmplInfo().getEmplProtocol());
                    s.setStudentEmplStatus(s.getStudentEmplInfo().getEmplStatus());
                }
            }
            EasyExcel.write(response.getOutputStream(), SysStudent.class).sheet("sheet1").doWrite(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int validator(SysStudent params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(studentDao.verify(params.getStudentCode()))) return 1;
            if (!ObjectUtils.isEmpty(params.getStudentPhone())) {
                Long sPhone = studentDao.verify(params.getStudentPhone());
                Long uPhone = userDao.verify(params.getStudentPhone());
                if (!ObjectUtils.isEmpty(sPhone) || !ObjectUtils.isEmpty(uPhone)) return 2;
            }
        } else {
            SysStudent student = studentDao.getById(params.getStudentId());
            if (!student.getStudentCode().equals(params.getStudentCode())) {
                if (!ObjectUtils.isEmpty(studentDao.verify(params.getStudentCode()))) return 1;
            } else if (!ObjectUtils.isEmpty(params.getStudentPhone())) {
                if (!ObjectUtils.isEmpty(student.getStudentPhone())) {
                    if (!student.getStudentPhone().equals(params.getStudentPhone())) {
                        Long sPhone = studentDao.verify(params.getStudentPhone());
                        Long uPhone = userDao.verify(params.getStudentPhone());
                        if (!ObjectUtils.isEmpty(sPhone) || !ObjectUtils.isEmpty(uPhone)) return 2;
                    }
                } else {
                    Long sPhone = studentDao.verify(params.getStudentPhone());
                    Long uPhone = userDao.verify(params.getStudentPhone());
                    if (!ObjectUtils.isEmpty(sPhone) || !ObjectUtils.isEmpty(uPhone)) return 2;
                }
            }
        }
        return 0;
    }
}
