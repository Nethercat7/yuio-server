package com.zfy.yuio.service;

/**
 *@Description:系统工具
 *@Author:Nethercat7
 *@CreateDate:2021/4/18 18:06
*/
public interface ToolService {
    /**
     *@Author Nethercat7
     *@Description 随机生成班级信息
     *@param num
     *@Return int
    */
    int randomCls(int num,int grade);

    /**
     *@Author Nethercat7
     *@Description 随机生成学生信息
     *@param num
     *@Return int
    */
    int randomStudent(int num,int grade);

    /**
     *@Author Nethercat7
     *@Description 随机生成就业情况信息
     *@param
     *@Return int
    */
    int randomEStatus(int num,int grade);
}

