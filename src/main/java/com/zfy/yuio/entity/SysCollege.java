package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:学院实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 18:18
*/
public class SysCollege {
    @JsonProperty("id")
    private Long collegeId;
    @JsonProperty("name")
    private String collegeName;
    @JsonProperty("status")
    private String collegeStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime collegeCreateTime;
    @JsonProperty("remark")
    private String collegeRemark;
    //非数据库字段
    private List<SysMajor> children;

    public Long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Long collegeId) {
        this.collegeId = collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCollegeStatus() {
        return collegeStatus;
    }

    public void setCollegeStatus(String collegeStatus) {
        this.collegeStatus = collegeStatus;
    }

    public LocalDateTime getCollegeCreateTime() {
        return collegeCreateTime;
    }

    public void setCollegeCreateTime(LocalDateTime collegeCreateTime) {
        this.collegeCreateTime = collegeCreateTime;
    }

    public String getCollegeRemark() {
        return collegeRemark;
    }

    public void setCollegeRemark(String collegeRemark) {
        this.collegeRemark = collegeRemark;
    }

    public List<SysMajor> getChildren() {
        return children;
    }

    public void setChildren(List<SysMajor> children) {
        this.children = children;
    }
}
