package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 *@Description:城市实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:38
*/
public class SysCity {
    @JsonProperty("id")
    private Long cityId;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("pid")
    private Long cityPid;
    @JsonProperty("status")
    private String cityStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cityCreateTime;
    @JsonProperty("level")
    private int cityLevel;
    //非数据库字段
    private List<SysCity> children;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityPid() {
        return cityPid;
    }

    public void setCityPid(Long cityPid) {
        this.cityPid = cityPid;
    }

    public String getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(String cityStatus) {
        this.cityStatus = cityStatus;
    }

    public LocalDateTime getCityCreateTime() {
        return cityCreateTime;
    }

    public void setCityCreateTime(LocalDateTime cityCreateTime) {
        this.cityCreateTime = cityCreateTime;
    }

    public int getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(int cityLevel) {
        this.cityLevel = cityLevel;
    }

    public List<SysCity> getChildren() {
        return children;
    }

    public void setChildren(List<SysCity> children) {
        this.children = children;
    }
}
