package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Description:城市实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/20 18:38
 */
public class ExcelCity {
    @ExcelProperty("ID")
    private Long cityId;

    @ExcelProperty("城市名称")
    private String cityName;

    @ExcelProperty("层级")
    private int cityLevel;

    @ExcelProperty("上级ID")
    private Long cityPid;

    @ExcelProperty("状态")
    private String cityStatus;

    @ExcelProperty("备注")
    private String cityRemark;

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

    public int getCityLevel() {
        return cityLevel;
    }

    public void setCityLevel(int cityLevel) {
        this.cityLevel = cityLevel;
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

    public String getCityRemark() {
        return cityRemark;
    }

    public void setCityRemark(String cityRemark) {
        this.cityRemark = cityRemark;
    }
}
