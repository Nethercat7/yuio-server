package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysClassDao;
import com.zfy.yuio.dao.SysMajorDao;
import com.zfy.yuio.entity.SysClass;
import com.zfy.yuio.entity.SysMajor;
import com.zfy.yuio.service.ToolDataGeneratorService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolDataGeneratorServiceImpl implements ToolDataGeneratorService {
    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysClassDao classDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(13, 0);

    @Override
    public void generateClass(int num, int grade) {
        for (int i = 0; i < num; i++) {
            List<SysMajor> majors = majorDao.get();
            for (SysMajor major : majors
            ) {
                SysClass cls = setClassBaseInfo();
                cls.setClassName(major.getMajorName() + "的班级" + i);
                cls.setClassGrade(grade);
                cls.setClassMajorId(major.getMajorId());
                classDao.add(cls);
            }
        }
    }

    private SysClass setClassBaseInfo() {
        SysClass cls = new SysClass();
        cls.setClassId(snowflakeIdGeneratorUtil.nextId());
        cls.setClassStatus("0");
        cls.setClassRemark("自动生成的班级数据");
        return cls;
    }
}
