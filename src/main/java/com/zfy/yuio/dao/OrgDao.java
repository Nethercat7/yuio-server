package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Org;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:组织管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:56
*/
@Repository
public interface OrgDao {
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
     *@Return java.util.List<com.zfy.yuio.entity.SysCollege>
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

    /**
     *@Author Nethercat7
     *@Description 通过上级组织的ID来获取属于其的下级组织
     *@param id
     *@Return java.util.List<com.zfy.yuio.entity.SysCollege>
    */
    List<Org> getSubordinate(String id);

    /**
     *@Author Nethercat7
     *@Description 通过ID获取组织
     *@param id
     *@Return com.zfy.yuio.entity.Org
    */
    Org getById(String id);
}
