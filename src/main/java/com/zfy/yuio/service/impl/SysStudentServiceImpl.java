package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.dao.SysDictDataDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.excel.ExcelStudent;
import com.zfy.yuio.entity.system.SysDictData;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    private SysClassDao classDao;

    @Autowired
    private SysDictDataDao dictDataDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(3, 0);

    @Override
    public int add(SysStudent params) {
        params.setStudentId(snowflakeIdGeneratorUtil.nextId());
        //设置随机盐
        params.setStudentSalt(ShiroUtil.getSalt(SALT));
        //默认密码
        params.setStudentPwd(ShiroUtil.pwd2MD5("123456", params.getStudentSalt(), HASH));
        int status = studentDao.add(params);
        if (status == 1) studentDao.addRole(params.getStudentId(), 506870876013088768L);
        return status;
    }

    @Override
    public List<SysStudent> get(QueryParams params) {
        List<SysStudent> students = studentDao.get(params);
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getEmplStatus())) {
                student.setEmplWrite("0");
            } else {
                student.setEmplWrite("1");
            }
        }
        return students;
    }


    @Override
    public int del(Long id) {
        return studentDao.del(id);
    }

    @Override
    public int upd(SysStudent params) {
        return studentDao.upd(params);
    }

    @Override
    public SysStudent getById(Long id) {
        SysStudent student = studentDao.getById(id);
        if (ObjectUtils.isEmpty(student.getEmplStatus())) {
            student.setEmplWrite("0");
        } else {
            student.setEmplWrite("1");
        }
        return student;
    }

    @Override
    public int updProfile(SysStudent params) {
        return studentDao.updProfile(params);
    }

    @Override
    public void addFromExcel(List<ExcelStudent> params) {
        //Get data dict
        List<SysDictData> dictData = dictDataDao.get("sys_user_gender");

        //Add status and class id for students
        for (ExcelStudent s : params
        ) {
            s.setStudentId(snowflakeIdGeneratorUtil.nextId());
            s.setStudentStatus("0");
            s.setStudentClassId(classDao.getIdByName(s.getClassName()));

            //Set default password
            s.setStudentSalt(ShiroUtil.getSalt(7));
            s.setStudentPwd(ShiroUtil.pwd2MD5("123456",s.getStudentSalt(),1739));

            //Convert gender
            for (SysDictData d : dictData
            ) {
                if (s.getStudentGender().equals(d.getDictLabel())) {
                    s.setStudentGender(d.getDictValue());
                }
            }
        }
        studentDao.addFromExcel(params);
        //Add student role
        for (ExcelStudent s : params
        ) {
            studentDao.addRole(s.getStudentId(), 506870876013088768L);
        }
    }
}
