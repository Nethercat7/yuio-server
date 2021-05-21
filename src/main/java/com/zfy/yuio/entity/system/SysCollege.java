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
    @ExcelProperty(value = "院系名称")
    @JsonProperty("name")
    private String collegeName; //DB property

    @ExcelProperty(value = "院系状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String collegeStatus; //DB property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String collegeRemark; //DB property

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime collegeCreateTime; //DB property

    @ExcelIgnore
    @JsonProperty("id")
    private Long collegeId; //DB property

    @ExcelIgnore
    private List<SysMajor> children;

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
