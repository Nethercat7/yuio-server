package com.zfy.yuio.service;

import com.zfy.yuio.entity.excel.ExcelCollege;
import com.zfy.yuio.entity.system.SysCollege;

import java.util.List;

/**
 *@Description:院系管理
 *@Author:赵富源
 *@CreateDate:2021/4/8 19:56
*/
public interface SysCollegeService {
    /**
     *@Author 赵富源
     *@Description 添加院系
     *@param params
     *@Return int
     */
    int add(SysCollege params);

    /**
     *@Author 赵富源
     *@Description 查找院系
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.system.SysCollege>
     */
    List<SysCollege> get();

    /**
     *@Author 赵富源
     *@Description 根据ID删除院系
     *@param id
     *@Return int
     */
    int del(Long id);

    /**
     *@Author 赵富源
     *@Description 修改院系信息
     *@param params
     *@Return int
     */
    int upd(SysCollege params);

    List<SysCollege> getByKeyword(String keyword);

    void addFromExcel(List<ExcelCollege> params);
}
