package com.zfy.yuio.entity;

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
    private String collegeId;
    @JsonProperty("name")
    private String collegeName;
    private String status;
    @JsonProperty("create_time")
    private LocalDateTime createTime;
    private String remark;
    private List<SysMajor> children;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<SysMajor> getChildren() {
        return children;
    }

    public void setChildren(List<SysMajor> children) {
        this.children = children;
    }
}
