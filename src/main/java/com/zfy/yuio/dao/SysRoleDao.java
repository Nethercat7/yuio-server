package com.zfy.yuio.dao;

import com.zfy.yuio.entity.excel.ExcelRole;
import com.zfy.yuio.entity.system.SysRole;
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

    int del(Long id);

    int upd(SysRole params);

    int addPerms(Long rprRoleId, Long rprPermsId);

    List<Long> getRolePerms(Long id);

    int delPerms(Long id);

    void addFromExcel(List<ExcelRole> params);

    Long verify(String key);

    SysRole getById(Long id);

    List<SysRole> getByKeyword(String keyword);
}
