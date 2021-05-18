package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysCityDao;
import com.zfy.yuio.entity.excel.ExcelCity;
import com.zfy.yuio.entity.system.SysCity;
import com.zfy.yuio.service.SysCityService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:城市管理
 * @Author:赵富源
 * @CreateDate:2021/4/20 18:47
 */
@Service
public class SysCityServiceImpl implements SysCityService {
    @Autowired
    private SysCityDao cityDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(9, 0);

    @Override
    public int add(SysCity params) {
        int status = validator(params, 0);
        if (status == 0) {
            if (ObjectUtils.isEmpty(params.getCityPid())) {
                params.setCityPid(0L);
                params.setCityLevel(0);
            } else {
                SysCity c = cityDao.getById(params.getCityPid());
                params.setCityLevel(c.getCityLevel() + 1);
            }
            cityDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysCity> get() {
        List<SysCity> cityList = cityDao.get();
        List<SysCity> cities = new ArrayList<>();
        for (SysCity c : cityList
        ) {
            if(c.getCityStatus().equals("1")){
                c.setDisabled(true);
            }
            if (c.getCityPid() == 0) cities.add(c);
        }
        for (SysCity c : cities
        ) {
            c.setChildren(getChildren(c.getCityId(), cityList));
            if (ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return cities;
    }

    @Override
    public int del(Long id) {
        return cityDao.del(id);
    }

    @Override
    public int upd(SysCity params) {
        int status = validator(params, 1);
        if(status==0){
            if (ObjectUtils.isEmpty(params.getCityPid())) {
                params.setCityPid(0L);
                params.setCityLevel(0);
            } else {
                SysCity c = cityDao.getById(params.getCityPid());
                if (!ObjectUtils.isEmpty(c)) params.setCityLevel(c.getCityLevel() + 1);
            }
            cityDao.upd(params);
        }
        return status;
    }

    @Override
    public List<SysCity> getByKeyword(String keyword) {
        return cityDao.getByKeyword(keyword);
    }

    @Override
    public List<SysCity> getWithoutConvert() {
        return cityDao.get();
    }

    @Override
    public void addFromExcel(List<ExcelCity> params) {
        cityDao.addFromExcel(params);
    }

    private int validator(SysCity params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(cityDao.verify(params.getCityName()))) return 1;
        } else {
            SysCity data = cityDao.getById(params.getCityId());
            if (!data.getCityName().equals(params.getCityName())) {
                if (!ObjectUtils.isEmpty(cityDao.verify(params.getCityName()))) return 1;
            }
        }
        return 0;
    }

    private List<SysCity> getChildren(Long pid, List<SysCity> cityList) {
        List<SysCity> children = new ArrayList<>();
        for (SysCity c : cityList
        ) {
            if (c.getCityPid().equals(pid)) children.add(c);

        }
        for (SysCity c : children
        ) {
            c.setChildren(getChildren(c.getCityId(), cityList));
            if (ObjectUtils.isEmpty(c.getChildren())) c.setChildren(null);
        }
        return children;
    }
}
