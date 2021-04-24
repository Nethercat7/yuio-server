package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:专业实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 16:34
*/
public class SysMajor {
    @JsonProperty("id")
    private String majorId;
    @JsonProperty("name")
    private String majorName;
    @JsonProperty("status")
    private String majorStatus;
    @JsonProperty("create_time")
    private LocalDateTime majorCreateTime;
    @JsonProperty("description")
    private String majorRemark;
    @JsonProperty("college_id")
    private String majorCollegeId;

    //非数据库字段
    @JsonProperty("college_name")
    private String collegeName;
    private List<Cls> children;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorStatus() {
        return majorStatus;
    }

    public void setMajorStatus(String majorStatus) {
        this.majorStatus = majorStatus;
    }

    public LocalDateTime getMajorCreateTime() {
        return majorCreateTime;
    }

    public void setMajorCreateTime(LocalDateTime majorCreateTime) {
        this.majorCreateTime = majorCreateTime;
    }

    public String getMajorRemark() {
        return majorRemark;
    }

    public void setMajorRemark(String majorRemark) {
        this.majorRemark = majorRemark;
    }

    public String getMajorCollegeId() {
        return majorCollegeId;
    }

    public void setMajorCollegeId(String majorCollegeId) {
        this.majorCollegeId = majorCollegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<Cls> getChildren() {
        return children;
    }

    public void setChildren(List<Cls> children) {
        this.children = children;
    }
}
