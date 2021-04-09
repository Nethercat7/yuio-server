package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.OrgDao;
import com.zfy.yuio.entity.Org;
import com.zfy.yuio.service.OrgService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:组织管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/8 19:58
 */
@Service
public class OrgServiceImpl implements OrgService {
    @Autowired
    private OrgDao orgDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil = new SnowflakeIdGeneratorUntil(0, 0);

    @Override
    public int add(Org org) {
        org.setOrgId(snowflakeIdGeneratorUntil.getId());
        if (org.getOrgPid() == null) {
            org.setOrgPid("0");
            org.setOrgLevel(0);
        } else {
            Org o = orgDao.getById(org.getOrgPid());
            org.setOrgLevel(o.getOrgLevel() + 1);
        }
        return orgDao.add(org);
    }

    @Override
    public List<Org> get() {
        List<Org> org = orgDao.get();
        List<Org> orgList=new ArrayList<>();//存放最上级的Org
        //遍历，筛选出所有的最上级Org
        for (Org o:org
             ) {
            if(o.getOrgPid().equals("0")){
                orgList.add(o);
            }
        }
        //为上级设置children
        for (Org o:orgList
             ) {
            o.setChildren(getChildren(o.getOrgId(),org));
        }
        return orgList;
    }

    @Override
    public int del(String id) {
        return orgDao.del(id);
    }

    @Override
    public int upd(Org org) {
        if(org.getOrgPid()==null) org.setOrgPid("0");
        return orgDao.upd(org);
    }

    private List<Org> getChildren(String pid,List<Org> list){
        //用于存放children
        List<Org> children=new ArrayList<>();
        //遍历，将当前对象的pid与参数中pid匹配的对象存入list中
        for (Org o:list
             ) {
            if(o.getOrgPid().equals(pid)){
                children.add(o);
            }
        }
        //为当前的children list中的对象设置children，重复上面的步骤
        for (Org o:children
             ) {
            o.setChildren(getChildren(o.getOrgId(),list));
        }
        return children;
    }
}
