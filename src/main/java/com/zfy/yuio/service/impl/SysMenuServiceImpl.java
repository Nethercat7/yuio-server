package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysMenuDao;
import com.zfy.yuio.entity.SysPerms;
import com.zfy.yuio.service.SysMenuService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuDao menuDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(6,0);

    @Override
    public int add(SysPerms params) {
        params.setPermsId(snowflakeIdGeneratorUtil.getId());
        if(params.getPermsPid()==null||params.getPermsPid().isEmpty()){
            params.setPermsPid("0");
        }
        params.setPermsLevel(1);
        return menuDao.add(params);
    }

    @Override
    public List<SysPerms> get() {
        //获取所有的menu
        List<SysPerms> menus= menuDao.get();
        //存放最上级的menu
        List<SysPerms> menuList=new ArrayList<>();
        for (SysPerms m:menus
             ) {
            if(m.getPermsPid().equals("0")){
                menuList.add(m);
            }
        }
        for (SysPerms m:menuList
             ) {
            m.setChildren(getChildren(m.getPermsId(),menus));
        }
        return menuList;
    }

    @Override
    public int del(String id) {
        return menuDao.del(id);
    }

    @Override
    public int upd(SysPerms params) {
        if(params.getPermsPid()==null||params.getPermsPid().isEmpty()){
            params.setPermsPid("0");
        }
        return menuDao.upd(params);
    }

    private List<SysPerms> getChildren(String pid, List<SysPerms> list){
        List<SysPerms> children=new ArrayList<>();
        for (SysPerms m:list
             ) {
            if(m.getPermsPid().equals(pid)){
                children.add(m);
            }
        }

        for (SysPerms m:children
             ) {
            m.setChildren(getChildren(m.getPermsId(),list));
        }
        return children;
    }

    @Override
    public List<String> getUserPerms(String id) {
        return menuDao.getUserPerms(id);
    }
}
