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
    @JsonProperty("id")
    @ExcelProperty(value = "ID")
    private Long permsId;

    @JsonProperty("name")
    @ExcelProperty(value = "标签")
    private String permsName;

    @JsonProperty("mark")
    @ExcelProperty(value = "权限字符串")
    private String permsMark;

    @JsonProperty("url")
    @ExcelProperty(value = "请求地址")
    private String permsUrl;

    @JsonProperty("icon")
    @ExcelProperty(value = "图标")
    private String permsIcon;

    @JsonProperty("status")
    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    private String permsStatus;

    @JsonProperty("pid")
    @ExcelProperty(value = "上级ID")
    private Long permsPid;

    @JsonProperty("level")
    @ExcelProperty(value = "层级")
    private int permsLevel;

    @JsonProperty("type")
    @ExcelProperty(value = "类型",converter = PermsTypeConverter.class)
    private String permsType;

    @JsonProperty("remark")
    @ExcelProperty(value = "备注")
    private String permsRemark;

    @JsonProperty("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private LocalDateTime permsCreateTime;
    
    @ExcelIgnore
    private List<SysPerms> children;//非数据库字段

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
