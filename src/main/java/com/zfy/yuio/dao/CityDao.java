package com.zfy.yuio.dao;

import com.zfy.yuio.entity.City;
import org.springframework.stereotype.Repository;

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
}
