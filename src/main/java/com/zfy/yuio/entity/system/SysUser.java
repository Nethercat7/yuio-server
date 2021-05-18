package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.GenderConverter;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description:用户实体类
 * @Author:赵富源
 * @CreateDate:2021/4/12 17:02
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysUser {
    @JsonProperty("id")
    @ExcelIgnore
    private Long userId;

    @JsonProperty("name")
    @ExcelProperty(index = 0,value = "姓名")
    private String userName;

    @JsonProperty("code")
    @ExcelProperty(index = 1,value = "工号")
    private String userCode;

    @JsonProperty("gender")
    @ExcelProperty(index = 2,value = "性别",converter = GenderConverter.class)
    private String userGender;

    @JsonProperty("phone")
    @ExcelProperty(index = 3,value = "手机号码")
    private String userPhone;

    @JsonProperty("status")
    @ExcelProperty(index = 4,value = "状态",converter = UvslStatusConverter.class)
    private String userStatus;

    @JsonProperty("remark")
    @ExcelProperty(index = 5,value = "备注")
    private String userRemark;

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userCreateTime;

    @JsonProperty("pwd")
    @ExcelIgnore
    private String userPwd;

    @JsonProperty("salt")
    @ExcelIgnore
    private String userSalt;

    @JsonProperty("college_id")
    private Long userCollegeId;

    //非数据库字段
    @ExcelIgnore
    private List<Long> roles;

    @ExcelIgnore
    private boolean  disabled;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public LocalDateTime getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(LocalDateTime userCreateTime) {
        this.userCreateTime = userCreateTime;
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

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Long getUserCollegeId() {
        return userCollegeId;
    }

    public void setUserCollegeId(Long userCollegeId) {
        this.userCollegeId = userCollegeId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
