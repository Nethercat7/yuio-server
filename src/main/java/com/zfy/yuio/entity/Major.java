package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:专业实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/9 16:34
*/
public class Major {
    @JsonProperty("major_id")
    private String majorId;
    @JsonProperty("major_name")
    private String majorName;
    @JsonProperty("major_code")
    private String majorCode;
    @JsonProperty("major_status")
    private int majorStatus;
    @JsonProperty("major_create_time")
    private LocalDateTime majorCreateTime;
    @JsonProperty("major_description")
    private String majorDescription;
    @JsonProperty("major_college_id")
    private String majorCollegeId;
    @JsonProperty("major_college_name")
    private String majorCollegeName;

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

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public int getMajorStatus() {
        return majorStatus;
    }

    public void setMajorStatus(int majorStatus) {
        this.majorStatus = majorStatus;
    }

    public LocalDateTime getMajorCreateTime() {
        return majorCreateTime;
    }

    public void setMajorCreateTime(LocalDateTime majorCreateTime) {
        this.majorCreateTime = majorCreateTime;
    }

    public String getMajorDescription() {
        return majorDescription;
    }

    public void setMajorDescription(String majorDescription) {
        this.majorDescription = majorDescription;
    }

    public String getMajorCollegeId() {
        return majorCollegeId;
    }

    public void setMajorCollegeId(String majorCollegeId) {
        this.majorCollegeId = majorCollegeId;
    }

    public String getMajorCollegeName() {
        return majorCollegeName;
    }

    public void setMajorCollegeName(String majorCollegeName) {
        this.majorCollegeName = majorCollegeName;
    }
}
