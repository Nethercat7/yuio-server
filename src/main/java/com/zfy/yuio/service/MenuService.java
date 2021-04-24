package com.zfy.yuio.service;

import com.zfy.yuio.entity.Menu;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:11
*/
public interface MenuService {

    int add(Menu menu);


    List<Menu> get();


    int del(String id);

    int upd(Menu menu);

    List<String> getUserPerms(String id);
}
