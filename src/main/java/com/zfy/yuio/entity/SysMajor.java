package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long majorId;
    @JsonProperty("name")
    private String majorName;
    @JsonProperty("status")
    private String majorStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime majorCreateTime;
    @JsonProperty("remark")
    private String majorRemark;
    @JsonProperty("college_id")
    private Long majorCollegeId;

    //非数据库字段
    @JsonProperty("college_name")
    private String collegeName;
    private List<SysClass> children;

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
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

    public Long getMajorCollegeId() {
        return majorCollegeId;
    }

    public void setMajorCollegeId(Long majorCollegeId) {
        this.majorCollegeId = majorCollegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public List<SysClass> getChildren() {
        return children;
    }

    public void setChildren(List<SysClass> children) {
        this.children = children;
    }
}
