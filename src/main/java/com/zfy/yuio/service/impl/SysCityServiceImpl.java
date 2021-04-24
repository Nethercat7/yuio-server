package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysCityDao;
import com.zfy.yuio.entity.SysCity;
import com.zfy.yuio.service.SysCityService;
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
public class SysCityServiceImpl implements SysCityService {
    @Autowired
    private SysCityDao cityDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(9, 0);

    @Override
    public int add(SysCity params) {
        params.setCityId(snowflakeIdGeneratorUtil.getId());
        if (ObjectUtils.isEmpty(params.getCityPid())) {
            params.setCityPid("0");
            params.setCityLevel(0);
        }else{
            SysCity c=cityDao.getById(params.getCityPid());
            params.setCityLevel(c.getCityLevel()+1);
        }
        return cityDao.add(params);
    }

    @Override
    public List<SysCity> get() {
        List<SysCity> cityList = cityDao.get();
        List<SysCity> cities = new ArrayList<>();
        for (SysCity c : cityList
        ) {
            if (c.getCityPid().equals("0")) cities.add(c);
        }
        for (SysCity c : cities
        ) {
            c.setChildren(getChildren(c.getCityId(), cityList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return cities;
    }

    @Override
    public int del(String id) {
        return cityDao.del(id);
    }

    @Override
    public int upd(SysCity params) {
        if (ObjectUtils.isEmpty(params.getCityPid())) {
            params.setCityPid("0");
            params.setCityLevel(0);
        }else{
            SysCity c=cityDao.getById(params.getCityPid());
            params.setCityLevel(c.getCityLevel()+1);
        }
        return cityDao.upd(params);
    }

    @Override
    public void initial(SysCity params) {
        params.setCityId(snowflakeIdGeneratorUtil.getId());
        params.setCityStatus("0");
        if (params.getCityPid() == null) {
            params.setCityPid("0");
            params.setCityLevel(0);
        }
        cityDao.add(params);
        if (params.getChildren() != null) {
            setChildren(params.getChildren(), params.getCityId(), params.getCityLevel());
        }
    }

    private void setChildren(List<SysCity> children, String pid, int level) {
        for (SysCity c : children
        ) {
            c.setCityId(snowflakeIdGeneratorUtil.getId());
            c.setCityStatus("0");
            c.setCityPid(pid);
            c.setCityLevel(level + 1);
            cityDao.add(c);
            if (c.getChildren() != null) {
                setChildren(c.getChildren(), c.getCityId(), c.getCityLevel());
            }
        }
    }

    private List<SysCity> getChildren(String pid, List<SysCity> cityList) {
        List<SysCity> children = new ArrayList<>();
        for (SysCity c : cityList
        ) {
            if (c.getCityPid().equals(pid)) children.add(c);

        }
        for (SysCity c : children
        ) {
            c.setChildren(getChildren(c.getCityId(), cityList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
