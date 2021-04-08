package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:组织实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 18:18
*/
public class Org {
    @JsonProperty("org_id")
    private String orgId;
    @JsonProperty("org_name")
    private String orgName;
    @JsonProperty("org_code")
    private String orgCode;
    @JsonProperty("org_status")
    private int orgStatus;
    @JsonProperty("org_create_time")
    private LocalDateTime orgCreateTime;
    @JsonProperty("org_description")
    private String orgDescription;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public int getOrgStatus() {
        return orgStatus;
    }

    public void setOrgStatus(int orgStatus) {
        this.orgStatus = orgStatus;
    }

    public LocalDateTime getOrgCreateTime() {
        return orgCreateTime;
    }

    public void setOrgCreateTime(LocalDateTime orgCreateTime) {
        this.orgCreateTime = orgCreateTime;
    }

    public String getOrgDescription() {
        return orgDescription;
    }

    public void setOrgDescription(String orgDescription) {
        this.orgDescription = orgDescription;
    }
}
