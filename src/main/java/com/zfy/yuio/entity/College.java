package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:学院实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 18:18
*/
public class College {
    @JsonProperty("id")
    private String collegeId;
    @JsonProperty("name")
    private String collegeName;
    @JsonProperty("status")
    private int collegeStatus;
    @JsonProperty("create_time")
    private LocalDateTime collegeCreateTime;
    @JsonProperty("description")
    private String collegeDescription;

    private List<Major> children;

    public String getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(String collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getCollegeStatus() {
        return collegeStatus;
    }

    public void setCollegeStatus(int collegeStatus) {
        this.collegeStatus = collegeStatus;
    }

    public LocalDateTime getCollegeCreateTime() {
        return collegeCreateTime;
    }

    public void setCollegeCreateTime(LocalDateTime collegeCreateTime) {
        this.collegeCreateTime = collegeCreateTime;
    }

    public String getCollegeDescription() {
        return collegeDescription;
    }

    public void setCollegeDescription(String collegeDescription) {
        this.collegeDescription = collegeDescription;
    }

    public List<Major> getChildren() {
        return children;
    }

    public void setChildren(List<Major> children) {
        this.children = children;
    }
}
