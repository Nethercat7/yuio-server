package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.dao.StudentDao;
import com.zfy.yuio.entity.QueryParam;
import com.zfy.yuio.entity.Student;
import com.zfy.yuio.service.StudentService;
import com.zfy.yuio.utils.ShiroUtil;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
@Service
public class StudentServiceImpl implements StudentService {
    //随机盐的个数
    private static final int SALT = 7;
    //散列次数
    private static final int HASH = 1739;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private ClsDao classDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(3, 0);

    @Override
    public int add(Student student) {
        student.setStudentId(snowflakeIdGeneratorUtil.getId());
        //为当前学生设置院系、专业和班级
        setBaseInfo(student);
        //设置随机盐
        student.setStudentSalt(ShiroUtil.getSalt(SALT));
        //默认密码
        student.setStudentPwd(ShiroUtil.pwd2MD5("123456", student.getStudentSalt(), HASH));
        return studentDao.add(student);
    }

    @Override
    public List<Student> get() {
        List<Student> students = studentDao.get(0);
        for (Student s : students
        ) {
            List<String> container = new ArrayList<>();
            container.add(s.getStudentCollegeId());
            container.add(s.getStudentMajorId());
            container.add(s.getStudentClsId());
            s.setContainer(container);
        }
        return students;
    }

    @Override
    public Student getByCode(String code) {
        return studentDao.getByCode(code);
    }

    @Override
    public int del(String id) {
        return studentDao.del(id);
    }

    @Override
    public int upd(Student student) {
        //为当前学生设置院系、专业和班级
        setBaseInfo(student);
        return studentDao.upd(student);
    }

    @Override
    public List<Student> getWithEStatusInfo(QueryParam queryParam) {
        List<Student> students = studentDao.getWithEStatusInfo(queryParam);
        for (Student student : students
        ) {
            if (ObjectUtils.isEmpty(student.getEsId())) {
                student.setWrite(0);
            } else {
                student.setWrite(1);
            }
            //设置院系、专业和班级信息
            List<String> container = new ArrayList<>();
            container.add(student.getStudentCollegeId());
            container.add(student.getStudentMajorId());
            container.add(student.getStudentClsId());
            student.setContainer(container);
        }
        return students;
    }

    private void setBaseInfo(Student student) {
        String collegeId = student.getContainer().get(0);
        String majorId = student.getContainer().get(1);
        String classId = student.getContainer().get(2);
        student.setStudentCollegeId(collegeId);
        student.setStudentMajorId(majorId);
        student.setStudentClsId(classId);
    }
}
