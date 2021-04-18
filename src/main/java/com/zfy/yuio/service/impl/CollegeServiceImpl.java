package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.entity.College;
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
    public int add(College college) {
        college.setCollegeId(snowflakeIdGeneratorUtil.getId());
        return collegeDao.add(college);
    }

    @Override
    public List<College> get() {
        return collegeDao.get();
    }

    @Override
    public int del(String id) {
        return collegeDao.del(id);
    }

    @Override
    public int upd(College college) {
        return collegeDao.upd(college);
    }
}
