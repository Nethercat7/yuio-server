package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.entity.SysMajor;
import com.zfy.yuio.service.MajorService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
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

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(1, 0);

    @Override
    public int add(SysMajor params) {
        params.setMajorId(snowflakeIdGeneratorUtil.getId());
        return majorDao.add(params);
    }

    @Override
    public List<SysMajor> get() {
        return majorDao.get();
    }

    @Override
    public int del(String id) {
        return majorDao.del(id);
    }

    @Override
    public int upd(SysMajor params) {
        return majorDao.upd(params);
    }
}
