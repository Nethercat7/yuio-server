package com.zfy.yuio.dao;

import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/11 23:56
*/
@Repository
public interface SysDao {

    int resetPwd(boolean isUser,String key,String pwd);

    Map<String,String> getPwd(boolean isUser,String key);

    int saveEmploymentStatus(WriteEmplInfo eStatus);

    WriteEmplInfo getEStatusById(Long id);

    int updEStatus(WriteEmplInfo eStatus);

    List<Integer> getGrade();

    SysUser getUsrLoginInfo(String account);

    SysStudent getStudentLoginInfo(String code);
}
