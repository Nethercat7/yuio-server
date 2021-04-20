package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.WorkDao;
import com.zfy.yuio.entity.Work;
import com.zfy.yuio.service.WorkService;
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
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(10, 0);

    @Override
    public int add(Work work) {
        work.setWorkId(snowflakeIdGeneratorUtil.getId());
        if (ObjectUtils.isEmpty(work.getWorkPid())) {
            work.setWorkPid("0");
            work.setWorkLevel(0);
        }else{
            Work c=workDao.getById(work.getWorkPid());
            work.setWorkLevel(c.getWorkLevel()+1);
        }
        return workDao.add(work);
    }

    @Override
    public List<Work> get() {
        List<Work> workList = workDao.get();
        List<Work> works = new ArrayList<>();
        for (Work c : workList
        ) {
            if (c.getWorkPid().equals("0")) works.add(c);
        }
        for (Work c : works
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
    public int upd(Work work) {
        if (ObjectUtils.isEmpty(work.getWorkPid())) {
            work.setWorkPid("0");
            work.setWorkLevel(0);
        }else{
            Work c=workDao.getById(work.getWorkPid());
            work.setWorkLevel(c.getWorkLevel()+1);
        }
        return workDao.upd(work);
    }

    @Override
    public void initial(Work work) {
        work.setWorkId(snowflakeIdGeneratorUtil.getId());
        work.setWorkStatus(0);
        if (work.getWorkPid() == null) {
            work.setWorkPid("0");
            work.setWorkLevel(0);
        }
        workDao.add(work);
        if (work.getChildren() != null) {
            setChildren(work.getChildren(), work.getWorkId(), work.getWorkLevel());
        }
    }

    private void setChildren(List<Work> children, String pid, int level) {
        for (Work c : children
        ) {
            c.setWorkId(snowflakeIdGeneratorUtil.getId());
            c.setWorkStatus(0);
            c.setWorkPid(pid);
            c.setWorkLevel(level + 1);
            workDao.add(c);
            if (c.getChildren() != null) {
                setChildren(c.getChildren(), c.getWorkId(), c.getWorkLevel());
            }
        }
    }

    private List<Work> getChildren(String pid, List<Work> workList) {
        List<Work> children = new ArrayList<>();
        for (Work c : workList
        ) {
            if (c.getWorkPid().equals(pid)) children.add(c);

        }
        for (Work c : children
        ) {
            c.setChildren(getChildren(c.getWorkId(), workList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
