package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.entity.SysClass;
import com.zfy.yuio.service.ClsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClsServiceImpl implements ClsService {
    @Autowired
    private ClsDao classDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(2, 0);

    @Override
    public int add(SysClass params) {
        String collegeId = params.getContainer().get(0);
        String majorId = params.getContainer().get(1);
        //设置班级所属的学院和专业ID
        params.setClassCollegeId(collegeId);
        params.setClassMajorId(majorId);
        //设置班级ID
        params.setClassId(snowflakeIdGeneratorUtil.getId());
        return classDao.add(params);
    }

    @Override
    public List<SysClass> get() {
        List<SysClass> cls=classDao.get();
        //设置班级所属学院和专业的名称
        for (SysClass c:cls
             ) {
            c.setClassCollegeName(collegeDao.getNameById(c.getClassCollegeId()));
            c.setClassMajorName(majorDao.getNameById(c.getClassMajorId()));
            List<String> container=new ArrayList<>();
            container.add(c.getClassCollegeId());
            container.add(c.getClassMajorId());
            c.setContainer(container);
        }
        return cls;
    }

    @Override
    public int del(String id) {
        return classDao.del(id);
    }

    @Override
    public int upd(SysClass params) {
        String collegeId = params.getContainer().get(0);
        String majorId = params.getContainer().get(1);
        //设置班级所属的学院和专业ID
        params.setClassCollegeId(collegeId);
        params.setClassMajorId(majorId);
        return classDao.upd(params);
    }
}
