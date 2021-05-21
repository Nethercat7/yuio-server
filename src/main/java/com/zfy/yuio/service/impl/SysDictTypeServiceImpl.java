package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysDictTypeDao;
import com.zfy.yuio.entity.system.SysDictType;
import com.zfy.yuio.service.SysDictTypeService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {
    @Autowired
    private SysDictTypeDao sysDictTypeDao;

    private SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(11, 0);

    @Override
    public int add(SysDictType params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setDictId(snowflakeIdGeneratorUtil.nextId());
            sysDictTypeDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysDictType> get() {
        return sysDictTypeDao.get();
    }

    @Override
    public int del(Long id) {
        return sysDictTypeDao.del(id);
    }

    @Override
    public int upd(SysDictType params) {
        int status = validator(params, 1);
        if (status == 0) {
            sysDictTypeDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysDictType> getByKeyword(String keyword) {
        return sysDictTypeDao.getByKeyword(keyword);
    }

    @Override
    public void addFromExcel(List<SysDictType> params) {
        sysDictTypeDao.addFromExcel(params);
    }

    @Override
    public void output2Excel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "dict_type_data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), SysDictType.class).sheet("Sheet1").doWrite(get());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int validator(SysDictType params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(sysDictTypeDao.verify(params.getDictName()))) return 1;
            if (!ObjectUtils.isEmpty(sysDictTypeDao.verify(params.getDictType()))) return 2;
        } else {
            SysDictType data = sysDictTypeDao.getById(params.getDictId());
            if (!data.getDictName().equals(params.getDictName())) {
                if (!ObjectUtils.isEmpty(params.getDictName())) return 1;
            }
            if (!data.getDictType().equals(params.getDictType())) {
                if (!ObjectUtils.isEmpty(params.getDictType())) return 2;
            }
        }
        return 0;
    }
}
