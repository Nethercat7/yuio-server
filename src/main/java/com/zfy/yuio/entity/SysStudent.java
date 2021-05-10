package com.zfy.yuio.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.*;

import java.time.LocalDateTime;

/**
 * @Description:学生实体类
 * @Author:Nethercat7
 * @CreateDate:2021/4/9 23:14
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysStudent {
    @JsonProperty("id")
    @ExcelIgnore
    private Long studentId;

    @JsonProperty("name")
    @ExcelProperty(index = 0, value = "姓名")
    private String studentName;

    @JsonProperty("code")
    @ExcelProperty(index = 1, value = "学号")
    private String studentCode;

    @JsonProperty("phone")
    @ExcelProperty(index = 2, value = "电话号码")
    private String studentPhone;

    @JsonProperty("status")
    @ExcelProperty(index = 15, value = "状态",converter = UvslStatusConverter.class)
    private String studentStatus;

    @JsonProperty("grade")
    @ExcelProperty(index = 4, value = "年级")
    private int studentGrade;

    @JsonProperty("remark")
    @ExcelProperty(index = 16, value = "备注")
    private String studentRemark;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime studentCreateTime;

    @JsonProperty("class_id")
    @ExcelIgnore
    private Long studentClassId;

    @JsonProperty("gender")
    @ExcelProperty(index = 3, value = "性别", converter = GenderConverter.class)
    private String studentGender;

    @JsonProperty("pwd")
    @ExcelIgnore
    private String studentPwd;

    @JsonProperty("salt")
    @ExcelIgnore
    private String studentSalt;

    //非数据库字段
    @JsonProperty("college_name")
    @ExcelProperty(index = 5, value = "院系")
    private String collegeName;

    @JsonProperty("major_name")
    @ExcelProperty(index = 6, value = "专业")
    private String majorName;

    @JsonProperty("class_name")
    @ExcelProperty(index = 7, value = "班级")
    private String className;

    @JsonProperty("empl_status")
    @ExcelProperty(index = 9, value = "是否就业",converter = EmplStatusConverter.class)
    private String emplStatus;

    @JsonProperty("empl_company")
    @ExcelProperty(index = 10, value = "单位名称")
    private String emplCompany;

    @JsonProperty("empl_protocol")
    @ExcelProperty(index = 13, value = "协议状况",converter = ProtocolConverter.class)
    private String emplProtocol;

    @JsonProperty("empl_plan")
    @ExcelProperty(index = 14, value = "接下来的打算",converter = PlanConverter.class)
    private String emplPlan;

    @JsonProperty("empl_city_id")
    @ExcelIgnore
    private Long emplCityId;

    @JsonProperty("empl_work_id")
    @ExcelIgnore
    private Long emplWorkId;

    @JsonProperty("empl_city_name")
    @ExcelProperty(index = 11, value = "就业所在城市")
    private String emplCityName;

    @JsonProperty("empl_work_name")
    @ExcelProperty(index = 12, value = "工作岗位类型")
    private String emplWorkName;

    @JsonProperty("empl_write")
    @ExcelProperty(index = 8, value = "就业情况填写",converter = EmplWriteConverter.class)
    private String emplWrite;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(int studentGrade) {
        this.studentGrade = studentGrade;
    }

    public String getStudentRemark() {
        return studentRemark;
    }

    public void setStudentRemark(String studentRemark) {
        this.studentRemark = studentRemark;
    }

    public LocalDateTime getStudentCreateTime() {
        return studentCreateTime;
    }

    public void setStudentCreateTime(LocalDateTime studentCreateTime) {
        this.studentCreateTime = studentCreateTime;
    }

    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd;
    }

    public String getStudentSalt() {
        return studentSalt;
    }

    public void setStudentSalt(String studentSalt) {
        this.studentSalt = studentSalt;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplCompany() {
        return emplCompany;
    }

    public void setEmplCompany(String emplCompany) {
        this.emplCompany = emplCompany;
    }

    public String getEmplProtocol() {
        return emplProtocol;
    }

    public void setEmplProtocol(String emplProtocol) {
        this.emplProtocol = emplProtocol;
    }

    public String getEmplPlan() {
        return emplPlan;
    }

    public void setEmplPlan(String emplPlan) {
        this.emplPlan = emplPlan;
    }

    public Long getEmplCityId() {
        return emplCityId;
    }

    public void setEmplCityId(Long emplCityId) {
        this.emplCityId = emplCityId;
    }

    public Long getEmplWorkId() {
        return emplWorkId;
    }

    public void setEmplWorkId(Long emplWorkId) {
        this.emplWorkId = emplWorkId;
    }

    public String getEmplCityName() {
        return emplCityName;
    }

    public void setEmplCityName(String emplCityName) {
        this.emplCityName = emplCityName;
    }

    public String getEmplWorkName() {
        return emplWorkName;
    }

    public void setEmplWorkName(String emplWorkName) {
        this.emplWorkName = emplWorkName;
    }

    public String getEmplWrite() {
        return emplWrite;
    }

    public void setEmplWrite(String emplWrite) {
        this.emplWrite = emplWrite;
    }
}
