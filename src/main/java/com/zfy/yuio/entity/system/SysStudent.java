package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.*;
import com.zfy.yuio.entity.write.WriteEmplInfo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:学生实体类
 * @Author:赵富源
 * @CreateDate:2021/4/9 23:14
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysStudent {
    @ExcelProperty(value = "姓名")
    @JsonProperty("name")
    private String studentName; //DB Property

    @ExcelProperty(value = "学号")
    @JsonProperty("code")
    private String studentCode; //DB Property

    @ExcelProperty(value = "性别",converter = GenderConverter.class)
    @JsonProperty("gender")
    private String studentGender; //DB Property

    @ExcelProperty(value = "手机号码")
    @JsonProperty("phone")
    private String studentPhone; //DB Property

    @ExcelProperty(value = "院系",converter = CollegeConverter.class)
    @JsonProperty("college")
    private SysCollege studentCollege;

    @ExcelProperty(value = "专业",converter = MajorConverter.class)
    @JsonProperty("major")
    private SysMajor studentMajor;

    @ExcelProperty(value = "年级")
    @JsonProperty("grade")
    private int studentGrade; //DB Property

    @ExcelProperty(value = "班级",converter = ClassConverter.class)
    @JsonProperty("class")
    private SysClass studentClass;

    @ExcelProperty(value = "指导老师",converter = TutorsConverter.class)
    @JsonProperty("tutors_name")
    private List<String> studentTutorsName;

    @ExcelProperty(value = "就业信息填写",converter = EmplWriteConverter.class)
    @JsonProperty("empl_write")
    private String studentEmplWrite;

    @ExcelProperty(value = "是否就业",converter = EmplStatusConverter.class)
    private String studentEmplStatus;

    @ExcelProperty(value = "就业单位")
    private String studentEmplConpany;

    @ExcelProperty(value = "协议状况",converter = ProtocolConverter.class)
    private String studentEmplProtocol;

    @ExcelProperty(value = "预计签约时间")
    private String studentEmplDate;

    @ExcelProperty(value = "是否下载就业APP",converter = EmplAppConverter.class)
    private String studentEmplApp;

    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String studentStatus; //DB Property

    @ExcelProperty(value = "备注")
    private String studentEmplRemark;

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("remark")
    private String studentRemark; //DB Property

    @ExcelIgnore
    @JsonProperty("id")
    private Long studentId; //DB Property

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime studentCreateTime; //DB Property

    @ExcelIgnore
    @JsonProperty("class_id")
    private Long studentClassId; //DB Property

    @ExcelIgnore
    @JsonProperty("pwd")
    private String studentPwd; //DB Property

    @ExcelIgnore
    @JsonProperty("salt")
    private String studentSalt; //DB Property

    @ExcelIgnore
    @JsonProperty("work")
    private SysWork studentWork;

    @ExcelIgnore
    @JsonProperty("city")
    private SysCity studentCity;

    @ExcelIgnore
    @JsonProperty("empl_info")
    private WriteEmplInfo studentEmplInfo;

    @ExcelIgnore
    @JsonProperty("tutors_code")
    private List<String> studentTutorsCode;



    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

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

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
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

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
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

    public SysClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(SysClass studentClass) {
        this.studentClass = studentClass;
    }

    public SysMajor getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(SysMajor studentMajor) {
        this.studentMajor = studentMajor;
    }

    public SysCollege getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(SysCollege studentCollege) {
        this.studentCollege = studentCollege;
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

    public String getStudentEmplDate() {
        return studentEmplDate;
    }

    public void setStudentEmplDate(String studentEmplDate) {
        this.studentEmplDate = studentEmplDate;
    }

    public String getStudentEmplApp() {
        return studentEmplApp;
    }

    public void setStudentEmplApp(String studentEmplApp) {
        this.studentEmplApp = studentEmplApp;
    }

    public String getStudentEmplRemark() {
        return studentEmplRemark;
    }

    public void setStudentEmplRemark(String studentEmplRemark) {
        this.studentEmplRemark = studentEmplRemark;
    }
}
