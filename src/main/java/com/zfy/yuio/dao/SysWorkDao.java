package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelWork;
import com.zfy.yuio.entity.system.SysWork;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:岗位管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:45
*/
@Repository
public interface SysWorkDao {
    int add(SysWork params);

    List<SysWork> get();

    int del(Long id);

    int upd(SysWork params);

    SysWork getById(Long id);

    List<SysWork> getByKeyword(String keyword);

    void addFromExcel(List<ExcelWork> params);
}
