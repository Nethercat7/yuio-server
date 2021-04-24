package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:用户管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 17:05
 */
@Repository
public interface SysUsrDao {
    int add(SysUser params);

    List<SysUser> get();

    int del(String id);

    int upd(SysUser params);

    int addRole(String id, String userId, String roleId);

    List<String> getRoles(String id);

    int delRole(String id);

    SysUser getByCode(String param);
}
