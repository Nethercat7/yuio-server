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
    @JsonProperty("id")
    @ExcelIgnore
    private Long classId;

    @JsonProperty("name")
    @ExcelProperty(index = 0,value = "班级名称")
    private String className;

    @JsonProperty("status")
    @ExcelProperty(index = 1,value = "状态",converter = UvslStatusConverter.class)
    private String classStatus;

    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime classCreateTime;

    @JsonProperty("remark")
    @ExcelProperty(index = 5,value = "备注")
    private String classRemark;

    @JsonProperty("major_id")
    @ExcelIgnore
    private Long classMajorId;

    @JsonProperty("grade")
    @ExcelProperty(index = 4,value = "所属年级")
    private int classGrade;

    //非数据库字段
    @JsonProperty("college_name")
    @ExcelProperty(index = 2,value = "所属院系")
    private String classCollegeName;

    @JsonProperty("major_name")
    @ExcelProperty(index = 3,value = "所属专业")
    private String classMajorName;

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
}
