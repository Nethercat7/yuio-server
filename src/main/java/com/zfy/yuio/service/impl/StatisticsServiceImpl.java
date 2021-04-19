package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.College;
import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.Student;
import com.zfy.yuio.service.StatisticsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:19
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private SysDao sysDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private ClsDao clsDao;

    @Autowired
    private StatisticsDao statisticsDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(7, 0);

    @Override
    public Map<String, Object> getTotalEmploymentInfo() {
        //获取所有的就业情况统计信息
        List<EStatus> eStatuses = sysDao.getEStatus();
        //计算总人数
        int totalPeople = studentDao.get().size();
        //计算各学院就业人数
        int employmentPeople = 0;
        for (EStatus es : eStatuses
        ) {
            if (es.getEsEmployment()) employmentPeople += 1;
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
    public Map<String, Object> getCollegeEmploymentInfo() {
        //获取所有院系
        List<College> collegeList = collegeDao.get();
        //定义柱状图的X和Y轴数据
        List<String> collegeNameList = new ArrayList<>();
        List<String> collegeEmploymentRate = new ArrayList<>();
        List<Integer> collegeEmploymentPeople = new ArrayList<>();
        List<Map<String, Object>> tableData = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.00");
        for (College c : collegeList
        ) {
            Map<String, Object> map = new HashMap<>();
            //获取该院系下的就业情况信息
            List<EStatus> eStatusList = sysDao.getEStatusByCollegeId(c.getCollegeId());
            //获取该院系下的所有学生信息
            List<Student> studentList = studentDao.getByCollegeId(c.getCollegeId());
            //计算该院系下的学生总量
            int totalPeople = studentList.size();
            //计算该院系下已就业的学生数量
            int employmentPeople = 0;
            for (EStatus e : eStatusList
            ) {
                if (!e.getEsEmployment()) employmentPeople += 1;
            }
            //计算未就业的学生总数量
            int unEmploymentPeople = totalPeople - employmentPeople;
            //计算就业率
            String employmentRate = df.format((float) (totalPeople - unEmploymentPeople) / (float) totalPeople * 100);
            //将数据添加进列表中
            collegeNameList.add(c.getCollegeName());
            collegeEmploymentRate.add(employmentRate);
            collegeEmploymentPeople.add(employmentPeople);
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

    @Override
    public List<Map<String, Object>> getEmploymentCityInfo() {
        return statisticsDao.getEmploymentCityInfo();
    }
}
