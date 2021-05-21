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

/**
 * @Description:专业实体
 * @Author:赵富源
 * @CreateDate:2021/4/9 16:34
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysClass {
    @ExcelProperty(value = "班级名称")
    @JsonProperty("name")
    private String className; //DB property

    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String classStatus; //DB property

    @JsonProperty("college_name")
    @ExcelProperty(value = "所属院系")
    private String classCollegeName;

    @JsonProperty("major_name")
    @ExcelProperty(value = "所属专业")
    private String classMajorName;

    @ExcelProperty(value = "所属年级")
    @JsonProperty("grade")
    private int classGrade; //DB property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String classRemark; //DB property

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("id")
    private Long classId; //DB property

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime classCreateTime; //DB property

    @ExcelIgnore
    @JsonProperty("major_id")
    private Long classMajorId; //DB property

    @ExcelIgnore
    private boolean disabled;

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(String classStatus) {
        this.classStatus = classStatus;
    }

    public LocalDateTime getClassCreateTime() {
        return classCreateTime;
    }

    public void setClassCreateTime(LocalDateTime classCreateTime) {
        this.classCreateTime = classCreateTime;
    }

    public String getClassRemark() {
        return classRemark;
    }

    public void setClassRemark(String classRemark) {
        this.classRemark = classRemark;
    }

    public Long getClassMajorId() {
        return classMajorId;
    }

    public void setClassMajorId(Long classMajorId) {
        this.classMajorId = classMajorId;
    }

    public int getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(int classGrade) {
        this.classGrade = classGrade;
    }

    public String getClassCollegeName() {
        return classCollegeName;
    }

    public void setClassCollegeName(String classCollegeName) {
        this.classCollegeName = classCollegeName;
    }

    public String getClassMajorName() {
        return classMajorName;
    }

    public void setClassMajorName(String classMajorName) {
        this.classMajorName = classMajorName;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
