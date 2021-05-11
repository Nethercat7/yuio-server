package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.entity.system.SysMajor;

import java.util.List;

public class ExcelCollege {
    @JsonProperty("id")
    @ExcelIgnore
    private Long collegeId;

    @JsonProperty("name")
    @ExcelProperty( "院系名称")
    private String collegeName;

    @JsonProperty("status")
    @ExcelProperty("院系状态")
    private String collegeStatus;

    @JsonProperty("remark")
    @ExcelProperty("备注")
    private String collegeRemark;

    @ExcelIgnore
    private List<SysMajor> children;  //非数据库字段

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
