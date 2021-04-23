package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.*;
import com.zfy.yuio.service.ToolService;
import com.zfy.yuio.utils.RandomInfoGenerateUntil;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:系统工具
 * @Author:Nethercat7
 * @CreateDate:2021/4/18 18:16
 */
@Service
public class ToolServiceImpl implements ToolService {
    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private ClsDao clsDao;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private SysDao sysDao;

    @Autowired
    private CityDao cityDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(8, 0);

    @Override
    public int randomCls(int num, int grade) {
        List<College> colleges = collegeDao.get();
        for (College college : colleges
        ) {
            List<Major> majors = majorDao.getByPid(college.getCollegeId());
            for (Major major : majors
            ) {
                //为每个专业设置3个班级
                for (int i = 0; i < 3; i++) {
                    generateCls(college.getCollegeId(), major.getMajorId(), grade + "级" + major.getMajorName() + "的班级" + i + 1, grade);
                }
            }
        }
        return 0;
    }

    @Override
    public int randomStudent(int num, int grade) {
        Random random = new Random();
        //获取所有院系
        List<College> collegeList = collegeDao.get();
        for (int i = 0; i < num; i++) {
            //随机获取一个院系
            College college = collegeList.get(random.nextInt(collegeList.size()));
            //根据院系ID获取旗下的所有专业
            List<Major> majorList = majorDao.getByPid(college.getCollegeId());
            //随机获取一个专业
            Major major = majorList.get(random.nextInt(majorList.size()));
            //根据专业Id获取旗下所有的班级
            List<Cls> clsList = clsDao.getByPid(major.getMajorId(), grade);
            //随机获取一个班级
            Cls cls = clsList.get(random.nextInt(clsList.size()));
            //生成学生
            generateStudent(college.getCollegeId(), major.getMajorId(), cls.getClsId(), grade);
        }
        return 0;
    }

    @Override
    public int randomEStatus(int num, int grade) {
        Random random = new Random();
        //获取学生信息
        List<Student> studentList = studentDao.get(grade);
        //获取城市
        String[] cities = {"504637296813838336", "504637298156015616", "504637302073495555", "504637301532430336", "504637297333932034", "504637298118266883", "504637298759995392", "504637300655820803", "504637298197958657"};
        String[] works = {"504656117557665792", "504656171731296256", "504656362937032704", "504656429500637184", "504656462774050816", "504656499461627904", "504656798368702464", "504656835991609344", "504656536077901824", "504656392129388544"};
        for (int i = 0; i < num; i++) {
            String studentId = studentList.get(i).getStudentId();
            String clsId = studentList.get(i).getStudentClsId();
            String majorId = studentList.get(i).getStudentMajorId();
            String collegeId = studentList.get(i).getStudentCollegeId();
            String employment = String.valueOf(random.nextInt(2));
            String wCity = cities[random.nextInt(cities.length)];
            String wType = works[random.nextInt(works.length)];
            String status = String.valueOf(random.nextInt(3));
            String plan = String.valueOf(random.nextInt(13));
            String iCity = cities[random.nextInt(cities.length)];
            String iType = works[random.nextInt(works.length)];
            generateEStatus(studentId, clsId, majorId, collegeId, employment, wCity, wType, status, plan, iCity, iType, grade);
        }
        return 0;
    }

    private void generateCls(String collegeId, String majorId, String clsName, int grade) {
        Cls cls = new Cls();
        cls.setClsId(snowflakeIdGeneratorUtil.getId());
        cls.setClsName(clsName);
        cls.setClsStatus("0");
        cls.setClsGrade(grade);
        cls.setClsDescription("自动生成的班级数据");
        cls.setClsCollegeId(collegeId);
        cls.setClsMajorId(majorId);
        clsDao.add(cls);
    }

    private void generateStudent(String collegeId, String majorId, String clsId, int grade) {
        Student student = new Student();
        student.setStudentId(snowflakeIdGeneratorUtil.getId());
        student.setStudentCode(snowflakeIdGeneratorUtil.getId());
        student.setStudentGender(RandomInfoGenerateUntil.randomGender());
        student.setStudentPhone(RandomInfoGenerateUntil.randomChinaPhoneNumber());
        student.setStudentDescription("自动生成的学生数据");
        student.setStudentSalt(ShiroUtil.getSalt(7));
        student.setStudentPwd(ShiroUtil.pwd2MD5("123456", student.getStudentSalt(), 1739));
        student.setStudentName(RandomInfoGenerateUntil.randomChineseName(Integer.parseInt(student.getStudentGender())));
        student.setStudentGrade(grade);
        student.setStudentCollegeId(collegeId);
        student.setStudentMajorId(majorId);
        student.setStudentClsId(clsId);
        studentDao.add(student);
    }

    private void generateEStatus(String studentId, String clsId, String majorId, String collegeId, String employment, String wCity, String wType, String status, String plan, String iCity, String iType, int grade) {
        EStatus eStatus = new EStatus();
        eStatus.setEsId(snowflakeIdGeneratorUtil.getId());
        eStatus.setEsStudentId(studentId);
        eStatus.setEsClsId(clsId);
        eStatus.setEsMajorId(majorId);
        eStatus.setEsCollegeId(collegeId);
        eStatus.setEsGrade(grade);
        eStatus.setEsEmployment(employment);
        eStatus.setEsCompany("自动生成的公司名称");
        eStatus.setEsWorkCity(wCity);
        eStatus.setEsWorkType(wType);
        eStatus.setEsStatus(status);
        eStatus.setEsPlan(plan);
        eStatus.setEsIntentionCity(iCity);
        eStatus.setEsIntentionWork(iType);
        sysDao.saveEmploymentStatus(eStatus);
    }

    private List<City> getCities() {
        List<City> cities = cityDao.get();
        List<City> cityList = new ArrayList<>();
        for (City c : cities
        ) {
            if (ObjectUtils.isEmpty(cityDao.getByPid(c.getCityId()))) cityList.add(c);
        }
        return cityList;
    }
}
