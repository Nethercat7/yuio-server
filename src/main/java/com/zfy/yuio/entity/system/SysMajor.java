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
 * @Description:专业实体
 * @Author:赵富源
 * @CreateDate:2021/4/9 16:34
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysMajor {
    @ExcelProperty(value = "专业名称")
    @JsonProperty("name")
    private String majorName; //DB Property

    @ExcelProperty(value = "所属院系")
    @JsonProperty("college_name")
    private String collegeName;

    @ExcelProperty(value = "状态", converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String majorStatus; //DB Property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String majorRemark; //DB Property

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("college_id")
    private Long majorCollegeId; //DB Property

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime majorCreateTime; //DB Property

    @ExcelIgnore
    @JsonProperty("id")
    private Long majorId; //DB Property

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
