package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Demplcription:就业信息统计表
 * @Author:Nethercat7
 * @CreateDate:2021/4/17 22:31
 */
public class StatsEmplInfo {
    @JsonProperty("id")
    private String emplId;
    @JsonProperty("student_id")
    private String emplStudentId;
    @JsonProperty("class_id")
    private String emplClassId;
    @JsonProperty("major_id")
    private String emplMajorId;
    @JsonProperty("college_id")
    private String emplCollegeId;
    @JsonProperty("grade")
    private int emplGrade;
    @JsonProperty("Protocol")
    private String emplProtocol;
    @JsonProperty("company")
    private String emplCompany;
    @JsonProperty("work_city")
    private String emplWorkCity;
    @JsonProperty("work_type")
    private String emplWorkType;
    @JsonProperty("status")
    private String emplStatus;
    @JsonProperty("plan")
    private String emplPlan;
    @JsonProperty("intention_city")
    private String emplIntentionCity;
    @JsonProperty("intention_work")
    private String emplIntentionWork;

    public String getEmplId() {
        return emplId;
    }

    public void setEmplId(String emplId) {
        this.emplId = emplId;
    }

    public String getEmplStudentId() {
        return emplStudentId;
    }

    public void setEmplStudentId(String emplStudentId) {
        this.emplStudentId = emplStudentId;
    }

    public String getEmplClassId() {
        return emplClassId;
    }

    public void setEmplClassId(String emplClassId) {
        this.emplClassId = emplClassId;
    }

    public String getEmplMajorId() {
        return emplMajorId;
    }

    public void setEmplMajorId(String emplMajorId) {
        this.emplMajorId = emplMajorId;
    }

    public String getEmplCollegeId() {
        return emplCollegeId;
    }

    public void setEmplCollegeId(String emplCollegeId) {
        this.emplCollegeId = emplCollegeId;
    }

    public int getEmplGrade() {
        return emplGrade;
    }

    public void setEmplGrade(int emplGrade) {
        this.emplGrade = emplGrade;
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

    public String getEmplWorkCity() {
        return emplWorkCity;
    }

    public void setEmplWorkCity(String emplWorkCity) {
        this.emplWorkCity = emplWorkCity;
    }

    public String getEmplWorkType() {
        return emplWorkType;
    }

    public void setEmplWorkType(String emplWorkType) {
        this.emplWorkType = emplWorkType;
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

    public String getEmplIntentionCity() {
        return emplIntentionCity;
    }

    public void setEmplIntentionCity(String emplIntentionCity) {
        this.emplIntentionCity = emplIntentionCity;
    }

    public String getEmplIntentionWork() {
        return emplIntentionWork;
    }

    public void setEmplIntentionWork(String emplIntentionWork) {
        this.emplIntentionWork = emplIntentionWork;
    }
}
