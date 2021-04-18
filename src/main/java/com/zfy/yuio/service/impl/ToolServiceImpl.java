package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.dao.StudentDao;
import com.zfy.yuio.entity.Cls;
import com.zfy.yuio.entity.College;
import com.zfy.yuio.entity.Major;
import com.zfy.yuio.entity.Student;
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
            generatorClsBaseInfo(college.getCollegeId(), major.getMajorId(), major.getMajorName() + "的班级" + random.nextInt(100));
        }
        return 0;
    }

    @Override
    public int randomStudent(int num) {
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
            //根据专业Id获取旗下所有的班级
            List<Cls> clsList = clsDao.getByPid(major.getMajorId());
            //随机获取一个班级
            Cls cls = clsList.get(random.nextInt(clsList.size()));
            //生成学生
            generatorStudentBaseInfo(college.getCollegeId(),major.getMajorId(),cls.getClsId());
        }
        return 0;
    }

    private void generatorClsBaseInfo(String collegeId, String majorId, String clsName) {
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

    private void generatorStudentBaseInfo(String collegeId, String majorId, String clsId) {
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
}
