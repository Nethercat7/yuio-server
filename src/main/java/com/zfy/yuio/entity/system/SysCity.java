package com.zfy.yuio.entity.system;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty("level")
    private int cityLevel;
    @JsonProperty("direct")
    private int cityDirect;
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
