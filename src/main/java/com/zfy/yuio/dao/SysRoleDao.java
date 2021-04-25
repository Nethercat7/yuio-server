package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:Role mgt
 * @Author:Nethercat7
 * @CreateDate:2021/4/13 22:39
 */
@Repository
public interface SysRoleDao {

    int add(SysRole params);

    List<SysRole> get();

    int del(String id);

    int upd(SysRole params);

    int addPerms(String rprId, String rprRoleId, String rprPermsId);

    List<String> getRolePerms(String id);

    int delPerms(String id);
}
