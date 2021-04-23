package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.CityDao;
import com.zfy.yuio.entity.City;
import com.zfy.yuio.service.CityService;
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
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(9, 0);

    @Override
    public int add(City city) {
        city.setCityId(snowflakeIdGeneratorUtil.getId());
        if (ObjectUtils.isEmpty(city.getCityPid())) {
            city.setCityPid("0");
            city.setCityLevel(0);
        }else{
            City c=cityDao.getById(city.getCityPid());
            city.setCityLevel(c.getCityLevel()+1);
        }
        return cityDao.add(city);
    }

    @Override
    public List<City> get() {
        List<City> cityList = cityDao.get();
        List<City> cities = new ArrayList<>();
        for (City c : cityList
        ) {
            if (c.getCityPid().equals("0")) cities.add(c);
        }
        for (City c : cities
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
    public int upd(City city) {
        if (ObjectUtils.isEmpty(city.getCityPid())) {
            city.setCityPid("0");
            city.setCityLevel(0);
        }else{
            City c=cityDao.getById(city.getCityPid());
            city.setCityLevel(c.getCityLevel()+1);
        }
        return cityDao.upd(city);
    }

    @Override
    public void initial(City city) {
        city.setCityId(snowflakeIdGeneratorUtil.getId());
        city.setCityStatus("0");
        if (city.getCityPid() == null) {
            city.setCityPid("0");
            city.setCityLevel(0);
        }
        cityDao.add(city);
        if (city.getChildren() != null) {
            setChildren(city.getChildren(), city.getCityId(), city.getCityLevel());
        }
    }

    private void setChildren(List<City> children, String pid, int level) {
        for (City c : children
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

    private List<City> getChildren(String pid, List<City> cityList) {
        List<City> children = new ArrayList<>();
        for (City c : cityList
        ) {
            if (c.getCityPid().equals(pid)) children.add(c);

        }
        for (City c : children
        ) {
            c.setChildren(getChildren(c.getCityId(), cityList));
            if(ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
