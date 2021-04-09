package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:学生实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 23:14
*/
public class Student {
    @JsonProperty("student_id")
    private String studentId;
    @JsonProperty("student_name")
    private String studentName;
    @JsonProperty("student_code")
    private String studentCode;
    @JsonProperty("student_phone")
    private String studentPhone;
    @JsonProperty("student_status")
    private int studentStatus;
    @JsonProperty("student_grade")
    private int studentGrade;
    @JsonProperty("student_description")
    private String studentDescription;
    @JsonProperty("student_create_time")
    private LocalDateTime studentCreateTime;
    @JsonProperty("student_college_id")
    private String studentCollegeId;
    @JsonProperty("student_major_id")
    private String studentMajorId;
    @JsonProperty("student_class_id")
    private String studentClassId;

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

    public int getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(int studentStatus) {
        this.studentStatus = studentStatus;
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
}
