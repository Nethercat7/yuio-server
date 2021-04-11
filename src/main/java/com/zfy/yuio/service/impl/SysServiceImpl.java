package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysDao;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.ShiroUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 0:40
*/
@Service
public class SysServiceImpl implements SysService {
    @Autowired
    private SysDao sysDao;

    @Override
    public int resetPwd(Map<String,Object> map) {
        int type=Integer.parseInt(String.valueOf(map.get("type"))) ;
        String key=String.valueOf(map.get("key"));
        //获取随机盐
        Map<String,String> info=sysDao.getPwd(type,key);
        String pwd="";
        if(type==0){
            //do user op
        }else{
            String salt=info.get("student_salt");
            pwd= ShiroUntil.pwd2MD5("123456",salt,1739);
        }
        return sysDao.resetPwd(type,key,pwd);
    }
}
