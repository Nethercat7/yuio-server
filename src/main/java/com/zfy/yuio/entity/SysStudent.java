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
    private Long studentClassId;
    @JsonProperty("gender")
    private String studentGender;
    @JsonProperty("pwd")
    private String studentPwd;
    @JsonProperty("salt")
    private String studentSalt;

    //非数据库字段
    @JsonProperty("college_name")
    private String collegeName;
    @JsonProperty("major_name")
    private String majorName;
    @JsonProperty("class_name")
    private String className;
    @JsonProperty("empl_status")
    private String emplStatus;
    @JsonProperty("empl_company")
    private String emplCompany;
    @JsonProperty("empl_protocol")
    private String emplProtocol;
    @JsonProperty("empl_plan")
    private String emplPlan;
    @JsonProperty("empl_city_id")
    private Long emplCityId;
    @JsonProperty("empl_work_id")
    private Long emplWorkId;
    @JsonProperty("empl_city_name")
    private String emplCityName;
    @JsonProperty("empl_work_name")
    private String emplWorkName;

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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplCompany() {
        return emplCompany;
    }

    public void setEmplCompany(String emplCompany) {
        this.emplCompany = emplCompany;
    }

    public String getEmplProtocol() {
        return emplProtocol;
    }

    public void setEmplProtocol(String emplProtocol) {
        this.emplProtocol = emplProtocol;
    }

    public String getEmplPlan() {
        return emplPlan;
    }

    public void setEmplPlan(String emplPlan) {
        this.emplPlan = emplPlan;
    }

    public Long getEmplCityId() {
        return emplCityId;
    }

    public void setEmplCityId(Long emplCityId) {
        this.emplCityId = emplCityId;
    }

    public Long getEmplWorkId() {
        return emplWorkId;
    }

    public void setEmplWorkId(Long emplWorkId) {
        this.emplWorkId = emplWorkId;
    }

    public String getEmplCityName() {
        return emplCityName;
    }

    public void setEmplCityName(String emplCityName) {
        this.emplCityName = emplCityName;
    }

    public String getEmplWorkName() {
        return emplWorkName;
    }

    public void setEmplWorkName(String emplWorkName) {
        this.emplWorkName = emplWorkName;
    }

    @Override
    public String toString() {
        return "SysStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentCode='" + studentCode + '\'' +
                ", studentPhone='" + studentPhone + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                ", studentGrade=" + studentGrade +
                ", studentRemark='" + studentRemark + '\'' +
                ", studentCreateTime=" + studentCreateTime +
                ", studentClassId='" + studentClassId + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", studentPwd='" + studentPwd + '\'' +
                ", studentSalt='" + studentSalt + '\'' +
                ", collegeName='" + collegeName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", className='" + className + '\'' +
                ", emplStatus='" + emplStatus + '\'' +
                ", emplCompany='" + emplCompany + '\'' +
                ", emplProtocol='" + emplProtocol + '\'' +
                ", emplPlan='" + emplPlan + '\'' +
                ", emplCityId='" + emplCityId + '\'' +
                ", emplWorkId='" + emplWorkId + '\'' +
                ", emplCityName='" + emplCityName + '\'' +
                ", emplWorkName='" + emplWorkName + '\'' +
                '}';
    }
}
