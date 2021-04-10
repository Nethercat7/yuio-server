package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.ClsDao;
import com.zfy.yuio.dao.CollegeDao;
import com.zfy.yuio.dao.MajorDao;
import com.zfy.yuio.dao.StudentDao;
import com.zfy.yuio.entity.Student;
import com.zfy.yuio.service.StudentService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:08
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private CollegeDao collegeDao;

    @Autowired
    private MajorDao majorDao;

    @Autowired
    private ClsDao clsDao;

    SnowflakeIdGeneratorUntil snowflakeIdGeneratorUntil = new SnowflakeIdGeneratorUntil(3, 0);

    @Override
    public int add(Student student) {
        student.setStudentId(snowflakeIdGeneratorUntil.getId());
        //为当前学生设置院系、专业和班级
        setBaseInfo(student);
        return studentDao.add(student);
    }

    @Override
    public List<Student> get() {
        List<Student> students = studentDao.get();
        for (Student s : students
        ) {
            s.setStudentCollegeName(collegeDao.getNameById(s.getStudentCollegeId()));
            s.setStudentMajorName(majorDao.getNameById(s.getStudentMajorId()));
            s.setStudentClsName(clsDao.getNameById(s.getStudentClassId()));
            List<String> container = new ArrayList<>();
            container.add(s.getStudentCollegeId());
            container.add(s.getStudentMajorId());
            container.add(s.getStudentClassId());
            s.setContainer(container);
        }
        return students;
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

    private void setBaseInfo(Student student) {
        String collegeId = student.getContainer().get(0);
        String majorId = student.getContainer().get(1);
        String clsId = student.getContainer().get(2);
        student.setStudentCollegeId(collegeId);
        student.setStudentMajorId(majorId);
        student.setStudentClassId(clsId);
    }
}
