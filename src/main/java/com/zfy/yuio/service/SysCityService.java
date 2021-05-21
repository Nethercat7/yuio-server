package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysCity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *@Description:城市管理
 *@Author:赵富源
 *@CreateDate:2021/4/20 18:47
*/
public interface SysCityService {
    int add(SysCity params);

    List<SysCity> get();

    int del(Long id);

    int upd(SysCity params);

    List<SysCity> getByKeyword(String keyword);

    List<SysCity> getWithoutConvert();

    void addFromExcel(List<SysCity> params);

    void output2Excel(HttpServletResponse response);
}
