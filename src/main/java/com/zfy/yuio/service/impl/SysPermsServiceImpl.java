package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysPermsDao;
import com.zfy.yuio.entity.system.SysPerms;
import com.zfy.yuio.service.SysPermsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysPermsServiceImpl implements SysPermsService {
    @Autowired
    private SysPermsDao permsDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(6,0);

    @Override
    public int add(SysPerms params) {
        params.setPermsId(snowflakeIdGeneratorUtil.nextId());
        if(ObjectUtils.isEmpty(params.getPermsPid())){
            params.setPermsPid(0L);
        }
        params.setPermsLevel(1);
        return permsDao.add(params);
    }

    @Override
    public List<SysPerms> get() {
        List<SysPerms> perms= permsDao.get();
        List<SysPerms> permsList=new ArrayList<>();
        for (SysPerms p:perms
             ) {
            if(p.getPermsPid()==0){
                permsList.add(p);
            }
        }
        for (SysPerms m:permsList
             ) {
            m.setChildren(getChildren(m.getPermsId(),perms));
        }
        return permsList;
    }

    @Override
    public int del(Long id) {
        return permsDao.del(id);
    }

    @Override
    public int upd(SysPerms params) {
        if(ObjectUtils.isEmpty(params.getPermsPid())){
            params.setPermsPid(0L);
        }
        return permsDao.upd(params);
    }

    @Override
    public List<String> getUserPerms(Long id) {
        return permsDao.getUserPerms(id);
    }

    @Override
    public List<String> getStudentPerms(Long id) {
        return permsDao.getStudentPerms(id);
    }

    @Override
    public List<SysPerms> getByKeyword(String keyword) {
        return permsDao.getByKeyword(keyword);
    }

    @Override
    public List<SysPerms> getWithoutConvert() {
        return permsDao.get();
    }

    @Override
    public void addFromExcel(List<SysPerms> params) {
        permsDao.addFromExcel(params);
    }

    private List<SysPerms> getChildren(Long pid, List<SysPerms> list){
        List<SysPerms> children=new ArrayList<>();
        for (SysPerms p:list
        ) {
            if(p.getPermsPid().equals(pid)){
                children.add(p);
            }
        }

        for (SysPerms m:children
        ) {
            m.setChildren(getChildren(m.getPermsId(),list));
        }
        return children;
    }
}
