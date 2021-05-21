package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysWork;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *@Description:岗位管理
 *@Author:赵富源
 *@CreateDate:2021/4/20 18:47
*/
public interface SysWorkService {
    int add(SysWork params);

    List<SysWork> get();

    int del(Long id);

    int upd(SysWork params);

    List<SysWork> getByKeyword(String keyword);

    List<SysWork> getWithoutConvert();

    void addFromExcel(List<SysWork> params);

    void output2Excel(HttpServletResponse response);
}
