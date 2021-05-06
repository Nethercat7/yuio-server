package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.entity.SysClass;
import com.zfy.yuio.service.SysClassService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysClassServiceImpl implements SysClassService {
    @Autowired
    private SysClassDao classDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(2, 0);

    @Override
    public int add(SysClass params) {
        //设置班级ID
        params.setClassId(snowflakeIdGeneratorUtil.nextId());
        return classDao.add(params);
    }

    @Override
    public List<SysClass> get() {
        return classDao.get();
    }

    @Override
    public int del(Long id) {
        return classDao.del(id);
    }

    @Override
    public int upd(SysClass params) {
        return classDao.upd(params);
    }

    @Override
    public List<SysClass> getByKeyword(String keyword) {
        return classDao.getByKeyword(keyword);
    }
}
