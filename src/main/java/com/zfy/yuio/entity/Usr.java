package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

/**
 *@Description:用户实体类
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:02
*/
public class Usr {
    @JsonProperty("id")
    private String usrId;
    @JsonProperty("name")
    private String usrName;
    @JsonProperty("account")
    private String usrAccount;
    @JsonProperty("gender")
    private int usrGender;
    @JsonProperty("phone")
    private String usrPhone;
    @JsonProperty("email")
    private String usrEmail;
    @JsonProperty("status")
    private int usrStatus;
    @JsonProperty("description")
    private String usrDescription;
    @JsonProperty("create_time")
    private LocalDateTime usrCreateTime;
    @JsonProperty("pwd")
    private String usrPwd;
    @JsonProperty("salt")
    private String usrSalt;

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    public String getUsrAccount() {
        return usrAccount;
    }

    public void setUsrAccount(String usrAccount) {
        this.usrAccount = usrAccount;
    }

    public int getUsrGender() {
        return usrGender;
    }

    public void setUsrGender(int usrGender) {
        this.usrGender = usrGender;
    }

    public String getUsrPhone() {
        return usrPhone;
    }

    public void setUsrPhone(String usrPhone) {
        this.usrPhone = usrPhone;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public int getUsrStatus() {
        return usrStatus;
    }

    public void setUsrStatus(int usrStatus) {
        this.usrStatus = usrStatus;
    }

    public String getUsrDescription() {
        return usrDescription;
    }

    public void setUsrDescription(String usrDescription) {
        this.usrDescription = usrDescription;
    }

    public LocalDateTime getUsrCreateTime() {
        return usrCreateTime;
    }

    public void setUsrCreateTime(LocalDateTime usrCreateTime) {
        this.usrCreateTime = usrCreateTime;
    }

    public String getUsrPwd() {
        return usrPwd;
    }

    public void setUsrPwd(String usrPwd) {
        this.usrPwd = usrPwd;
    }

    public String getUsrSalt() {
        return usrSalt;
    }

    public void setUsrSalt(String usrSalt) {
        this.usrSalt = usrSalt;
    }
}
