package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:专业实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/9 16:34
 */
public class Cls {
    @JsonProperty("id")
    private String clsId;
    @JsonProperty("name")
    private String clsName;
    @JsonProperty("status")
    private String clsStatus;
    @JsonProperty("create_time")
    private LocalDateTime clsCreateTime;
    @JsonProperty("description")
    private String clsDescription;
    @JsonProperty("college_id")
    private String clsCollegeId;
    @JsonProperty("college_name")
    private String clsCollegeName;
    @JsonProperty("major_id")
    private String clsMajorId;
    @JsonProperty("major_name")
    private String clsMajorName;
    @JsonProperty("grade")
    private int clsGrade;

    private List<String> container;//用于装院系和专业ID配合前端的级联选择器

    public String getClsId() {
        return clsId;
    }

    public void setClsId(String clsId) {
        this.clsId = clsId;
    }

    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getClsStatus() {
        return clsStatus;
    }

    public void setClsStatus(String clsStatus) {
        this.clsStatus = clsStatus;
    }

    public LocalDateTime getClsCreateTime() {
        return clsCreateTime;
    }

    public void setClsCreateTime(LocalDateTime clsCreateTime) {
        this.clsCreateTime = clsCreateTime;
    }

    public String getClsDescription() {
        return clsDescription;
    }

    public void setClsDescription(String clsDescription) {
        this.clsDescription = clsDescription;
    }

    public String getClsCollegeId() {
        return clsCollegeId;
    }

    public void setClsCollegeId(String clsCollegeId) {
        this.clsCollegeId = clsCollegeId;
    }

    public String getClsCollegeName() {
        return clsCollegeName;
    }

    public void setClsCollegeName(String clsCollegeName) {
        this.clsCollegeName = clsCollegeName;
    }

    public String getClsMajorId() {
        return clsMajorId;
    }

    public void setClsMajorId(String clsMajorId) {
        this.clsMajorId = clsMajorId;
    }

    public String getClsMajorName() {
        return clsMajorName;
    }

    public void setClsMajorName(String clsMajorName) {
        this.clsMajorName = clsMajorName;
    }

    public List<String> getContainer() {
        return container;
    }

    public void setContainer(List<String> container) {
        this.container = container;
    }

    public int getClsGrade() {
        return clsGrade;
    }

    public void setClsGrade(int clsGrade) {
        this.clsGrade = clsGrade;
    }
}
