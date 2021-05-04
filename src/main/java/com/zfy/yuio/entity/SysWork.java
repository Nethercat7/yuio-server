package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:岗位实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:38
*/
public class SysWork {
    @JsonProperty("id")
    private Long workId;
    @JsonProperty("name")
    private String workName;
    @JsonProperty("pid")
    private Long workPid;
    @JsonProperty("status")
    private String workStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime workCreateTime;
    @JsonProperty("level")
    private int workLevel;
    //非数据库字段
    private List<SysWork> children;

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Long getWorkPid() {
        return workPid;
    }

    public void setWorkPid(Long workPid) {
        this.workPid = workPid;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public LocalDateTime getWorkCreateTime() {
        return workCreateTime;
    }

    public void setWorkCreateTime(LocalDateTime workCreateTime) {
        this.workCreateTime = workCreateTime;
    }

    public int getWorkLevel() {
        return workLevel;
    }

    public void setWorkLevel(int workLevel) {
        this.workLevel = workLevel;
    }

    public List<SysWork> getChildren() {
        return children;
    }

    public void setChildren(List<SysWork> children) {
        this.children = children;
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }
}
