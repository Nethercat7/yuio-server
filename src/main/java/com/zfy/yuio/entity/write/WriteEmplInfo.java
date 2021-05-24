package com.zfy.yuio.entity.write;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

/**
 * @Demplcription:就业信息统计表
 * @Author:赵富源
 * @CreateDate:2021/4/17 22:31
 */
public class WriteEmplInfo {
    @JsonProperty("id")
    private Long emplId;
    @JsonProperty("protocol")
    private String emplProtocol;
    @JsonProperty("company")
    private String emplCompany;
    @JsonProperty("status")
    private String emplStatus;
    @JsonProperty("plan")
    private String emplPlan;
    @JsonProperty("student_code")
    private String emplStudentCode;
    @JsonProperty("city_id")
    private Long emplCityId;
    @JsonProperty("work_id")
    private Long emplWorkId;
    @JsonProperty("protocol_file")
    private String emplProtocolFile;
    @JsonProperty("date")
    private LocalDate emplDate;
    @JsonProperty("app")
    private String emplApp;
    @JsonProperty("remark")
    private String emplRemark;
    //非数据库字段
    @JsonProperty("intention_cities")
    private List<Long> intentionCities;
    @JsonProperty("intention_works")
    private List<Long> intentionWorks;
    @JsonProperty("teacher_code")
    private List<String> teacherCode;

    public Long getEmplId() {
        return emplId;
    }

    public void setEmplId(Long emplId) {
        this.emplId = emplId;
    }

    public String getEmplProtocol() {
        return emplProtocol;
    }

    public void setEmplProtocol(String emplProtocol) {
        this.emplProtocol = emplProtocol;
    }

    public String getEmplCompany() {
        return emplCompany;
    }

    public void setEmplCompany(String emplCompany) {
        this.emplCompany = emplCompany;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplPlan() {
        return emplPlan;
    }

    public void setEmplPlan(String emplPlan) {
        this.emplPlan = emplPlan;
    }

    public String getEmplStudentCode() {
        return emplStudentCode;
    }

    public void setEmplStudentCode(String emplStudentCode) {
        this.emplStudentCode = emplStudentCode;
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

    public String getEmplProtocolFile() {
        return emplProtocolFile;
    }

    public void setEmplProtocolFile(String emplProtocolFile) {
        this.emplProtocolFile = emplProtocolFile;
    }

    public List<Long> getIntentionCities() {
        return intentionCities;
    }

    public void setIntentionCities(List<Long> intentionCities) {
        this.intentionCities = intentionCities;
    }

    public List<Long> getIntentionWorks() {
        return intentionWorks;
    }

    public void setIntentionWorks(List<Long> intentionWorks) {
        this.intentionWorks = intentionWorks;
    }

    public List<String> getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(List<String> teacherCode) {
        this.teacherCode = teacherCode;
    }

    public LocalDate getEmplDate() {
        return emplDate;
    }

    public void setEmplDate(LocalDate emplDate) {
        this.emplDate = emplDate;
    }

    public String getEmplApp() {
        return emplApp;
    }

    public void setEmplApp(String emplApp) {
        this.emplApp = emplApp;
    }

    public String getEmplRemark() {
        return emplRemark;
    }

    public void setEmplRemark(String emplRemark) {
        this.emplRemark = emplRemark;
    }
}
