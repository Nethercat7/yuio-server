package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelMajor;
import com.zfy.yuio.entity.system.SysMajor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
@Repository
public interface SysMajorDao {
    int add(SysMajor params);

    List<SysMajor> get();

    int del(Long id);

    int upd(SysMajor params);

    List<SysMajor> getByPid(Long pid);

    List<SysMajor> getByKeyword(String keyword);

    void addFromExcel(List<ExcelMajor> params);
}
