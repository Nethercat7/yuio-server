package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.MenuDao;
import com.zfy.yuio.entity.Menu;
import com.zfy.yuio.service.MenuService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(6,0);

    @Override
    public int add(Menu menu) {
        menu.setMenuId(snowflakeIdGeneratorUntil.getId());
        menu.setMenuPid("0");
        menu.setMenuLevel(1);
        return menuDao.add(menu);
    }

    @Override
    public List<Menu> get() {
        return menuDao.get();
    }

    @Override
    public int del(String id) {
        return menuDao.del(id);
    }

    @Override
    public int upd(Menu menu) {
        return menuDao.upd(menu);
    }
}
