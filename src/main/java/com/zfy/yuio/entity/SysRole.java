package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Remark:角色实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:01
*/
public class SysRole {
    @JsonProperty("id")
    private String roleId;
    @JsonProperty("name")
    private String roleName;
    @JsonProperty("pid")
    private String rolePid;
    @JsonProperty("status")
    private String roleStatus;
    @JsonProperty("remark")
    private String roleRemark;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime roleCreateTime;
    //非数据库字段
    private List<String> perms;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolePid() {
        return rolePid;
    }

    public void setRolePid(String rolePid) {
        this.rolePid = rolePid;
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

    public List<String> getPerms() {
        return perms;
    }

    public void setPerms(List<String> perms) {
        this.perms = perms;
    }
}
