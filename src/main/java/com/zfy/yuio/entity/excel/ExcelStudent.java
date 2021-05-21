package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.zfy.yuio.converter.*;
import com.zfy.yuio.entity.system.*;
import com.zfy.yuio.entity.write.WriteEmplInfo;

import java.time.LocalDateTime;
import java.util.List;

@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class ExcelStudent{

    @ExcelProperty(value = "姓名")
    private String studentName;

    @ExcelProperty(value = "学号")
    private String studentCode;

    @ExcelProperty(value = "性别",converter = GenderConverter.class)
    private String studentGender;

    @ExcelProperty(value = "手机号码")
    private String studentPhone;

    @ExcelProperty(value = "院系",converter = CollegeConverter.class)
    private SysCollege studentCollege;

    @ExcelProperty(value = "专业",converter = MajorConverter.class)
    private SysMajor studentMajor;

    @ExcelProperty(value = "年级")
    private int studentGrade;

    @ExcelProperty(value = "班级",converter = ClassConverter.class)
    private SysClass studentClass;

    @ExcelProperty(value = "指导老师",converter = TutorsConverter.class)
    private List<String> studentTutorsName;

    @ExcelProperty(value = "就业信息填写",converter = EmplWriteConverter.class)
    private String studentEmplWrite;

    @ExcelProperty(value = "是否就业",converter = EmplStatusConverter.class)
    private String studentEmplStatus;

    @ExcelProperty(value = "就业单位")
    private String studentEmplConpany;

    @ExcelProperty(value = "协议状况",converter = ProtocolConverter.class)
    private String studentEmplProtocol;

    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    private String studentStatus;

    @ExcelProperty(value = "备注")
    private String studentRemark;

    //Ignore properties
    @ExcelIgnore
    private Long studentId;

    @ExcelIgnore
    private LocalDateTime studentCreateTime;

    @ExcelIgnore
    private Long studentClassId;

    @ExcelIgnore
    private String studentPwd;

    @ExcelIgnore
    private String studentSalt;

    @ExcelIgnore
    private SysWork studentWork;

    @ExcelIgnore
    private SysCity studentCity;

    @ExcelIgnore
    private WriteEmplInfo studentEmplInfo;

    @ExcelIgnore
    private List<String> studentTutorsCode;

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

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public SysCollege getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(SysCollege studentCollege) {
        this.studentCollege = studentCollege;
    }

    public SysMajor getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(SysMajor studentMajor) {
        this.studentMajor = studentMajor;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public SysClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(SysClass studentClass) {
        this.studentClass = studentClass;
    }

    public List<String> getStudentTutorsName() {
        return studentTutorsName;
    }

    public void setStudentTutorsName(List<String> studentTutorsName) {
        this.studentTutorsName = studentTutorsName;
    }

    public String getStudentEmplWrite() {
        return studentEmplWrite;
    }

    public void setStudentEmplWrite(String studentEmplWrite) {
        this.studentEmplWrite = studentEmplWrite;
    }

    public String getStudentEmplStatus() {
        return studentEmplStatus;
    }

    public void setStudentEmplStatus(String studentEmplStatus) {
        this.studentEmplStatus = studentEmplStatus;
    }

    public String getStudentEmplConpany() {
        return studentEmplConpany;
    }

    public void setStudentEmplConpany(String studentEmplConpany) {
        this.studentEmplConpany = studentEmplConpany;
    }

    public String getStudentEmplProtocol() {
        return studentEmplProtocol;
    }

    public void setStudentEmplProtocol(String studentEmplProtocol) {
        this.studentEmplProtocol = studentEmplProtocol;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public LocalDateTime getStudentCreateTime() {
        return studentCreateTime;
    }

    public void setStudentCreateTime(LocalDateTime studentCreateTime) {
        this.studentCreateTime = studentCreateTime;
    }

    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
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

    public SysWork getStudentWork() {
        return studentWork;
    }

    public void setStudentWork(SysWork studentWork) {
        this.studentWork = studentWork;
    }

    public SysCity getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(SysCity studentCity) {
        this.studentCity = studentCity;
    }

    public WriteEmplInfo getStudentEmplInfo() {
        return studentEmplInfo;
    }

    public void setStudentEmplInfo(WriteEmplInfo studentEmplInfo) {
        this.studentEmplInfo = studentEmplInfo;
    }

    public List<String> getStudentTutorsCode() {
        return studentTutorsCode;
    }

    public void setStudentTutorsCode(List<String> studentTutorsCode) {
        this.studentTutorsCode = studentTutorsCode;
    }
}
