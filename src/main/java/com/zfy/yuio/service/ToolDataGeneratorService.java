package com.zfy.yuio.service;

import com.zfy.yuio.entity.SysCity;

import java.util.List;

public interface ToolDataGeneratorService {
    void generateClass(int num,int grade);

    void generateStudent(int num,int grade);

    void generateEmplInfo(int grade);

    void generateCity(List<SysCity> params);
}
