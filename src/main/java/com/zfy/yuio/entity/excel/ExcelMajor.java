package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description:专业实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/9 16:34
 */
public class ExcelMajor {
    @JsonProperty("id")
    @ExcelIgnore
    private Long majorId;

    @JsonProperty("name")
    @ExcelProperty("专业名称")
    private String majorName;

    @JsonProperty("status")
    @ExcelProperty("状态")
    private String majorStatus;

    @JsonProperty("remark")
    @ExcelProperty("备注")
    private String majorRemark;

    @JsonProperty("college_id")
    @ExcelIgnore
    private Long majorCollegeId;

    //非数据库字段
    @JsonProperty("college_name")
    @ExcelProperty("所属院系")
    private String collegeName;

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
}
