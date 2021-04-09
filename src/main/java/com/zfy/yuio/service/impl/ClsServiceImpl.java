package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.entity.Cls;
import com.zfy.yuio.service.ClsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClsServiceImpl implements ClsService {
    @Autowired
    private ClsDao clsDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(2,0);

    @Override
    public int add(Cls cls) {
        String collegeId=cls.getContainer().get(0);
        String majorId=cls.getContainer().get(1);
        //设置班级所属的学院和专业ID
        cls.setClsCollegeId(collegeId);
        cls.setClsMajorId(majorId);
        //设置班级ID
        cls.setClsId(snowflakeIdGeneratorUntil.getId());
        return clsDao.add(cls);
    }
}
