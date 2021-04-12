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
        boolean isUser=Boolean.parseBoolean(String.valueOf(map.get("isUser"))) ;
        String key=String.valueOf(map.get("key"));
        //获取随机盐
        Map<String,String> info=sysDao.getPwd(isUser,key);
        String pwd="";
        if(isUser){
            //do user op
        }else{
            String salt=info.get("student_salt");
            pwd= ShiroUntil.pwd2MD5("123456",salt,1739);
        }
        return sysDao.resetPwd(isUser,key,pwd);
    }

    @Override
    public int login(Map<String, Object> map) {
        boolean isUser= Boolean.parseBoolean(String.valueOf(map.get("isUser")));
        String key=String.valueOf(map.get("key"));
        String pwd=String.valueOf(map.get("pwd"));
        Map<String,String> info=sysDao.getPwd(isUser,key);
        if(info!=null){
            String currentPwd="";
            String salt="";
            if(isUser){
                currentPwd=info.get("user_pwd");
                salt=info.get("user_salt");
            }else{
                currentPwd=info.get("student_pwd");
                salt=info.get("student_salt");
            }
            if(!currentPwd.equals(ShiroUntil.pwd2MD5(pwd,salt,1739))){
                return 2;
            }
            return 0;
        }else{
            return 1;
        }
    }
}
