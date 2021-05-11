package com.zfy.yuio.entity.write;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Demplcription:就业信息统计表
 * @Author:Nethercat7
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
    @JsonProperty("student_id")
    private Long emplStudentId;
    @JsonProperty("city_id")
    private Long emplCityId;
    @JsonProperty("work_id")
    private Long emplWorkId;
    @JsonProperty("city")
    private String emplCity;
    @JsonProperty("work")
    private String emplWork;
    //非数据库字段
    @JsonProperty("intention_cities")
    private List<Long> intentionCities;
    @JsonProperty("intention_works")
    private List<Long> intentionWorks;


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

    public Long getEmplStudentId() {
        return emplStudentId;
    }

    public void setEmplStudentId(Long emplStudentId) {
        this.emplStudentId = emplStudentId;
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
}
