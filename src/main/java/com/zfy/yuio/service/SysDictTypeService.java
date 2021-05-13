package com.zfy.yuio.service;

import com.zfy.yuio.entity.excel.ExcelDictType;
import com.zfy.yuio.entity.system.SysDictType;

import java.util.List;

/**
 *@Description:字典类型
 *@Author:赵富源
 *@CreateDate:2021/4/22 20:29
*/
public interface SysDictTypeService {
    int add(SysDictType params);

    List<SysDictType> get();

    int del(Long id);

    int upd(SysDictType params);

    List<SysDictType> getByKeyword(String keyword);

    void addFromExcel(List<ExcelDictType> params);
}
