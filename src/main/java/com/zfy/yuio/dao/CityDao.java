package com.zfy.yuio.dao;

import com.zfy.yuio.entity.City;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:45
*/
@Repository
public interface CityDao {
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
     *@Description 通过PID获取下级市县
     *@param id
     *@Return java.util.List<com.zfy.yuio.entity.City>
    */
    List<City> getByPid(String id);
}
