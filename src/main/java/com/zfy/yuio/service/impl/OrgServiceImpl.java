package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.OrgDao;
import com.zfy.yuio.entity.Org;
import com.zfy.yuio.service.OrgService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:组织管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 19:58
*/
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgDao orgDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(0,0);

    @Override
    public int add(Org org) {
        org.setOrgId(snowflakeIdGeneratorUntil.getId());
        return orgDao.add(org);
    }

    @Override
    public List<Org> get() {
        List<Org> org=orgDao.get();
        //获取下级组织
        for (Org o:org
             ) {
            o.setChildren(orgDao.getSubordinate(o.getOrgId()));
        }
        return org;
    }

    @Override
    public int del(String id) {
        return orgDao.del(id);
    }

    @Override
    public int upd(Org org) {
        return orgDao.upd(org);
    }
}
