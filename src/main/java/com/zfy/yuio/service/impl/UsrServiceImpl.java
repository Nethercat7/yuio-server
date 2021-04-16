package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.UsrDao;
import com.zfy.yuio.entity.Usr;
import com.zfy.yuio.service.UsrService;
import com.zfy.yuio.utils.ShiroUntil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:08
*/
@Service
public class UsrServiceImpl implements UsrService {
    @Autowired
    private UsrDao usrDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil=new SnowflakeIdGeneratorUntil(4,0);

    @Override
    public int add(Usr usr) {
        String userId=snowflakeIdGeneratorUntil.getId();
        //Add role before add user
        for (String role:usr.getRoles()
             ) {
            String urId=snowflakeIdGeneratorUntil.getId();
            usrDao.addRole(urId,userId,role);
        }
        usr.setUsrId(userId);
        //set random salt
        usr.setUsrSalt(ShiroUntil.getSalt(7));
        //set default password
        usr.setUsrPwd(ShiroUntil.pwd2MD5("123456",usr.getUsrSalt(),1739));
        return usrDao.add(usr);
    }

    @Override
    public List<Usr> get() {
        return usrDao.get();
    }

    @Override
    public int del(String id) {
        return usrDao.del(id);
    }

    @Override
    public int upd(Usr usr) {
        return usrDao.upd(usr);
    }
}
