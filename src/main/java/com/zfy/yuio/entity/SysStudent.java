package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:学生实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 23:14
*/
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime studentCreateTime;
    @JsonProperty("class_id")
    private String studentClassId;
    @JsonProperty("gender")
    private String studentGender;
    @JsonProperty("pwd")
    private String studentPwd;
    @JsonProperty("salt")
    private String studentSalt;

    //非数据库字段
    @JsonProperty("college_name")
    private String studentCollegeName;
    @JsonProperty("major_name")
    private String studentMajorName;
    @JsonProperty("class_name")
    private String studentClassName;
    @JsonProperty("empl_info")
    private WriteEmplInfo studentEmplInfo;

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

    public String getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(String studentClassId) {
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

    public String getStudentCollegeName() {
        return studentCollegeName;
    }

    public void setStudentCollegeName(String studentCollegeName) {
        this.studentCollegeName = studentCollegeName;
    }

    public String getStudentMajorName() {
        return studentMajorName;
    }

    public void setStudentMajorName(String studentMajorName) {
        this.studentMajorName = studentMajorName;
    }

    public String getStudentClassName() {
        return studentClassName;
    }

    public void setStudentClassName(String studentClassName) {
        this.studentClassName = studentClassName;
    }

    public WriteEmplInfo getStudentEmplInfo() {
        return studentEmplInfo;
    }

    public void setStudentEmplInfo(WriteEmplInfo studentEmplInfo) {
        this.studentEmplInfo = studentEmplInfo;
    }
}
