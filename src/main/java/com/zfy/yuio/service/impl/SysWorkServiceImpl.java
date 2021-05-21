package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysWorkDao;
import com.zfy.yuio.entity.system.SysWork;
import com.zfy.yuio.service.SysWorkService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:城市管理
 * @Author:赵富源
 * @CreateDate:2021/4/20 18:47
 */
@Service
public class SysWorkServiceImpl implements SysWorkService {
    @Autowired
    private SysWorkDao workDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(10, 0);

    @Override
    public int add(SysWork params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setWorkId(snowflakeIdGeneratorUtil.nextId());
            if (ObjectUtils.isEmpty(params.getWorkPid())) {
                params.setWorkPid(0L);
                params.setWorkLevel(0);
            } else {
                SysWork c = workDao.getById(params.getWorkPid());
                params.setWorkLevel(c.getWorkLevel() + 1);
            }
            workDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysWork> get() {
        List<SysWork> workList = workDao.get();
        List<SysWork> works = new ArrayList<>();
        for (SysWork c : workList
        ) {
            if(c.getWorkStatus().equals("1")){
                c.setDisabled(true);
            }
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
        int status = validator(params, 1);
        if (status == 0) {
            if (ObjectUtils.isEmpty(params.getWorkPid())) {
                params.setWorkPid(0L);
                params.setWorkLevel(0);
            } else {
                SysWork c = workDao.getById(params.getWorkPid());
                if (!ObjectUtils.isEmpty(c)) params.setWorkLevel(c.getWorkLevel() + 1);
            }
            workDao.upd(params);
        }
        return status;
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
    public void addFromExcel(List<SysWork> params) {
        workDao.addFromExcel(params);
    }

    @Override
    public void output2Excel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "work_data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try{
            EasyExcel.write(response.getOutputStream(), SysWork.class).sheet("Sheet1").doWrite(getWithoutConvert());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private int validator(SysWork params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(workDao.verify(params.getWorkName()))) return 1;
        } else {
            SysWork data = workDao.getById(params.getWorkId());
            if (!data.getWorkName().equals(params.getWorkName())) {
                if (!ObjectUtils.isEmpty(workDao.verify(params.getWorkName()))) return 1;
            }
        }
        return 0;
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
