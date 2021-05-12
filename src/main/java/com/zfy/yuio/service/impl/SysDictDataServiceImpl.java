package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDictDataDao;
import com.zfy.yuio.entity.excel.ExcelDictData;
import com.zfy.yuio.entity.system.SysDictData;
import com.zfy.yuio.service.SysDictDataService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class SysDictDataServiceImpl implements SysDictDataService {
    @Autowired
    private SysDictDataDao sysDictDataDao;

    private SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(12, 0);

    @Override
    public int add(SysDictData params) {
        int status = validator(params, 0);
        if (status == 0) {
            params.setDictId(snowflakeIdGeneratorUtil.nextId());
            sysDictDataDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysDictData> get(String type) {
        return sysDictDataDao.get(type);
    }

    @Override
    public int del(Long id) {
        return sysDictDataDao.del(id);
    }

    @Override
    public int upd(SysDictData params) {
        int status = validator(params, 1);
        if (status == 0) {
            sysDictDataDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysDictData> getByKeyword(String keyword) {
        return sysDictDataDao.getByKeyword(keyword);
    }

    @Override
    public List<SysDictData> getAll() {
        return sysDictDataDao.getAll();
    }

    @Override
    public void addFromExcel(List<ExcelDictData> params) {
        sysDictDataDao.addFromExcel(params);
    }

    private int validator(SysDictData params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(sysDictDataDao.verify(params.getDictLabel()))) return 1;
            if (!ObjectUtils.isEmpty(sysDictDataDao.verify(params.getDictType()))) return 2;
        } else {
            SysDictData data = sysDictDataDao.getById(params.getDictId());
            if (!data.getDictLabel().equals(params.getDictLabel())) {
                if (!ObjectUtils.isEmpty(params.getDictLabel())) return 1;
            }
            if (!data.getDictType().equals(params.getDictType())) {
                if (!ObjectUtils.isEmpty(params.getDictType())) return 2;
            }
        }
        return 0;
    }
}
