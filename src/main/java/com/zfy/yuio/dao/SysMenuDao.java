package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysPerms;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:08
*/
@Repository
public interface SysMenuDao {
    int add(SysPerms params);

    List<SysPerms> get();

    int del(String id);

    int upd(SysPerms params);

    List<String> getUserPerms(String id);
}
