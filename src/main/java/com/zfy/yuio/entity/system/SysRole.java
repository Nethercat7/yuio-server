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
 *@Author:赵富源
 *@CreateDate:2021/4/13 22:01
*/
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysRole {
    @ExcelProperty(value = "角色名称")
    @JsonProperty("name")
    private String roleName; //DB Property

    @ExcelProperty(value = "角色状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String roleStatus; //DB Property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String roleRemark; //DB Property

    //Ignore Properties
    @ExcelIgnore
    @JsonProperty("id")
    private Long roleId; //DB Property

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime roleCreateTime; //DB Property

    @ExcelIgnore
    private List<Long> perms;

    @ExcelIgnore
    private boolean disabled;

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
