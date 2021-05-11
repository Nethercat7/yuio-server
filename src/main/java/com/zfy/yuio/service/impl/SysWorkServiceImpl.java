package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysWorkDao;
import com.zfy.yuio.entity.excel.ExcelWork;
import com.zfy.yuio.entity.system.SysWork;
import com.zfy.yuio.service.SysWorkService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:城市管理
 * @Author:Nethercat7
 * @CreateDate:2021/4/20 18:47
 */
@Service
public class SysWorkServiceImpl implements SysWorkService {
    @Autowired
    private SysWorkDao workDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(10, 0);

    @Override
    public int add(SysWork params) {
        params.setWorkId(snowflakeIdGeneratorUtil.nextId());
        if (ObjectUtils.isEmpty(params.getWorkPid())) {
            params.setWorkPid(0L);
            params.setWorkLevel(0);
        } else {
            SysWork c = workDao.getById(params.getWorkPid());
            params.setWorkLevel(c.getWorkLevel() + 1);
        }
        return workDao.add(params);
    }

    @Override
    public List<SysWork> get() {
        List<SysWork> workList = workDao.get();
        List<SysWork> works = new ArrayList<>();
        for (SysWork c : workList
        ) {
            if (c.getWorkPid() == 0) works.add(c);
        }
        for (SysWork c : works
        ) {
            c.setChildren(getChildren(c.getWorkId(), workList));
            if (ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return works;
    }

    @Override
    public int del(Long id) {
        return workDao.del(id);
    }

    @Override
    public int upd(SysWork params) {
        if (ObjectUtils.isEmpty(params.getWorkPid())) {
            params.setWorkPid(0L);
            params.setWorkLevel(0);
        } else {
            SysWork c = workDao.getById(params.getWorkPid());
            if (!ObjectUtils.isEmpty(c)) params.setWorkLevel(c.getWorkLevel() + 1);
        }
        return workDao.upd(params);
    }

    @Override
    public List<SysWork> getByKeyword(String keyword) {
        return workDao.getByKeyword(keyword);
    }

    @Override
    public List<SysWork> getWithoutConvert() {
        return workDao.get();
    }

    @Override
    public void addFromExcel(List<ExcelWork> params) {
        workDao.addFromExcel(params);
    }

    private List<SysWork> getChildren(Long pid, List<SysWork> workList) {
        List<SysWork> children = new ArrayList<>();
        for (SysWork c : workList
        ) {
            if (c.getWorkPid().equals(pid)) children.add(c);

        }
        for (SysWork c : children
        ) {
            c.setChildren(getChildren(c.getWorkId(), workList));
            if (ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
