package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import com.zfy.yuio.entity.system.SysClass;
import com.zfy.yuio.entity.system.SysCollege;
import com.zfy.yuio.entity.system.SysMajor;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.service.StatsRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:就业率模块
 * @Author:赵富源
 * @CreateDate:2021/4/19 17:19
 */
@Service
public class StatsRateServiceImpl implements StatsRateService {
    @Autowired
    private SysStudentDao studentDao;

    @Autowired
    private SysCollegeDao collegeDao;

    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysClassDao classDao;

    @Override
    public StatsEmplResult getEmplInfo(int grade) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysStudent> students = studentDao.get(params);
        StatsEmplResult result = new StatsEmplResult();
        int totalPeople = students.size();
        int unEmplPeople = 0;
        //计算未就业人数
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getEmplStatus()) || student.getEmplStatus().equals("0")) {
                unEmplPeople += 1;
            }
        }
        //计算就业人数
        int emplPeople = totalPeople - unEmplPeople;
        //计算就业率
        DecimalFormat df = new DecimalFormat("0.00");
        String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
        //设置数据
        result.setTotalPeople(totalPeople);
        result.setEmplPeople(emplPeople);
        result.setUnEmplPeople(unEmplPeople);
        result.setEmplRate(emplRate);
        return result;
    }

    @Override
    public List<StatsEmplResult> getCollegeEmplInfo(int grade) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysCollege> colleges = collegeDao.get();
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysCollege college : colleges
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setCollegeId(college.getCollegeId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getEmplStatus()) || student.getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setCollegeName(college.getCollegeName());
            results.add(result);
        }
        return results;
    }

    @Override
    public StatsEmplResult getEmplInfoBy(QueryParams params) {
        List<SysStudent> students = studentDao.get(params);
        int totalPeople = students.size();
        StatsEmplResult result = new StatsEmplResult();
        int unEmplPeople = 0;
        //计算未就业人数
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getEmplStatus()) || student.getEmplStatus().equals("0")) {
                unEmplPeople += 1;
            }
        }
        //计算就业人数
        int emplPeople = totalPeople - unEmplPeople;
        //计算就业率
        DecimalFormat df = new DecimalFormat("0.00");
        String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
        //如果院系或者专业的ID等于空的话，那么默认获取所有的院系就业率
        if (ObjectUtils.isEmpty(params.getId())) {
            result.setResults(getCollegeEmplInfo(params.getGrade()));
        } else {
            if (params.getType().equals("college")) {
                result.setResults(getMajorEmplInfo(params.getGrade(),params.getId()));
            } else {
                result.setResults(getClassEmplInfo(params.getGrade(),params.getId()));
            }
        }
        //设置数据
        result.setTotalPeople(totalPeople);
        result.setEmplPeople(emplPeople);
        result.setUnEmplPeople(unEmplPeople);
        result.setEmplRate(emplRate);
        return result;
    }

    public List<StatsEmplResult> getMajorEmplInfo(int grade,Long pid) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysMajor> majors = majorDao.getByPid(pid);
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysMajor major : majors
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setMajorId(major.getMajorId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getEmplStatus()) || student.getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setCollegeName(major.getMajorName());
            results.add(result);
        }
        return results;
    }

    public List<StatsEmplResult> getClassEmplInfo(int grade,Long pid) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysClass> classes = classDao.getByPid(pid,grade);
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysClass cls : classes
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setClassId(cls.getClassId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getEmplStatus()) || student.getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setCollegeName(cls.getClassName());
            results.add(result);
        }
        return results;
    }
}
