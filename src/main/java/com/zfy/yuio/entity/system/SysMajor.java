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
 *@Description:专业实体
 *@Author:赵富源
 *@CreateDate:2021/4/9 16:34
*/
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysMajor {
    @JsonProperty("id")
    @ExcelIgnore
    private Long majorId;

    @JsonProperty("name")
    @ExcelProperty(index = 0,value = "专业名称")
    private String majorName;

    @JsonProperty("status")
    @ExcelProperty(index = 1,value = "状态",converter = UvslStatusConverter.class)
    private String majorStatus;

    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime majorCreateTime;

    @JsonProperty("remark")
    @ExcelProperty(index = 3,value = "备注")
    private String majorRemark;

    @JsonProperty("college_id")
    @ExcelIgnore
    private Long majorCollegeId;

    //非数据库字段
    @JsonProperty("college_name")
    @ExcelProperty(index = 2,value = "所属院系")
    private String collegeName;

    @ExcelIgnore
    private List<SysClass> children;

    @ExcelIgnore
    private boolean disabled;

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
