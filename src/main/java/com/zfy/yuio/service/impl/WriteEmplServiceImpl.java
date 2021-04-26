package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.WriteEmplDao;
import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.WriteEmplService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:就业情况填写
 * @Author:Nethercat7
 * @CreateDate:2021/4/26 23:47
 */
@Service
public class WriteEmplServiceImpl implements WriteEmplService {
    @Autowired
    private WriteEmplDao emplDao;

    @Autowired
    private SysStudentDao studentDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(13, 0);

    @Override
    public int add(StatsEmplInfo params) {
        params.setEmplId(snowflakeIdGeneratorUtil.getId());
        //获取院系等信息
        SysStudent student = studentDao.getById(params.getEmplStudentId());
        params.setEmplCollegeId(student.getStudentCollegeId());
        params.setEmplMajorId(student.getStudentMajorId());
        params.setEmplClassId(student.getStudentClassId());
        params.setEmplGrade(student.getStudentGrade());
        return emplDao.add(params);
    }

    @Override
    public StatsEmplInfo get(String id) {
        return emplDao.get(id);
    }

    @Override
    public int upd(StatsEmplInfo params) {
        return emplDao.upd(params);
    }
}
