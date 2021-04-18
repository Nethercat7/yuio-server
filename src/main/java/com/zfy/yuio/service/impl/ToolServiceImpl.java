package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.*;
import com.zfy.yuio.entity.*;
import com.zfy.yuio.service.ToolService;
import com.zfy.yuio.utils.RandomInfoGenerateUntil;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(8, 0);

    @Override
    public int randomCls(int num) {
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            //获取所有院系
            List<College> collegeList = collegeDao.get();
            //随机获取一个院系
            College college = collegeList.get(random.nextInt(collegeList.size()));
            //根据院系ID获取旗下的所有专业
            List<Major> majorList = majorDao.getByPid(college.getCollegeId());
            //随机获取一个专业
            Major major = majorList.get(random.nextInt(majorList.size()));
            //生成班级
            generateCls(college.getCollegeId(), major.getMajorId(), major.getMajorName() + "的班级" + random.nextInt(100));
        }
        return 0;
    }

    @Override
    public int randomStudent(int num) {
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
            List<Cls> clsList = clsDao.getByPid(major.getMajorId());
            //随机获取一个班级
            Cls cls = clsList.get(random.nextInt(clsList.size()));
            //生成学生
            generateStudent(college.getCollegeId(), major.getMajorId(), cls.getClsId());
        }
        return 0;
    }

    @Override
    public int randomEStatus(int num) {
        Random random = new Random();
        //获取学生信息
        List<Student> studentList=studentDao.get();
        String[] cities={"北京","上海","广东","深圳","南宁","柳州","杭州","长沙","武汉","桂林"};
        String[] works={"后台开发","前端开发","电商运营","大数据挖掘","食品安全","产品经理","游戏推广","车辆运营","动画设计","投资顾问"};
        for (int i = 0; i < studentList.size(); i++) {
            String studentId=studentList.get(i).getStudentId();
            String clsId=studentList.get(i).getStudentClassId();
            String majorId=studentList.get(i).getStudentMajorId();
            String collegeId=studentList.get(i).getStudentCollegeId();
            boolean employment=RandomInfoGenerateUntil.randomBoolean();
            String wCity=cities[random.nextInt(cities.length)];
            String wType=works[random.nextInt(works.length)];
            int status=random.nextInt(3);
            int plan=random.nextInt(13);
            String iCity=cities[random.nextInt(cities.length)];
            String iType=works[random.nextInt(works.length)];
            generateEStatus(studentId,clsId,majorId,collegeId,employment,wCity,wType,status,plan,iCity,iType);
        }
        return 0;
    }

    private void generateCls(String collegeId, String majorId, String clsName) {
        Cls cls = new Cls();
        cls.setClsId(snowflakeIdGeneratorUtil.getId());
        cls.setClsName(clsName);
        cls.setClsStatus(0);
        cls.setClsGrade(2017);
        cls.setClsDescription("自动生成的班级数据");
        cls.setClsCollegeId(collegeId);
        cls.setClsMajorId(majorId);
        clsDao.add(cls);
    }

    private void generateStudent(String collegeId, String majorId, String clsId) {
        Student student = new Student();
        student.setStudentId(snowflakeIdGeneratorUtil.getId());
        student.setStudentCode(snowflakeIdGeneratorUtil.getId());
        student.setStudentGender(RandomInfoGenerateUntil.randomGender());
        student.setStudentPhone(RandomInfoGenerateUntil.randomChinaPhoneNumber());
        student.setStudentDescription("Test Data");
        student.setStudentSalt(ShiroUtil.getSalt(7));
        student.setStudentPwd(ShiroUtil.pwd2MD5("123456", student.getStudentSalt(), 1739));
        student.setStudentName(RandomInfoGenerateUntil.randomChineseName(student.getStudentGender()));
        student.setStudentGrade(2017);
        student.setStudentCollegeId(collegeId);
        student.setStudentMajorId(majorId);
        student.setStudentClassId(clsId);
        studentDao.add(student);
    }

    private void generateEStatus(String studentId,String clsId,String majorId,String collegeId,boolean employment,String wCity,String wType,int status,int plan,String iCity,String iType) {
        EStatus eStatus=new EStatus();
        eStatus.setEsId(snowflakeIdGeneratorUtil.getId());
        eStatus.setEsStudentId(studentId);
        eStatus.setEsClsId(clsId);
        eStatus.setEsMajorId(majorId);
        eStatus.setEsCollegeId(collegeId);
        eStatus.setEsGrade(2017);
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
}
