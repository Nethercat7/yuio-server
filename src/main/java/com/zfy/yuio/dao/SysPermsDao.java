package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelPerms;
import com.zfy.yuio.entity.system.SysPerms;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:赵富源
 *@CreateDate:2021/4/16 21:08
*/
@Repository
public interface SysPermsDao {
    int add(SysPerms params);

    List<SysPerms> get();

    int del(Long id);

    int upd(SysPerms params);

    List<String> getUserPerms(String code);

    List<String> getStudentPerms(String code);

    List<SysPerms> getByKeyword(String keyword);

    List<SysPerms> getUserMenus(Long id);

    List<SysPerms> getStudentMenus(Long id);

    void addFromExcel(List<ExcelPerms> params);

    SysPerms getById(Long id);

    Long verify(String key);
}
