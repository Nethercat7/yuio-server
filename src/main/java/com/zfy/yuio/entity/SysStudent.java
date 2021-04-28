package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:学生实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 23:14
*/
public class SysStudent {
    @JsonProperty("id")
    private String studentId;
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
    @JsonProperty("college_id")
    private String studentCollegeId;
    @JsonProperty("major_id")
    private String studentMajorId;
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
    @JsonProperty("protocol")
    private int emplProtocol;
    @JsonProperty("company")
    private String emplCompany;
    @JsonProperty("work_city")
    private String emplWorkCity;
    @JsonProperty("work_type")
    private String emplWorkType;
    @JsonProperty("empl_status")
    private String emplStatus;
    @JsonProperty("plan")
    private String emplPlan;
    @JsonProperty("intention_city")
    private String emplIntentionCity;
    @JsonProperty("intention_work")
    private String emplIntentionWork;
    @JsonProperty("empl_id")
    private String emplId;
    private List<String> container;
    private String write;//是否填写就业信息

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
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

    public String getStudentCollegeId() {
        return studentCollegeId;
    }

    public void setStudentCollegeId(String studentCollegeId) {
        this.studentCollegeId = studentCollegeId;
    }

    public String getStudentMajorId() {
        return studentMajorId;
    }

    public void setStudentMajorId(String studentMajorId) {
        this.studentMajorId = studentMajorId;
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

    public int getEmplProtocol() {
        return emplProtocol;
    }

    public void setEmplProtocol(int emplProtocol) {
        this.emplProtocol = emplProtocol;
    }

    public String getEmplCompany() {
        return emplCompany;
    }

    public void setEmplCompany(String emplCompany) {
        this.emplCompany = emplCompany;
    }

    public String getEmplWorkCity() {
        return emplWorkCity;
    }

    public void setEmplWorkCity(String emplWorkCity) {
        this.emplWorkCity = emplWorkCity;
    }

    public String getEmplWorkType() {
        return emplWorkType;
    }

    public void setEmplWorkType(String emplWorkType) {
        this.emplWorkType = emplWorkType;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplPlan() {
        return emplPlan;
    }

    public void setEmplPlan(String emplPlan) {
        this.emplPlan = emplPlan;
    }

    public String getEmplIntentionCity() {
        return emplIntentionCity;
    }

    public void setEmplIntentionCity(String emplIntentionCity) {
        this.emplIntentionCity = emplIntentionCity;
    }

    public String getEmplIntentionWork() {
        return emplIntentionWork;
    }

    public void setEmplIntentionWork(String emplIntentionWork) {
        this.emplIntentionWork = emplIntentionWork;
    }

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public List<String> getContainer() {
        return container;
    }

    public void setContainer(List<String> container) {
        this.container = container;
    }

    public String getWrite() {
        return write;
    }

    public void setWrite(String write) {
        this.write = write;
    }
}
