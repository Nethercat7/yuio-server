package com.zfy.yuio.service;

import com.zfy.yuio.entity.Menu;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:11
*/
public interface MenuService {
    /**
     *@Author Nethercat7
     *@Description Add menu
     *@param menu
     *@Return int
     */
    int add(Menu menu);

    /**
     *@Author Nethercat7
     *@Description Get menu
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.Menu>
     */
    List<Menu> get();

    /**
     *@Author Nethercat7
     *@Description Delete menu
     *@param id
     *@Return int
     */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description Update menu
     *@param menu
     *@Return int
     */
    int upd(Menu menu);
}
