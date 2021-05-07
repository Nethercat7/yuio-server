package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *@Description:接收前端查询字段
 *@Author:Nethercat7
 *@CreateDate:2021/4/21 23:35
*/
public class QueryParams {
    @JsonProperty("student_id")
    private Long studentId;
    @JsonProperty("college_id")
    private Long collegeId;
    @JsonProperty("major_id")
    private Long majorId;
    @JsonProperty("class_id")
    private Long classId;
    @JsonProperty("empl_status")
    private String emplStatus;
    @JsonProperty("empl_write")
    private String emplWrite;
    private int grade;
    private String name;
    private List<Integer> grades;
    private String gender;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplWrite() {
        return emplWrite;
    }

    public void setEmplWrite(String emplWrite) {
        this.emplWrite = emplWrite;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
