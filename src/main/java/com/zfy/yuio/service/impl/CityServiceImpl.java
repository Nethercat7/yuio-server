package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.CityDao;
import com.zfy.yuio.entity.City;
import com.zfy.yuio.service.CityService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:47
*/
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil=new SnowflakeIdGeneratorUtil(9,0);

    @Override
    public int add(City city) {
        city.setCityId(snowflakeIdGeneratorUtil.getId());
        city.setCityStatus(0);
        if(ObjectUtils.isEmpty(city.getCityPid())){
            city.setCityPid("0");
            city.setCityLevel(0);
        }
        cityDao.add(city);
        if(city.getChildren()!=null){
            setChildren(city.getChildren(),city.getCityPid(),city.getCityLevel());
        }
        return 0;
    }

    private void setChildren(List<City> children,String pid,int level){
        for (City c:children
             ) {
            c.setCityId(snowflakeIdGeneratorUtil.getId());
            c.setCityStatus(0);
            c.setCityPid(pid);
            c.setCityLevel(level+1);
            cityDao.add(c);
            if(c.getChildren()!=null){
                setChildren(c.getChildren(),c.getCityId(),c.getCityLevel());
            }
        }
    }
}
