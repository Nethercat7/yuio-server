package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelStudent {
    @ExcelProperty("姓名")
    private String studentName;

    @ExcelProperty("学号")
    private String studentCode;

    @ExcelProperty("电话号码")
    private String studentPhone;

    @ExcelProperty("年级")
    private int studentGrade;

    @ExcelProperty("备注")
    private String studentRemark;

    @ExcelProperty("性别")
    private String studentGender;

    @ExcelProperty("班级")
    private String className;

    @ExcelProperty("状态")
    private String studentStatus;

    @ExcelIgnore
    private Long studentClassId;

    @ExcelIgnore
    private Long studentId;

    @ExcelIgnore
    private String studentPwd;

    @ExcelIgnore
    private String studentSalt;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getStudentSalt() {
        return studentSalt;
    }

    public void setStudentSalt(String studentSalt) {
        this.studentSalt = studentSalt;
    }
}
