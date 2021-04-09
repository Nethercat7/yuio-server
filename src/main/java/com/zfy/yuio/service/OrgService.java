package com.zfy.yuio.service;

import com.zfy.yuio.entity.Org;

import java.util.List;

/**
 *@Description:组织管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
public interface OrgService {
    /**
     *@Author Nethercat7
     *@Description 添加院系
     *@param org
     *@Return int
     */
    int add(Org org);

    /**
     *@Author Nethercat7
     *@Description 查找院系
     *@param
     *@Return java.util.List<com.zfy.yuio.entity.College>
     */
    List<Org> get();

    /**
     *@Author Nethercat7
     *@Description 根据ID删除院系
     *@param id
     *@Return int
     */
    int del(String id);

    /**
     *@Author Nethercat7
     *@Description 修改院系信息
     *@param org
     *@Return int
     */
    int upd(Org org);
}
