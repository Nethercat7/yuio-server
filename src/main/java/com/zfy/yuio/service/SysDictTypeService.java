package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysDictType;

import javax.servlet.http.HttpServletResponse;
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

    void addFromExcel(List<SysDictType> params);

    void output2Excel(HttpServletResponse response);
}
