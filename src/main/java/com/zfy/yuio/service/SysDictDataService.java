package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysDictData;

import java.util.List;

/**
 *@Description:字典数据
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 20:29
*/
public interface SysDictDataService {
    int add(SysDictData sysDictData);

    List<SysDictData> get(String type);

    int del(Long id);

    int upd(SysDictData sysDictData);

    List<SysDictData> getByKeyword(String keyword);

    List<SysDictData> getAll();

    void addFromExcel(List<SysDictData> params);
}
