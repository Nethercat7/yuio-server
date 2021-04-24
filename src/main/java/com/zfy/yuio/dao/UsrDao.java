package com.zfy.yuio.dao;

import com.zfy.yuio.entity.Usr;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:用户管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 17:05
 */
@Repository
public interface UsrDao {
    int add(Usr usr);

    List<Usr> get();

    int del(String id);

    int upd(Usr usr);

    int addRole(String urrId, String urrUsrId, String urrRoleId);

    List<String> getRoles(String id);

    int delRole(String id);

    Usr getByCode(String param);
}
