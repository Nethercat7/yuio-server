package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:专业实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/9 16:34
 */
public class SysClass {
    @JsonProperty("id")
    private String classId;
    @JsonProperty("name")
    private String className;
    @JsonProperty("status")
    private String classStatus;
    @JsonProperty("create_time")
    private LocalDateTime classCreateTime;
    @JsonProperty("remark")
    private String classRemark;
    @JsonProperty("college_id")
    private String classCollegeId;
    @JsonProperty("college_name")
    private String classCollegeName;
    @JsonProperty("major_id")
    private String classMajorId;
    @JsonProperty("major_name")
    private String classMajorName;
    @JsonProperty("grade")
    private int classGrade;
    //非数据库字段
    private List<String> container;//用于装院系和专业ID配合前端的级联选择器

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public LocalDateTime getClassCreateTime() {
        return classCreateTime;
    }

    public void setClassCreateTime(LocalDateTime classCreateTime) {
        this.classCreateTime = classCreateTime;
    }

    public String getClassRemark() {
        return classRemark;
    }

    public void setClassRemark(String classRemark) {
        this.classRemark = classRemark;
    }

    public String getClassCollegeId() {
        return classCollegeId;
    }

    public void setClassCollegeId(String classCollegeId) {
        this.classCollegeId = classCollegeId;
    }

    public String getClassCollegeName() {
        return classCollegeName;
    }

    public void setClassCollegeName(String classCollegeName) {
        this.classCollegeName = classCollegeName;
    }

    public String getClassMajorId() {
        return classMajorId;
    }

    public void setClassMajorId(String classMajorId) {
        this.classMajorId = classMajorId;
    }

    public String getClassMajorName() {
        return classMajorName;
    }

    public void setClassMajorName(String classMajorName) {
        this.classMajorName = classMajorName;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }

    public List<String> getContainer() {
        return container;
    }

    public void setContainer(List<String> container) {
        this.container = container;
    }
}
