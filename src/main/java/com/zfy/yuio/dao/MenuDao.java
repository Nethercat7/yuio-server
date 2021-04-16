package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Menu;
import org.springframework.stereotype.Repository;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:08
*/
@Repository
public interface MenuDao {
    /**
     *@Author Nethercat7
     *@Description Add menu
     *@param menu
     *@Return int
    */
    int add(Menu menu);
}
