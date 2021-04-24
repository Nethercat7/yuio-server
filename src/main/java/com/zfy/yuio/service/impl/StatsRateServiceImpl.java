package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.StatsRateDao;
import com.zfy.yuio.dao.SysCollegeDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.StatsRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatsRateServiceImpl implements StatsRateService {
    @Autowired
    private StatsRateDao statsRateDao;
    @Autowired
    private SysStudentDao sysStudentDao;
    @Autowired
    private SysCollegeDao sysCollegeDao;

    @Override
    public  Map<String, Object> getEmplInfo(int grade) {
        //获取所有的就业情况统计信息
        List<StatsEmplInfo> info = statsRateDao.getEmplInfo(grade);
        //计算总人数
        int totalPeople = sysStudentDao.get(grade).size();
        //计算各学院就业人数
        int employmentPeople = 0;
        for (StatsEmplInfo i : info
        ) {
            if (i.getEmplStatus().equals("1")) employmentPeople += 1;
        }
        //计算各学院未就业人数
        int unEmploymentPeople = totalPeople - employmentPeople;
        //计算总就业率
        DecimalFormat df = new DecimalFormat("0.00");
        String employmentRate = df.format((float) (totalPeople - unEmploymentPeople) / (float) totalPeople * 100);
        Map<String, Object> map = new HashMap<>();
        map.put("total_people", totalPeople);
        map.put("employment_people", employmentPeople);
        map.put("unemployment_people", unEmploymentPeople);
        map.put("employment_rate", employmentRate);
        return map;
    }

    @Override
    public Map<String, Object> getCollegeEmplInfo(int grade) {
        //获取所有院系
        List<SysCollege> collegeList = sysCollegeDao.get();
        //定义柱状图的X和Y轴数据
        List<String> collegeNameList = new ArrayList<>();
        List<String> collegeEmploymentRate = new ArrayList<>();
        List<Integer> collegeEmploymentPeople = new ArrayList<>();
        List<Map<String, Object>> tableData = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        for (SysCollege c : collegeList
        ) {
            Map<String, Object> map = new HashMap<>();
            //获取该院系下的就业情况信息
            List<StatsEmplInfo> eStatusList = statsRateDao.getCollegeEmplInfo(c.getCollegeId(), grade);
            //获取该院系下的所有学生信息
            List<SysStudent> studentList = sysStudentDao.getByCollegeId(c.getCollegeId(), grade);
            //计算该院系下的学生总量
            int totalPeople = studentList.size();
            //计算该院系下已就业的学生数量
            int employmentPeople = 0;
            for (StatsEmplInfo e : eStatusList
            ) {
                if (e.getEmplStatus().equals("1")) employmentPeople += 1;
            }
            //计算未就业的学生总数量
            int unEmploymentPeople = totalPeople - employmentPeople;
            //计算就业率
            String employmentRate = df.format((float) (totalPeople - unEmploymentPeople) / (float) totalPeople * 100);
            //将数据添加进列表中
            collegeNameList.add(c.getCollegeName());
            collegeEmploymentRate.add(employmentRate);
            collegeEmploymentPeople.add(employmentPeople);
            map.put("college_id", c.getCollegeId());
            map.put("college_name", c.getCollegeName());
            map.put("total_people", totalPeople);
            map.put("employment_people", employmentPeople);
            map.put("unemployment_people", unEmploymentPeople);
            map.put("employment_rate", employmentRate);
            tableData.add(map);
        }
        //将数据添加进MAP中返回
        Map<String, Object> map = new HashMap<>();
        map.put("college_name", collegeNameList);
        map.put("college_employment_rate", collegeEmploymentRate);
        map.put("college_employment_people", collegeEmploymentPeople);
        map.put("data", tableData);
        return map;
    }
}
