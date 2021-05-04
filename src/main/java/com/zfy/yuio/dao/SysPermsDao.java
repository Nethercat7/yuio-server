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
public interface SysPermsDao {
    int add(SysPerms params);

    List<SysPerms> get();

    int del(Long id);

    int upd(SysPerms params);

    List<String> getUserPerms(Long id);

    List<String> getStudentPerms(Long id);
}
