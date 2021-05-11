package com.zfy.yuio.service;

import com.zfy.yuio.entity.excel.ExcelPerms;
import com.zfy.yuio.entity.system.SysPerms;

import java.util.List;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:11
*/
public interface SysPermsService {

    int add(SysPerms params);

    List<SysPerms> get();

    int del(Long id);

    int upd(SysPerms params);

    List<String> getUserPerms(Long id);

    List<String> getStudentPerms(Long id);

    List<SysPerms> getByKeyword(String keyword);

    List<SysPerms> getWithoutConvert();

    void addFromExcel(List<ExcelPerms> params);
}
