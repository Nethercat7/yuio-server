package com.zfy.yuio.dao;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Student;
import com.zfy.yuio.entity.Usr;
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

    int saveEmploymentStatus(EStatus eStatus);

    EStatus getEStatusById(String id);

    int updEStatus(EStatus eStatus);

    List<EStatus> getEStatus(int grade);

    List<EStatus> getEStatusByCollegeId(String id,int grade);

    List<Integer> getGrade();

    Usr getUsrLoginInfo(String account);

    Student getStudentLoginInfo(String code);
}
