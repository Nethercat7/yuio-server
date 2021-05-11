package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDictTypeDao;
import com.zfy.yuio.entity.excel.ExcelDictType;
import com.zfy.yuio.entity.system.SysDictType;
import com.zfy.yuio.service.SysDictTypeService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictTypeServiceImpl implements SysDictTypeService {
    @Autowired
    private SysDictTypeDao sysDictTypeDao;

    private SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil=new SnowflakeIdGeneratorUtil(11,0);

    @Override
    public int add(SysDictType params) {
        params.setDictId(snowflakeIdGeneratorUtil.nextId());
        return sysDictTypeDao.add(params);
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
        return sysDictTypeDao.upd(params);
    }

    @Override
    public List<SysDictType> getByKeyword(String keyword) {
        return sysDictTypeDao.getByKeyword(keyword);
    }

    @Override
    public void addFromExcel(List<ExcelDictType> params) {
        sysDictTypeDao.addFromExcel(params);
    }
}
