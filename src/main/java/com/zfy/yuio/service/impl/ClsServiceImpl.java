package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.entity.Cls;
import com.zfy.yuio.service.ClsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClsServiceImpl implements ClsService {
    @Autowired
    private ClsDao clsDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(2, 0);

    @Override
    public int add(Cls cls) {
        String collegeId = cls.getContainer().get(0);
        String majorId = cls.getContainer().get(1);
        //设置班级所属的学院和专业ID
        cls.setClsCollegeId(collegeId);
        cls.setClsMajorId(majorId);
        //设置班级ID
        cls.setClsId(snowflakeIdGeneratorUtil.getId());
        return clsDao.add(cls);
    }

    @Override
    public List<Cls> get() {
        List<Cls> cls=clsDao.get();
        //设置班级所属学院和专业的名称
        for (Cls c:cls
             ) {
            c.setClsCollegeName(collegeDao.getNameById(c.getClsCollegeId()));
            c.setClsMajorName(majorDao.getNameById(c.getClsMajorId()));
            List<String> container=new ArrayList<>();
            container.add(c.getClsCollegeId());
            container.add(c.getClsMajorId());
            c.setContainer(container);
        }
        return cls;
    }

    @Override
    public int del(String id) {
        return clsDao.del(id);
    }

    @Override
    public int upd(Cls cls) {
        String collegeId = cls.getContainer().get(0);
        String majorId = cls.getContainer().get(1);
        //设置班级所属的学院和专业ID
        cls.setClsCollegeId(collegeId);
        cls.setClsMajorId(majorId);
        return clsDao.upd(cls);
    }
}
