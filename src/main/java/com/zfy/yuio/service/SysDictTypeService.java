package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysDictType;

import java.util.List;

/**
 *@Description:字典类型
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 20:29
*/
public interface SysDictTypeService {
    int add(SysDictType sysDictType);

    List<SysDictType> get();

    int del(String id);
}
