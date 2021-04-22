package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDictTypeDao;
import com.zfy.yuio.entity.SysDictType;
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
    public int add(SysDictType sysDictType) {
        sysDictType.setDictId(snowflakeIdGeneratorUtil.getId());
        return sysDictTypeDao.add(sysDictType);
    }

    @Override
    public List<SysDictType> get() {
        return sysDictTypeDao.get();
    }

    @Override
    public int del(String id) {
        return sysDictTypeDao.del(id);
    }
}
