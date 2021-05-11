package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Description:用户实体类
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 17:02
 */
public class ExcelUser {
    @ExcelProperty("姓名")
    private String userName;

    @ExcelProperty("工号")
    private String userCode;

    @ExcelProperty("性别")
    private String userGender;

    @ExcelProperty("电话号码")
    private String userPhone;

    @ExcelProperty("备注")
    private String userRemark;

    @ExcelIgnore
    private String userStatus;

    @ExcelIgnore
    private Long userId;

    @ExcelIgnore
    private String userPwd;

    @ExcelIgnore
    private String userSalt;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }
}
