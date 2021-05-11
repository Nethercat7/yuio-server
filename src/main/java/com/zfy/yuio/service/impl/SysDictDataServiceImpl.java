package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDictDataDao;
import com.zfy.yuio.entity.system.SysDictData;
import com.zfy.yuio.service.SysDictDataService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictDataServiceImpl implements SysDictDataService {
    @Autowired
    private SysDictDataDao sysDictDataDao;

    private SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil=new SnowflakeIdGeneratorUtil(12,0);

    @Override
    public int add(SysDictData sysDictData) {
        sysDictData.setDictId(snowflakeIdGeneratorUtil.nextId());
        return sysDictDataDao.add(sysDictData);
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
    public int upd(SysDictData sysDictData) {
        return sysDictDataDao.upd(sysDictData);
    }

    @Override
    public List<SysDictData> getByKeyword(String keyword) {
        return sysDictDataDao.getByKeyword(keyword);
    }

    @Override
    public List<SysDictData> getAll() {
        return sysDictDataDao.getAll();
    }
}
