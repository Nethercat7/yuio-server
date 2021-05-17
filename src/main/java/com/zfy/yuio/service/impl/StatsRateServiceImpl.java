package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.dao.SysCollegeDao;
import com.zfy.yuio.dao.SysMajorDao;
import com.zfy.yuio.dao.SysStudentDao;
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
    public StatsEmplResult getEmplInfo(QueryParams params) {
        List<SysStudent> students = studentDao.get(params);
        int totalPeople = students.size();
        StatsEmplResult result = new StatsEmplResult();
        int unEmplPeople = 0;
        //计算未就业人数
        for (SysStudent student : students
        ) {
            if (ObjectUtils.isEmpty(student.getStudentEmplInfo().getEmplStatus()) || student.getStudentEmplInfo().getEmplStatus().equals("0")) {
                unEmplPeople += 1;
            }
        }
        //计算就业人数
        int emplPeople = totalPeople - unEmplPeople;
        //计算就业率
        DecimalFormat df = new DecimalFormat("0.00");
        String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
        //计算已经交了三方协议的人数
//        Map<String, List<SysStudent>> protocol = students.stream().filter(s -> s.getStudentEmplInfo().getEmplProtocol() != null)
//                .collect(Collectors.groupingBy(SysStudent::getStudentEmplInfo);
//        int protocolNumber = protocol.get("2").size();
        //如果院系或者专业的ID等于空的话，那么默认获取所有的院系就业率
        if (ObjectUtils.isEmpty(params.getOrgId())) {
            result.setResults(getCollegeEmplInfo(params.getGrade()));
            result.setLevel(1);
        } else {
            if (params.getType().equals("college")) {
                result.setResults(getMajorEmplInfo(params.getGrade(), params.getOrgId()));
                result.setLevel(2);
            } else {
                result.setResults(getClassEmplInfo(params.getGrade(), params.getOrgId()));
                result.setLevel(3);
            }
        }
        //设置数据
        result.setTotalPeople(totalPeople);
        result.setEmplPeople(emplPeople);
        result.setUnEmplPeople(unEmplPeople);
        result.setEmplRate(emplRate);
//        result.setProtocolNumber(protocolNumber);
        return result;
    }

    public List<StatsEmplResult> getCollegeEmplInfo(int grade) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysCollege> colleges = collegeDao.get();
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysCollege college : colleges
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setOrgId(college.getCollegeId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getStudentEmplInfo().getEmplStatus()) || student.getStudentEmplInfo().getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //计算已经交了三方协议的人数
//            Map<String, List<SysStudent>> protocol = students.stream().filter(s -> s.getStudentEmplInfo().getEmplProtocol() != null).collect(Collectors.groupingBy(SysStudent::getStudentEmplInfo().get));
//            int protocolNumber = protocol.get("2").size();
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setName(college.getCollegeName());
//            result.setProtocolNumber(protocolNumber);
            results.add(result);
        }
        return results;
    }

    public List<StatsEmplResult> getMajorEmplInfo(int grade, Long pid) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysMajor> majors = majorDao.getByPid(pid);
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysMajor major : majors
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setOrgId(major.getMajorId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getStudentEmplInfo().getEmplStatus()) || student.getStudentEmplInfo().getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //计算已经交了三方协议的人数
//            Map<String, List<SysStudent>> protocol = students.stream().filter(s -> s.getEmplProtocol() != null).collect(Collectors.groupingBy(SysStudent::getEmplProtocol));
//            int protocolNumber = protocol.get("2").size();
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setName(major.getMajorName());
//            result.setProtocolNumber(protocolNumber);
            results.add(result);
        }
        return results;
    }

    public List<StatsEmplResult> getClassEmplInfo(int grade, Long pid) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysClass> classes = classDao.getByPid(pid, grade);
        List<StatsEmplResult> results = new ArrayList<>();
        for (SysClass cls : classes
        ) {
            StatsEmplResult result = new StatsEmplResult();
            params.setOrgId(cls.getClassId());
            //获取该院系下的学生数量
            List<SysStudent> students = studentDao.get(params);
            int totalPeople = students.size();
            int unEmplPeople = 0;
            //计算未就业人数
            for (SysStudent student : students
            ) {
                if (ObjectUtils.isEmpty(student.getStudentEmplInfo().getEmplStatus()) || student.getStudentEmplInfo().getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业人数
            int emplPeople = totalPeople - unEmplPeople;
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String emplRate = df.format((float) (totalPeople - unEmplPeople) / (float) totalPeople * 100);
            //计算已经交了三方协议的人数
//            Map<String, List<SysStudent>> protocol = students.stream().filter(s -> s.getEmplProtocol() != null).collect(Collectors.groupingBy(SysStudent::getEmplProtocol));
//            int protocolNumber = protocol.get("2").size();
            //设置数据
            result.setTotalPeople(totalPeople);
            result.setEmplPeople(emplPeople);
            result.setUnEmplPeople(unEmplPeople);
            result.setEmplRate(emplRate);
            result.setName(cls.getClassName());
//            result.setProtocolNumber(protocolNumber);
            results.add(result);
        }
        return results;
    }
}
