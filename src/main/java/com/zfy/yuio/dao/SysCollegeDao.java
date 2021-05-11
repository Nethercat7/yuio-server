package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelCollege;
import com.zfy.yuio.entity.system.SysCollege;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:院系管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
@Repository
public interface SysCollegeDao {
    int add(SysCollege params);

    List<SysCollege> get();

    int del(Long id);

    int upd(SysCollege params);

    SysCollege getById(Long id);

    List<SysCollege> getByKeyword(String keyword);

    void addFromExcel(List<ExcelCollege> params);
}
