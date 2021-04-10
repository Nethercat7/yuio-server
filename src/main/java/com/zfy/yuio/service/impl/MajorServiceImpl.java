package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.entity.Major;
import com.zfy.yuio.service.MajorService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:专业管理
 * @Author:Nethercat7
 * @CreateDate:2021/4/8 19:58
 */
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private ClsDao clsDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil = new SnowflakeIdGeneratorUntil(1, 0);

    @Override
    public int add(Major major) {
        major.setMajorId(snowflakeIdGeneratorUntil.getId());
        return majorDao.add(major);
    }

    @Override
    public List<Major> get() {
        List<Major> majors = majorDao.get();
        for (Major m : majors
        ) {
            m.setMajorCollegeName(collegeDao.getById(m.getMajorCollegeId()).getCollegeName());
            m.setChildren(clsDao.getByPid(m.getMajorId()));
        }
        return majors;
    }

    @Override
    public int del(String id) {
        return majorDao.del(id);
    }

    @Override
    public int upd(Major major) {
        return majorDao.upd(major);
    }
}
