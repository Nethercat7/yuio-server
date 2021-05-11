package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysMajor;

import java.util.List;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
public interface SysMajorService {
    int add(SysMajor params);

    List<SysMajor> get();

    int del(Long id);

    int upd(SysMajor params);

    List<SysMajor> getByKeyword(String keyword);
}
