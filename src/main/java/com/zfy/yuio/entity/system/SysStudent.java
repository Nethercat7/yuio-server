package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("id")
    private Long studentId;

    @JsonProperty("name")
    private String studentName;

    @JsonProperty("code")
    private String studentCode;

    @JsonProperty("phone")
    private String studentPhone;

    @JsonProperty("status")
    private String studentStatus;

    @JsonProperty("grade")
    private int studentGrade;

    @JsonProperty("remark")
    private String studentRemark;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime studentCreateTime;

    @JsonProperty("class_id")
    private Long studentClassId;

    @JsonProperty("gender")
    private String studentGender;

    @JsonProperty("pwd")
    private String studentPwd;

    @JsonProperty("salt")
    private String studentSalt;

    //NOT DB property
    @JsonProperty("class")
    private SysClass studentClass;

    @JsonProperty("major")
    private SysMajor studentMajor;

    @JsonProperty("college")
    private SysCollege studentCollege;

    @JsonProperty("work")
    private SysWork studentWork;

    @JsonProperty("city")
    private SysCity studentCity;

    @JsonProperty("empl_info")
    private WriteEmplInfo studentEmplInfo;

    @JsonProperty("tutors_code")
    private List<String> studentTutorsCode;

    @JsonProperty("tutors_name")
    private List<String> studentTutorsName;

    @JsonProperty("empl_write")
    private String studentEmplWrite;

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
}
