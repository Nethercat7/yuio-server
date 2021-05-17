package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description:接收前端查询字段
 * @Author:赵富源
 * @CreateDate:2021/4/21 23:35
 */
public class QueryParams {
    @JsonProperty("student_id")
    private Long studentId;

    @JsonProperty("org_id")
    private Long orgId;

    @JsonProperty("empl_status")
    private String emplStatus;

    @JsonProperty("empl_write")
    private String emplWrite;

    private int grade;

    private String gender;

    private String name;

    private String type;

    @JsonProperty("user_code")
    private String userCode;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getEmplStatus() {
        return emplStatus;
    }

    public void setEmplStatus(String emplStatus) {
        this.emplStatus = emplStatus;
    }

    public String getEmplWrite() {
        return emplWrite;
    }

    public void setEmplWrite(String emplWrite) {
        this.emplWrite = emplWrite;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
