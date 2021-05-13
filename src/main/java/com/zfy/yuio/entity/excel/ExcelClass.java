package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description:专业实体
 * @Author:赵富源
 * @CreateDate:2021/4/9 16:34
 */
public class ExcelClass {
    @JsonProperty("id")
    @ExcelIgnore
    private Long classId;

    @JsonProperty("name")
    @ExcelProperty("班级名称")
    private String className;

    @JsonProperty("status")
    @ExcelProperty("状态")
    private String classStatus;

    @JsonProperty("remark")
    @ExcelProperty("备注")
    private String classRemark;

    @JsonProperty("major_id")
    @ExcelIgnore
    private Long classMajorId;

    @JsonProperty("grade")
    @ExcelProperty("所属年级")
    private int classGrade;

    @JsonProperty("major_name")
    @ExcelProperty("所属专业")
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

    public String getClassMajorName() {
        return classMajorName;
    }

    public void setClassMajorName(String classMajorName) {
        this.classMajorName = classMajorName;
    }
}
