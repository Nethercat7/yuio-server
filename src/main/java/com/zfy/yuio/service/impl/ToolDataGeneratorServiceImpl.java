package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.*;
import com.zfy.yuio.entity.system.*;
import com.zfy.yuio.entity.write.WriteEmplInfo;
import com.zfy.yuio.service.ToolDataGeneratorService;
import com.zfy.yuio.utils.RandomInfoGenerateUntil;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ToolDataGeneratorServiceImpl implements ToolDataGeneratorService {
    @Autowired
    private SysMajorDao majorDao;

    @Autowired
    private SysClassDao classDao;

    @Autowired
    private SysStudentDao studentDao;

    @Autowired
    private WriteEmplDao emplDao;

    @Autowired
    private SysCityDao cityDao;

    @Autowired
    private SysWorkDao workDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(13, 0);

    @Override
    public void generateClass(int num, int grade) {
        for (int i = 0; i < num; i++) {
            List<SysMajor> majors = majorDao.get();
            for (SysMajor major : majors
            ) {
                SysClass cls = setClassBaseInfo();
                cls.setClassName(grade + major.getMajorName() + "的班级" + i);
                cls.setClassGrade(grade);
                cls.setClassMajorId(major.getMajorId());
                classDao.add(cls);
            }
        }
    }

    @Override
    public void generateStudent(int num, int grade) {
        for (int i = 0; i < num; i++) {
            List<SysClass> classes = classDao.getByGrade(grade);
            for (SysClass cls : classes
            ) {
                SysStudent student = setStudentBaseInfo();
                student.setStudentGrade(grade);
                student.setStudentClassId(cls.getClassId());
                studentDao.add(student);
                studentDao.addRole(student.getStudentId(),506870876013088768L);
            }
        }
    }

    @Override
    public void generateEmplInfo(int grade) {
        QueryParams params = new QueryParams();
        params.setGrade(grade);
        List<SysStudent> students = studentDao.get(params);
        Random random = new Random();
        //获取城市
        List<SysCity> cities = cityDao.getWithoutProvinces();
        //获取岗位
        List<SysWork> works = workDao.getWithoutIndustry();
        for (SysStudent student : students
        ) {
            //就业信息生成
            WriteEmplInfo info = new WriteEmplInfo();
            info.setEmplId(snowflakeIdGeneratorUtil.nextId());
            //随机生成就业和未就业
            if (RandomInfoGenerateUntil.randomBoolean()) {
                info.setEmplStatus("1");
                info.setEmplCompany(student.getStudentName() + "的就业单位");
                info.setEmplProtocol(String.valueOf(random.nextInt(3)));
                info.setEmplCityId(cities.get(random.nextInt(cities.size())).getCityId());
                info.setEmplWorkId(works.get(random.nextInt(works.size())).getWorkId());
            } else {
                info.setEmplStatus("0");
                info.setEmplPlan(String.valueOf(random.nextInt(12)));
            }
            info.setEmplStudentId(student.getStudentId());
            emplDao.add(info);
            //就业意向生成,随机选择3个城市和2个岗位
            int n = 0;
            int x = 0;
            List<Long> temp = new ArrayList<>();
            while (n < 3) {
                Long cityId = cities.get(random.nextInt(cities.size())).getCityId();
                if (!temp.contains(cityId)) {
                    emplDao.addIntentionCities(student.getStudentId(), cityId);
                    temp.add(cityId);
                    n++;
                }
            }
            while (x < 2) {
                Long workId = works.get(random.nextInt(works.size())).getWorkId();
                if (!temp.contains(workId)) {
                    emplDao.addIntentionWorks(student.getStudentId(), workId);
                    temp.add(workId);
                    x++;
                }
            }
        }
    }

    @Override
    public void generateCity(List<SysCity> params) {
        for (SysCity c : params
        ) {
            //设置直辖市
            if (c.getCityName().equals("北京市") || c.getCityName().equals("上海市") || c.getCityName().equals("天津市") || c.getCityName().equals("重庆市")) {
                c.setCityDirect(1);
            } else {
                c.setCityDirect(0);
            }

            if (!ObjectUtils.isEmpty(c.getChildren())) {
                c.setCityPid(0L);
                cityDao.add(c);
                addChildren(c.getChildren(), c.getCityId(), c.getCityLevel());
            } else {
                c.setCityPid(0L);
                cityDao.add(c);
            }
        }
    }

    private void addChildren(List<SysCity> params, Long pid, int level) {
        for (SysCity c : params
        ) {
            c.setCityPid(pid);
            c.setCityDirect(0);
            c.setCityLevel(level + 1);
            cityDao.add(c);
            if (!ObjectUtils.isEmpty(c.getChildren())) {
                addChildren(c.getChildren(), c.getCityId(), c.getCityLevel());
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

    private SysStudent setStudentBaseInfo() {
        SysStudent student = new SysStudent();
        student.setStudentId(snowflakeIdGeneratorUtil.nextId());
        student.setStudentCode(snowflakeIdGeneratorUtil.getId());
        student.setStudentGender(RandomInfoGenerateUntil.randomGender());
        student.setStudentPhone(RandomInfoGenerateUntil.randomChinaPhoneNumber());
        student.setStudentStatus("0");
        student.setStudentRemark("自动生成的学生数据");
        student.setStudentSalt(ShiroUtil.getSalt(7));
        student.setStudentPwd(ShiroUtil.pwd2MD5("123456", student.getStudentSalt(), 1739));
        student.setStudentName(RandomInfoGenerateUntil.randomChineseName(student.getStudentGender()));
        return student;
    }
}
