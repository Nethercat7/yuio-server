package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.entity.Major;
import com.zfy.yuio.service.MajorService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:58
*/
@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    private MajorDao majorDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(1,0);

    @Override
    public int add(Major major) {
        major.setMajorId(snowflakeIdGeneratorUntil.getId());
        return majorDao.add(major);
    }

    @Override
    public List<Major> get() {
        return majorDao.get();
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
