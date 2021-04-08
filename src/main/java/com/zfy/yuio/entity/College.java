package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:学院实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 18:18
*/
public class College {
    @JsonProperty("college_id")
    private String collegeId;
    @JsonProperty("college_name")
    private String collegeName;
    @JsonProperty("college_code")
    private String collegeCode;
    @JsonProperty("college_status")
    private int collegeStatus;
    @JsonProperty("college_create_time")
    private LocalDateTime collegeCreateTime;
    @JsonProperty("college_description")
    private String collegeDescription;

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

    public String getCollegeCode() {
        return collegeCode;
    }

    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
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
}
