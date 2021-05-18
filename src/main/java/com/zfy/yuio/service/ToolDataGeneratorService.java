package com.zfy.yuio.service;

import com.zfy.yuio.entity.system.SysCity;

import java.util.List;

public interface ToolDataGeneratorService {
    void generateClass(int num,int grade);

    void generateStudent(int num,int grade);

    void generateEmplInfo(int grade);

    void generateCity(List<SysCity> params);

    void generateUser(int num);
}
