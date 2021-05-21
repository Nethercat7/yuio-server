package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.util.List;

/**
 * @Description:城市实体
 * @Author:赵富源
 * @CreateDate:2021/4/20 18:38
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysCity {
    @ExcelProperty(value = "ID")
    @JsonProperty("id")
    private Long cityId; //DB property

    @ExcelProperty(value = "城市名称")
    @JsonProperty("name")
    private String cityName; //DB property

    @ExcelProperty(value = "层级")
    @JsonProperty("level")
    private int cityLevel; //DB property

    @ExcelProperty(value = "上级ID")
    @JsonProperty("pid")
    private Long cityPid; //DB property

    @ExcelProperty(value = "状态", converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String cityStatus; //DB property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String cityRemark; //DB property

    //Ignore properties
    @ExcelIgnore
    @JsonProperty("direct")
    private int cityDirect; //DB property

    @ExcelIgnore
    private List<SysCity> children;

    @ExcelIgnore
    private boolean disabled;

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

    public String getCityStatus() {
        return cityStatus;
    }

    public void setCityStatus(String cityStatus) {
        this.cityStatus = cityStatus;
    }

    public List<SysCity> getChildren() {
        return children;
    }

    public void setChildren(List<SysCity> children) {
        this.children = children;
    }

    public String getCityRemark() {
        return cityRemark;
    }

    public void setCityRemark(String cityRemark) {
        this.cityRemark = cityRemark;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
