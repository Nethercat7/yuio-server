package com.zfy.yuio.dao;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 *@Description:系统功能模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/11 23:56
*/
@Repository
public interface SysDao {
    /**
     *@Author Nethercat7
     *@Description 重置密码
     *@param isUser
     *@param key
     *@param pwd
     *@Return int
     */
    int resetPwd(boolean isUser,String key,String pwd);

    /**
     *@Author Nethercat7
     *@Description 获取密码信息
     *@param isUser
     *@param key
     *@Return java.util.Map<java.lang.String,java.lang.String>
    */
    Map<String,String> getPwd(boolean isUser,String key);

    /**
     *@Author Nethercat7
     *@Description 保存填写的就业情况信息
     *@param eStatus
     *@Return int
    */
    int saveEmploymentStatus(EStatus eStatus);

    /**
     *@Author Nethercat7
     *@Description 获取学生登入信息
     *@param student
     *@Return int
    */
    Student getStudentLoginInfo(Student student);

    /**
     *@Author Nethercat7
     *@Description 通过ID获取就业情况统计信息
     *@param id
     *@Return com.zfy.yuio.entity.EStatus
    */
    EStatus getEStatus(String id);

    /**
     *@Author Nethercat7
     *@Description 更新就业情信息
     *@param eStatus
     *@Return int
    */
    int updEStatus(EStatus eStatus);
}
