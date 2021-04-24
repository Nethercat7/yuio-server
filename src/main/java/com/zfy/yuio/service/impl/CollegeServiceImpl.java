package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.service.CollegeService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:院系管理
 * @Author:Nethercat7
 * @CreateDate:2021/4/8 19:58
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeDao collegeDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(0, 0);

    @Override
    public int add(SysCollege params) {
        params.setCollegeId(snowflakeIdGeneratorUtil.getId());
        return collegeDao.add(params);
    }

    @Override
    public List<SysCollege> get() {
        return collegeDao.get();
    }

    @Override
    public int del(String id) {
        return collegeDao.del(id);
    }

    @Override
    public int upd(SysCollege params) {
        return collegeDao.upd(params);
    }
}
