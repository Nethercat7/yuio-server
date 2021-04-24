package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:08
*/
@Repository
public interface MenuDao {
    int add(Menu menu);

    List<Menu> get();

    int del(String id);

    int upd(Menu menu);

    List<String> getUserPerms(String id);
}
