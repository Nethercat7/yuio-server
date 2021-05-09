package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *@Description:城市实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/20 18:38
*/
public class SysCity {
    @JsonProperty("id")
    private int cityId;
    @JsonProperty("name")
    private String cityName;
    @JsonProperty("pid")
    private int cityPid;
    @JsonProperty("level")
    private int cityLevel;
    @JsonProperty("direct")
    private int cityDirect;
    //非数据库字段
    @JsonProperty("children")
    private List<SysCity> children;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityPid() {
        return cityPid;
    }

    public void setCityPid(int cityPid) {
        this.cityPid = cityPid;
    }

    public int getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(int cityLevel) {
        this.cityLevel = cityLevel;
    }

    public int getCityDirect() {
        return cityDirect;
    }

    public void setCityDirect(int cityDirect) {
        this.cityDirect = cityDirect;
    }

    public List<SysCity> getChildren() {
        return children;
    }

    public void setChildren(List<SysCity> children) {
        this.children = children;
    }
}
