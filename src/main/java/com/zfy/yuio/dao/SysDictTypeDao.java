package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelDictType;
import com.zfy.yuio.entity.system.SysDictType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:字典类型
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 20:29
*/
@Repository
public interface SysDictTypeDao {
    int add(SysDictType params);

    List<SysDictType> get();

    int del(Long id);

    int upd(SysDictType params);

    List<SysDictType> getByKeyword(String keyword);

    void addFromExcel(List<ExcelDictType> params);
}
