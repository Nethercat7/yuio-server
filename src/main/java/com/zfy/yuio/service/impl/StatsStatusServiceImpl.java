package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.StatsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:19
 */
@Service
public class StatsStatusServiceImpl implements StatsStatusService {
    @Autowired
    private SysStudentDao studentDao;

    @Override
    public List<StatsEmplResult> getEmplCityInfo(QueryParams params) {
        params.setEmplStatus("1");
        List<SysStudent> students = studentDao.get(params);
        //按照城市分组
        Map<String, List<SysStudent>> cities = students.stream().collect(Collectors.groupingBy(SysStudent::getEmplCityName));
        Set<String> keys=cities.keySet();
        List<StatsEmplResult> results=new ArrayList<>();
        for (String key:keys
             ) {
            List<SysStudent> studentList=cities.get(key);
            StatsEmplResult result=new StatsEmplResult();
            //计算和添加数据
            int totalPeople=studentList.size();
            result.setTotalPeople(totalPeople);
            result.setCityName(key);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<StatsEmplResult> getEmplWorkInfo(QueryParams params) {
        params.setEmplStatus("1");
        List<SysStudent> students = studentDao.get(params);
        //按照岗位分组
        Map<String, List<SysStudent>> works = students.stream().collect(Collectors.groupingBy(SysStudent::getEmplWorkName));
        Set<String> keys=works.keySet();
        List<StatsEmplResult> results=new ArrayList<>();
        for (String key:keys
        ) {
            List<SysStudent> studentList=works.get(key);
            StatsEmplResult result=new StatsEmplResult();
            //计算和添加数据
            int totalPeople=studentList.size();
            result.setTotalPeople(totalPeople);
            result.setWorkName(key);
            results.add(result);
        }
        return results;
    }

    @Override
    public List<StatsEmplResult> getStudentPlan(QueryParams params) {
        params.setEmplStatus("0");
        List<SysStudent> students=studentDao.get(params);
        //按照计划分组
        Map<String,List<SysStudent>> plans=students.stream().collect(Collectors.groupingBy(SysStudent::getEmplPlan));
        Set<String> keys=plans.keySet();
        List<StatsEmplResult> results=new ArrayList<>();
        for (String key:keys
        ) {
            List<SysStudent> studentList=plans.get(key);
            StatsEmplResult result=new StatsEmplResult();
            //计算和添加数据
            int totalPeople=studentList.size();
            result.setTotalPeople(totalPeople);
            result.setPlan(key);
            results.add(result);
        }
        return results;
    }
}
