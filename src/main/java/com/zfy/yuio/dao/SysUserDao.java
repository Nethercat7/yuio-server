package com.zfy.yuio.dao;

import com.zfy.yuio.entity.system.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:用户管理模块
 * @Author:赵富源
 * @CreateDate:2021/4/12 17:05
 */
@Repository
public interface SysUserDao {
    int add(SysUser params);

    List<SysUser> get();

    int del(Long id);

    int upd(SysUser params);

    int addRole(Long userId, Long roleId);

    List<Long> getRoles(Long id);

    int delRole(Long id);

    SysUser getById(Long id);

    List<SysUser> getByKeyword(String keyword);

    int updProfile(SysUser params);

    void addFromExcel(List<SysUser> params);

    Long verify(String key);

    List<SysUser> getByCollege(Long id);
}
