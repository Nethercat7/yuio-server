package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysMajor;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *@Description:专业管理
 *@Author:赵富源
 *@CreateDate:2021/4/8 19:56
*/
public interface SysMajorService {
    int add(SysMajor params);

    List<SysMajor> get();

    int del(Long id);

    int upd(SysMajor params);

    List<SysMajor> getByKeyword(String keyword);

    void addFromExcel(List<SysMajor> params);

    void output2Excel(HttpServletResponse response);
}
