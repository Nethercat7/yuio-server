package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.service.StatsRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class StatsRateServiceImpl implements StatsRateService {
    @Autowired
    private SysStudentDao studentDao;

    @Override
    public StatsEmplResult getEmplInfo(int grade) {
        QueryParams params=new QueryParams();
        params.setGrade(grade);
        List<SysStudent> students=studentDao.get(params);
        StatsEmplResult result=new StatsEmplResult();
        int totalPeople=students.size();
        int unEmplPeople=0;
        //计算未就业人数
        for (SysStudent student:students
             ) {
            if(student.getEmplStatus().equals("0")|| ObjectUtils.isEmpty(student.getEmplStatus())){
                unEmplPeople+=1;
            }
        }
        //计算就业人数
        int emplPeople=totalPeople-unEmplPeople;
        //计算就业率
        DecimalFormat df=new DecimalFormat("0.00");
        String emplRate=df.format((float)(totalPeople-unEmplPeople)/(float)totalPeople*100);
        //设置数据
        result.setTotalPeople(totalPeople);
        result.setEmplPeople(emplPeople);
        result.setUnEmplPeople(unEmplPeople);
        result.setEmplRate(emplRate);
        return result;
    }
}
