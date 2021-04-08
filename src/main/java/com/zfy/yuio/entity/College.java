package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
