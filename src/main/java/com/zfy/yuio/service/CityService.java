package com.zfy.yuio.service;

import com.zfy.yuio.entity.City;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:47
*/
public interface CityService {
    /**
     *@Author Nethercat7
     *@Description 添加城市
     *@param city
     *@Return int
     */
    int add(City city);

    /**
     *@Author Nethercat7
     *@Description 获取城市信息
     *@param
     *@Return List<City>
     */
    List<City> get();

    /**
     *@Author Nethercat7
     *@Description 城市信息初始化
     *@param city
     *@Return
    */
    void initial(City city);
}
