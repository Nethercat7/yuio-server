package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.CmpRateDao;
import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.entity.WriteEmplResult;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.CmpRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:就业率对比
 * @Author:Nethercat7
 * @CreateDate:2021/4/27 21:36
 */
@Service
public class CmpRateServiceImpl implements CmpRateService {
    @Autowired
    private CmpRateDao rateDao;

    @Autowired
    private SysStudentDao studentDao;

    @Override
    public WriteEmplResult get(QueryParams params) {
        WriteEmplResult result = new WriteEmplResult();
        List<Integer> grades = new ArrayList<>();
        List<String> rates = new ArrayList<>();
        String type = null;
        for (Integer grade : params.getGrades()
        ) {
            //设置年级
            params.setGrade(grade);
            List<WriteEmplInfo> infos = rateDao.get(params);
            List<SysStudent> students = studentDao.get(params);
            //毕业生总人数
            int total = students.size();
            //未就业人数
            int unEmplPeople = 0;
            //筛选未就业人数
            for (WriteEmplInfo info : infos
            ) {
                if (info.getEmplStatus().equals("0")) {
                    unEmplPeople += 1;
                }
            }
            //计算就业率
            DecimalFormat df = new DecimalFormat("0.00");
            String rate = df.format((float) (total - unEmplPeople) / (float) total * 100);
            grades.add(grade);
            rates.add(rate);
            //添加主体的标题
            if (!ObjectUtils.isEmpty(params.getCollegeId()) && !ObjectUtils.isEmpty(params.getMajorId())) {
                type = students.get(0).getStudentMajorName();//因为所有的学生都是处于同一院系和班级下的所以index为0即可
            } else if (!ObjectUtils.isEmpty(params.getCollegeId())) {
                type = students.get(0).getStudentCollegeName();
            }
        }
        result.setGrades(grades);
        result.setRates(rates);
        //设置标题
        if (ObjectUtils.isEmpty(type)) {
            result.setType("总就业率");
        } else {
            result.setType(type);
        }
        return result;
    }
}
