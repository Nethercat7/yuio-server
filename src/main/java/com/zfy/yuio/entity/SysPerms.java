package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Remark:菜单实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/16 21:09
 */
public class SysPerms {
    @JsonProperty("id")
    private Long permsId;
    @JsonProperty("name")
    private String permsName;
    @JsonProperty("mark")
    private String permsMark;
    @JsonProperty("url")
    private String permsUrl;
    @JsonProperty("icon")
    private String permsIcon;
    @JsonProperty("remark")
    private String permsRemark;
    @JsonProperty("status")
    private String permsStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime permsCreateTime;
    @JsonProperty("pid")
    private Long permsPid;
    @JsonProperty("level")
    private int permsLevel;
    @JsonProperty("type")
    private String permsType;
    //非数据库字段
    private List<SysPerms> children;

    public Long getPermsId() {
        return permsId;
    }

    public void setPermsId(Long permsId) {
        this.permsId = permsId;
    }

    public String getPermsName() {
        return permsName;
    }

    public void setPermsName(String permsName) {
        this.permsName = permsName;
    }

    public String getPermsMark() {
        return permsMark;
    }

    public void setPermsMark(String permsMark) {
        this.permsMark = permsMark;
    }

    public String getPermsUrl() {
        return permsUrl;
    }

    public void setPermsUrl(String permsUrl) {
        this.permsUrl = permsUrl;
    }

    public String getPermsIcon() {
        return permsIcon;
    }

    public void setPermsIcon(String permsIcon) {
        this.permsIcon = permsIcon;
    }

    public String getPermsRemark() {
        return permsRemark;
    }

    public void setPermsRemark(String permsRemark) {
        this.permsRemark = permsRemark;
    }

    public String getPermsStatus() {
        return permsStatus;
    }

    public void setPermsStatus(String permsStatus) {
        this.permsStatus = permsStatus;
    }

    public LocalDateTime getPermsCreateTime() {
        return permsCreateTime;
    }

    public void setPermsCreateTime(LocalDateTime permsCreateTime) {
        this.permsCreateTime = permsCreateTime;
    }

    public Long getPermsPid() {
        return permsPid;
    }

    public void setPermsPid(Long permsPid) {
        this.permsPid = permsPid;
    }

    public int getPermsLevel() {
        return permsLevel;
    }

    public void setPermsLevel(int permsLevel) {
        this.permsLevel = permsLevel;
    }

    public String getPermsType() {
        return permsType;
    }

    public void setPermsType(String permsType) {
        this.permsType = permsType;
    }

    public List<SysPerms> getChildren() {
        return children;
    }

    public void setChildren(List<SysPerms> children) {
        this.children = children;
    }
}
