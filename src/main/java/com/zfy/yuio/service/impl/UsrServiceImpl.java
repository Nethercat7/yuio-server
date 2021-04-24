package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.UsrDao;
import com.zfy.yuio.entity.Usr;
import com.zfy.yuio.service.UsrService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
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

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil =new SnowflakeIdGeneratorUtil(4,0);

    @Override
    public int add(Usr usr) {
        String userId= snowflakeIdGeneratorUtil.getId();
        //Add role before add user
        for (String role:usr.getRoles()
             ) {
            String urrId= snowflakeIdGeneratorUtil.getId();
            usrDao.addRole(urrId,userId,role);
        }
        usr.setUsrId(userId);
        //set random salt
        usr.setUsrSalt(ShiroUtil.getSalt(7));
        //set default password
        usr.setUsrPwd(ShiroUtil.pwd2MD5("123456",usr.getUsrSalt(),1739));
        return usrDao.add(usr);
    }

    @Override
    public List<Usr> get() {
        List<Usr> usrList=usrDao.get();
        for (Usr u:usrList
             ) {
            u.setRoles(usrDao.getRoles(u.getUsrId()));
        }
        return usrList;
    }

    @Override
    public Usr get(String param) {
        Usr usr=usrDao.get(param);
        usr.setRoles(usrDao.getRoles(usr.getUsrId()));
        return usr;
    }

    @Override
    public int del(String id) {
        usrDao.delRole(id);
        return usrDao.del(id);
    }

    @Override
    public int upd(Usr usr) {
        //先删除关系表中的用户角色信息
        usrDao.delRole(usr.getUsrId());
        //再重新添加
        for (String r: usr.getRoles()
             ) {
            usrDao.addRole(snowflakeIdGeneratorUtil.getId(),usr.getUsrId(),r);
        }
        return usrDao.upd(usr);
    }
}
