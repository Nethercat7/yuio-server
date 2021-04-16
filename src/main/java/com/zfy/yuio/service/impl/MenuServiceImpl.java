package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.MenuDao;
import com.zfy.yuio.entity.Menu;
import com.zfy.yuio.service.MenuService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(6,0);

    @Override
    public int add(Menu menu) {
        menu.setMenuId(snowflakeIdGeneratorUntil.getId());
        if(menu.getMenuPid()==null||menu.getMenuPid().isEmpty()){
            menu.setMenuPid("0");
        }
        menu.setMenuLevel(1);
        return menuDao.add(menu);
    }

    @Override
    public List<Menu> get() {
        //获取所有的menu
        List<Menu> menus= menuDao.get();
        //存放最上级的menu
        List<Menu> menuList=new ArrayList<>();
        for (Menu m:menus
             ) {
            if(m.getMenuPid().equals("0")){
                menuList.add(m);
            }
        }
        for (Menu m:menuList
             ) {
            m.setChildren(getChildren(m.getMenuId(),menus));
        }
        return menuList;
    }

    @Override
    public int del(String id) {
        return menuDao.del(id);
    }

    @Override
    public int upd(Menu menu) {
        if(menu.getMenuPid()==null||menu.getMenuPid().isEmpty()){
            menu.setMenuPid("0");
        }
        return menuDao.upd(menu);
    }

    private List<Menu> getChildren(String pid,List<Menu> list){
        List<Menu> children=new ArrayList<>();
        for (Menu m:list
             ) {
            if(m.getMenuPid().equals(pid)){
                children.add(m);
            }
        }

        for (Menu m:children
             ) {
            m.setChildren(getChildren(m.getMenuId(),list));
        }
        return children;
    }
}
