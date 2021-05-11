package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelCity;
import com.zfy.yuio.entity.system.SysCity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:城市管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:45
*/
@Repository
public interface SysCityDao {
    int add(SysCity params);

    List<SysCity> get();

    int del(Long id);

    int upd(SysCity params);

    SysCity getById(Long id);

    List<SysCity> getByKeyword(String keyword);

    void addFromExcel(List<ExcelCity> params);
}
