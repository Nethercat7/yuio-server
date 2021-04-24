package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysWorkDao;
import com.zfy.yuio.entity.SysWork;
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
        params.setWorkId(snowflakeIdGeneratorUtil.getId());
        if (ObjectUtils.isEmpty(params.getWorkPid())) {
            params.setWorkPid("0");
            params.setWorkLevel(0);
        }else{
            SysWork c=workDao.getById(params.getWorkPid());
            params.setWorkLevel(c.getWorkLevel()+1);
        }
        return workDao.add(params);
    }

    @Override
    public List<SysWork> get() {
        List<SysWork> workList = workDao.get();
        List<SysWork> works = new ArrayList<>();
        for (SysWork c : workList
        ) {
            if (c.getWorkPid().equals("0")) works.add(c);
        }
        for (SysWork c : works
        ) {
            c.setChildren(getChildren(c.getWorkId(), workList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return works;
    }

    @Override
    public int del(String id) {
        return workDao.del(id);
    }

    @Override
    public int upd(SysWork params) {
        if (ObjectUtils.isEmpty(params.getWorkPid())||params.getWorkPid().equals("0")) {
            params.setWorkLevel(0);
        }else{
            SysWork c=workDao.getById(params.getWorkPid());
            params.setWorkLevel(c.getWorkLevel()+1);
        }
        return workDao.upd(params);
    }

    @Override
    public void initial(SysWork params) {
        params.setWorkId(snowflakeIdGeneratorUtil.getId());
        params.setWorkStatus("0");
        if (params.getWorkPid() == null) {
            params.setWorkPid("0");
            params.setWorkLevel(0);
        }
        workDao.add(params);
        if (params.getChildren() != null) {
            setChildren(params.getChildren(), params.getWorkId(), params.getWorkLevel());
        }
    }

    private void setChildren(List<SysWork> children, String pid, int level) {
        for (SysWork c : children
        ) {
            c.setWorkId(snowflakeIdGeneratorUtil.getId());
            c.setWorkStatus("0");
            c.setWorkPid(pid);
            c.setWorkLevel(level + 1);
            workDao.add(c);
            if (c.getChildren() != null) {
                setChildren(c.getChildren(), c.getWorkId(), c.getWorkLevel());
            }
        }
    }

    private List<SysWork> getChildren(String pid, List<SysWork> workList) {
        List<SysWork> children = new ArrayList<>();
        for (SysWork c : workList
        ) {
            if (c.getWorkPid().equals(pid)) children.add(c);

        }
        for (SysWork c : children
        ) {
            c.setChildren(getChildren(c.getWorkId(), workList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
