package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class ExcelRole {
    @JsonProperty("id")
    @ExcelIgnore
    private Long roleId;

    @JsonProperty("name")
    @ExcelProperty("角色名称")
    private String roleName;

    private String roleStatus;

    @ExcelProperty("备注")
    private String roleRemark;

    @ExcelIgnore
    private LocalDateTime roleCreateTime;

    //非数据库字段
    private List<Long> perms;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public LocalDateTime getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(LocalDateTime roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    public List<Long> getPerms() {
        return perms;
    }

    public void setPerms(List<Long> perms) {
        this.perms = perms;
    }
}
