package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysCollegeDao;
import com.zfy.yuio.dao.SysMajorDao;
import com.zfy.yuio.entity.excel.ExcelMajor;
import com.zfy.yuio.entity.system.SysMajor;
import com.zfy.yuio.service.SysMajorService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Description:专业管理
 * @Author:Nethercat7
 * @CreateDate:2021/4/8 19:58
 */
@Service
public class SysMajorServiceImpl implements SysMajorService {
    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysCollegeDao collegeDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(1, 0);

    @Override
    public int add(SysMajor params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setMajorId(snowflakeIdGeneratorUtil.nextId());
            majorDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysMajor> get() {
        return majorDao.get();
    }

    @Override
    public int del(Long id) {
        return majorDao.del(id);
    }

    @Override
    public int upd(SysMajor params) {
        int status = validator(params, 1);
        if(status==0){
            majorDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysMajor> getByKeyword(String keyword) {
        return majorDao.getByKeyword(keyword);
    }

    @Override
    public void addFromExcel(List<ExcelMajor> params) {
        for (ExcelMajor m : params
        ) {
            m.setMajorId(snowflakeIdGeneratorUtil.nextId());
            m.setMajorCollegeId(collegeDao.getIdByName(m.getCollegeName()));
        }
        majorDao.addFromExcel(params);
    }

    public int validator(SysMajor params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(majorDao.getIdByName(params.getMajorName()))) return 1;
        } else {
            SysMajor data = majorDao.getById(params.getMajorId());
            if (!data.getMajorName().equals(params.getMajorName())) {
                if (!ObjectUtils.isEmpty(majorDao.getIdByName(params.getMajorName()))) return 1;
            }
        }
        return 0;
    }
}
