package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysCity;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:47
*/
public interface SysCityService {
    int add(SysCity params);

    List<SysCity> get();

    int del(Long id);

    int upd(SysCity params);

    List<SysCity> getByKeyword(String keyword);
}
