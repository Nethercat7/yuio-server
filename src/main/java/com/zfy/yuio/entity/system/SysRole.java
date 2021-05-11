package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *@Remark:角色实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/13 22:01
*/
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysRole {
    @JsonProperty("id")
    @ExcelProperty("角色ID")
    private Long roleId;
    @JsonProperty("name")
    @ExcelProperty("角色名称")
    private String roleName;
    @JsonProperty("status")
    @ExcelProperty("角色状态")
    private String roleStatus;
    @JsonProperty("remark")
    @ExcelProperty("备注")
    private String roleRemark;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelProperty("创建时间")
    private Date roleCreateTime;
    //非数据库字段
    @ExcelIgnore
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

    public Date getRoleCreateTime() {
        return roleCreateTime;
    }

    public void setRoleCreateTime(Date roleCreateTime) {
        this.roleCreateTime = roleCreateTime;
    }

    public List<Long> getPerms() {
        return perms;
    }

    public void setPerms(List<Long> perms) {
        this.perms = perms;
    }
}
