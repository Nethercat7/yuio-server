package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.time.LocalDateTime;
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
    @ExcelIgnore
    private Long roleId;

    @JsonProperty("name")
    @ExcelProperty(index = 0,value = "角色名称")
    private String roleName;

    @JsonProperty("status")
    @ExcelProperty(index = 1,value = "角色状态",converter = UvslStatusConverter.class)

    private String roleStatus;
    @JsonProperty("remark")
    @ExcelProperty(index = 2,value = "备注")
    private String roleRemark;

    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime roleCreateTime;

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
