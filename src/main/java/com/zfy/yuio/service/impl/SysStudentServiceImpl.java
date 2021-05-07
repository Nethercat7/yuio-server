package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;

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

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(3, 0);

    @Override
    public int add(SysStudent params) {
        params.setStudentId(snowflakeIdGeneratorUtil.nextId());
        //设置随机盐
        params.setStudentSalt(ShiroUtil.getSalt(SALT));
        //默认密码
        params.setStudentPwd(ShiroUtil.pwd2MD5("123456", params.getStudentSalt(), HASH));
        int status = studentDao.add(params);
        if(status==1) studentDao.addRole(params.getStudentId(),506870876013088768L);
        return status;
    }

    @Override
    public List<SysStudent> get(QueryParams params) {
        List<SysStudent> students=studentDao.get(params);
        for (SysStudent student:students
             ) {
            if(ObjectUtils.isEmpty(student.getEmplStatus())){
                student.setEmplWrite("0");
            }else{
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
        return studentDao.getById(id);
    }

    @Override
    public int updProfile(SysStudent params) {
        return studentDao.updProfile(params);
    }

    @Override
    public int changePwd(Map<String, Object> params) {
        Long id = Long.valueOf(String.valueOf(params.get("id")));
        String oldPwd = String.valueOf(params.get("oldPwd"));
        String newPwd = String.valueOf(params.get("newPwd"));
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
