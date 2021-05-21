package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.PermsTypeConverter;
import com.zfy.yuio.converter.UvslStatusConverter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Remark:菜单实体
 * @Author:赵富源
 * @CreateDate:2021/4/16 21:09
 */
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysPerms {
    @ExcelProperty(value = "标签")
    @JsonProperty("name")
    private String permsName; //DB Property

    @ExcelProperty(value = "权限字符串")
    @JsonProperty("mark")
    private String permsMark; //DB Property

    @ExcelProperty(value = "请求地址")
    @JsonProperty("url")
    private String permsUrl; //DB Property

    @ExcelProperty(value = "图标")
    @JsonProperty("icon")
    private String permsIcon; //DB Property

    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String permsStatus; //DB Property

    @ExcelProperty(value = "上级ID")
    @JsonProperty("pid")
    private Long permsPid; //DB Property

    @ExcelProperty(value = "层级")
    @JsonProperty("level")
    private int permsLevel; //DB Property

    @ExcelProperty(value = "类型",converter = PermsTypeConverter.class)
    @JsonProperty("type")
    private String permsType; //DB Property

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String permsRemark; //DB Property


    //Ignore properties
    @ExcelProperty(value = "ID")
    @JsonProperty("id")
    private Long permsId; //DB Property

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime permsCreateTime; //DB Property

    @ExcelIgnore
    private List<SysPerms> children;

    @ExcelIgnore
    private boolean disabled;

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
