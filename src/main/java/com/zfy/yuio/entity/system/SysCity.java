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
    @JsonProperty("id")
    @ExcelProperty(index = 0, value = "ID")
    private Long cityId;

    @JsonProperty("name")
    @ExcelProperty(index = 1, value = "城市名称")
    private String cityName;

    @JsonProperty("level")
    @ExcelProperty(index = 2, value = "层级")
    private int cityLevel;

    @JsonProperty("direct")
    @ExcelIgnore
    private int cityDirect;

    @JsonProperty("pid")
    @ExcelProperty(index = 3, value = "上级ID")
    private Long cityPid;

    @JsonProperty("status")
    @ExcelProperty(index = 4, value = "状态", converter = UvslStatusConverter.class)
    private String cityStatus;

    @JsonProperty("remark")
    @ExcelProperty(index = 5, value = "备注")
    private String cityRemark;

    //非数据库字段
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
