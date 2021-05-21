package com.zfy.yuio.dao;

import com.zfy.yuio.entity.system.SysDictData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:字典数据
 *@Author:赵富源
 *@CreateDate:2021/4/22 23:55
*/
@Repository
public interface SysDictDataDao {
    int add(SysDictData sysDictData);

    List<SysDictData> get(String type);

    int del(Long id);

    int upd(SysDictData sysDictData);

    List<SysDictData> getByKeyword(String keyword);

    List<SysDictData> getAll();

    void addFromExcel(List<SysDictData> params);

    SysDictData getById(Long id);

    Long verify(String key);
}
