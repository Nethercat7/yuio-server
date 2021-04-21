package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:学生实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 23:14
*/
public class Student {
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
    @JsonProperty("description")
    private String studentDescription;
    @JsonProperty("create_time")
    private LocalDateTime studentCreateTime;
    @JsonProperty("college_id")
    private String studentCollegeId;
    @JsonProperty("major_id")
    private String studentMajorId;
    @JsonProperty("class_id")
    private String studentClassId;
    @JsonProperty("college_name")
    private String studentCollegeName;
    @JsonProperty("major_name")
    private String studentMajorName;
    @JsonProperty("cls_name")
    private String studentClsName;
    @JsonProperty("gender")
    private String studentGender;
    @JsonProperty("pwd")
    private String studentPwd;
    @JsonProperty("salt")
    private String studentSalt;

    //EStatus
    @JsonProperty("employment")
    private int esEmployment;
    @JsonProperty("company")
    private String esCompany;
    @JsonProperty("work_city")
    private String esWorkCity;
    @JsonProperty("work_type")
    private String esWorkType;
    @JsonProperty("es_status")
    private String esStatus;
    @JsonProperty("plan")
    private String esPlan;
    @JsonProperty("intention_city")
    private String esIntentionCity;
    @JsonProperty("intention_work")
    private String esIntentionWork;
    @JsonProperty("es_id")
    private String esId;

    private List<String> container;
    private int write;//是否填写就业信息

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

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentDescription() {
        return studentDescription;
    }

    public void setStudentDescription(String studentDescription) {
        this.studentDescription = studentDescription;
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

    public String getStudentClsName() {
        return studentClsName;
    }

    public void setStudentClsName(String studentClsName) {
        this.studentClsName = studentClsName;
    }

    public List<String> getContainer() {
        return container;
    }

    public void setContainer(List<String> container) {
        this.container = container;
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

    public int getEsEmployment() {
        return esEmployment;
    }

    public void setEsEmployment(int esEmployment) {
        this.esEmployment = esEmployment;
    }

    public String getEsCompany() {
        return esCompany;
    }

    public void setEsCompany(String esCompany) {
        this.esCompany = esCompany;
    }

    public String getEsWorkCity() {
        return esWorkCity;
    }

    public void setEsWorkCity(String esWorkCity) {
        this.esWorkCity = esWorkCity;
    }

    public String getEsWorkType() {
        return esWorkType;
    }

    public void setEsWorkType(String esWorkType) {
        this.esWorkType = esWorkType;
    }

    public String getEsIntentionCity() {
        return esIntentionCity;
    }

    public void setEsIntentionCity(String esIntentionCity) {
        this.esIntentionCity = esIntentionCity;
    }

    public String getEsIntentionWork() {
        return esIntentionWork;
    }

    public void setEsIntentionWork(String esIntentionWork) {
        this.esIntentionWork = esIntentionWork;
    }

    public int getWrite() {
        return write;
    }

    public void setWrite(int write) {
        this.write = write;
    }

    public String getEsId() {
        return esId;
    }

    public void setEsId(String esId) {
        this.esId = esId;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getEsStatus() {
        return esStatus;
    }

    public void setEsStatus(String esStatus) {
        this.esStatus = esStatus;
    }

    public String getEsPlan() {
        return esPlan;
    }

    public void setEsPlan(String esPlan) {
        this.esPlan = esPlan;
    }
}
