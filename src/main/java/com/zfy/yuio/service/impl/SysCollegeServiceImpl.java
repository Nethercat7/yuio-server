package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysCollegeDao;
import com.zfy.yuio.entity.excel.ExcelCollege;
import com.zfy.yuio.entity.system.SysCollege;
import com.zfy.yuio.service.SysCollegeService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description:院系管理
 * @Author:赵富源
 * @CreateDate:2021/4/8 19:58
 */
@Service
public class SysCollegeServiceImpl implements SysCollegeService {
    @Autowired
    private SysCollegeDao collegeDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(0, 0);

    @Override
    public int add(SysCollege params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setCollegeId(snowflakeIdGeneratorUtil.nextId());
            collegeDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysCollege> get() {
        return collegeDao.get();
    }

    @Override
    public int del(Long id) {
        return collegeDao.del(id);
    }

    @Override
    public int upd(SysCollege params) {
        int status = validator(params, 1);
        if (status == 0) {
            collegeDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysCollege> getByKeyword(String keyword) {
        return collegeDao.getByKeyword(keyword);
    }

    @Override
    public void addFromExcel(List<ExcelCollege> params) {
        for (ExcelCollege c : params
        ) {
            c.setCollegeId(snowflakeIdGeneratorUtil.nextId());
        }
        collegeDao.addFromExcel(params);
    }

    public int validator(SysCollege params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(collegeDao.getIdByName(params.getCollegeName()))) return 1;
        } else {
            SysCollege data = collegeDao.getById(params.getCollegeId());
            if (!data.getCollegeName().equals(params.getCollegeName())) {
                if (!ObjectUtils.isEmpty(collegeDao.getIdByName(params.getCollegeName()))) return 1;
            }
        }
        return 0;
    }
}
