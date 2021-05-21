package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.dao.SysMajorDao;
import com.zfy.yuio.entity.system.SysClass;
import com.zfy.yuio.service.SysClassService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class SysClassServiceImpl implements SysClassService {
    @Autowired
    private SysClassDao classDao;

    @Autowired
    private SysMajorDao majorDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(2, 0);

    @Override
    public int add(SysClass params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setClassId(snowflakeIdGeneratorUtil.nextId());
            classDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysClass> get() {
        List<SysClass> classes = classDao.get();
        for (SysClass c : classes
        ) {
            if (c.getClassStatus().equals("1")) {
                c.setDisabled(true);
            }
        }
        return classes;
    }

    @Override
    public int del(Long id) {
        return classDao.del(id);
    }

    @Override
    public int upd(SysClass params) {
        int status = validator(params, 1);
        if (status == 0) {
            classDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysClass> getByKeyword(String keyword) {
        return classDao.getByKeyword(keyword);
    }

    @Override
    public void addFromExcel(List<SysClass> params) {
        for (SysClass c : params
        ) {
            c.setClassId(snowflakeIdGeneratorUtil.nextId());
            c.setClassMajorId(majorDao.getIdByName(c.getClassMajorName()));
        }
        classDao.addFromExcel(params);
    }

    @Override
    public void output2Excel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "class_data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), SysClass.class).sheet("Sheet1").doWrite(get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int validator(SysClass params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(classDao.getIdByName(params.getClassName()))) return 1;
        } else {
            SysClass data = classDao.getById(params.getClassId());
            if (!data.getClassName().equals(params.getClassName())) {
                if (!ObjectUtils.isEmpty(classDao.getIdByName(params.getClassName()))) return 1;
            }
        }
        return 0;
    }
}
