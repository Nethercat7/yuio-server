package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:学院实体类
 * @Author:赵富源
 * @CreateDate:2021/4/8 18:18
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysCollege {
    @JsonProperty("id")
    @ExcelIgnore
    private Long collegeId;

    @JsonProperty("name")
    @ExcelProperty(index = 0,value = "院系名称")
    private String collegeName;

    @JsonProperty("status")
    @ExcelProperty(index = 1,value = "院系状态",converter = UvslStatusConverter.class)
    private String collegeStatus;

    @JsonProperty("remark")
    @ExcelProperty(index = 2,value = "备注")
    private String collegeRemark;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime collegeCreateTime;

    @ExcelIgnore
    private List<SysMajor> children;  //非数据库字段

    @ExcelIgnore
    private boolean disabled;

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
