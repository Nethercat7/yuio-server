package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *@Description:就业信息统计表
 *@Author:Nethercat7
 *@CreateDate:2021/4/17 22:31
*/
public class EStatus {
    @JsonProperty("id")
    private String esId;
    @JsonProperty("student_id")
    private String esStudentId;
    @JsonProperty("class_id")
    private String esClsId;
    @JsonProperty("major_id")
    private String esMajorId;
    @JsonProperty("college_id")
    private String esCollegeId;
    @JsonProperty("grade")
    private int esGrade;
    @JsonProperty("employment")
    private String esEmployment;
    @JsonProperty("company")
    private String esCompany;
    @JsonProperty("work_city")
    private String esWorkCity;
    @JsonProperty("work_type")
    private String esWorkType;
    @JsonProperty("status")
    private String esStatus;
    @JsonProperty("plan")
    private String esPlan;
    @JsonProperty("intention_city")
    private String esIntentionCity;
    @JsonProperty("intention_work")
    private String esIntentionWork;

    public String getEsId() {
        return esId;
    }

    public void setEsId(String esId) {
        this.esId = esId;
    }

    public String getEsStudentId() {
        return esStudentId;
    }

    public void setEsStudentId(String esStudentId) {
        this.esStudentId = esStudentId;
    }

    public String getEsClsId() {
        return esClsId;
    }

    public void setEsClsId(String esClsId) {
        this.esClsId = esClsId;
    }

    public String getEsMajorId() {
        return esMajorId;
    }

    public void setEsMajorId(String esMajorId) {
        this.esMajorId = esMajorId;
    }

    public String getEsCollegeId() {
        return esCollegeId;
    }

    public void setEsCollegeId(String esCollegeId) {
        this.esCollegeId = esCollegeId;
    }

    public int getEsGrade() {
        return esGrade;
    }

    public void setEsGrade(int esGrade) {
        this.esGrade = esGrade;
    }

    public String getEsCompany() {
        return esCompany;
    }

    public void setEsCompany(String esCompany) {
        this.esCompany = esCompany;
    }

    public String getEsWorkCity() {
        return esWorkCity;
    }

    public void setEsWorkCity(String esWorkCity) {
        this.esWorkCity = esWorkCity;
    }

    public String getEsWorkType() {
        return esWorkType;
    }

    public void setEsWorkType(String esWorkType) {
        this.esWorkType = esWorkType;
    }

    public String getEsIntentionCity() {
        return esIntentionCity;
    }

    public void setEsIntentionCity(String esIntentionCity) {
        this.esIntentionCity = esIntentionCity;
    }

    public String getEsIntentionWork() {
        return esIntentionWork;
    }

    public void setEsIntentionWork(String esIntentionWork) {
        this.esIntentionWork = esIntentionWork;
    }

    public String getEsEmployment() {
        return esEmployment;
    }

    public void setEsEmployment(String esEmployment) {
        this.esEmployment = esEmployment;
    }

    public String getEsStatus() {
        return esStatus;
    }

    public void setEsStatus(String esStatus) {
        this.esStatus = esStatus;
    }

    public String getEsPlan() {
        return esPlan;
    }

    public void setEsPlan(String esPlan) {
        this.esPlan = esPlan;
    }
}
