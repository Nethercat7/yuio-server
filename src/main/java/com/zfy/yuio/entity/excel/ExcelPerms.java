package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Remark:菜单实体
 * @Author:赵富源
 * @CreateDate:2021/4/16 21:09
 */
public class ExcelPerms {
    @JsonProperty("id")
    @ExcelProperty("ID")
    private Long permsId;

    @JsonProperty("name")
    @ExcelProperty("标签")
    private String permsName;

    @JsonProperty("mark")
    @ExcelProperty("权限字符串")
    private String permsMark;

    @JsonProperty("url")
    @ExcelProperty("请求地址")
    private String permsUrl;

    @JsonProperty("icon")
    @ExcelProperty("图标")
    private String permsIcon;

    @JsonProperty("status")
    @ExcelProperty("状态")
    private String permsStatus;

    @JsonProperty("pid")
    @ExcelProperty("上级ID")
    private Long permsPid;

    @JsonProperty("level")
    @ExcelProperty("层级")
    private int permsLevel;

    @JsonProperty("type")
    @ExcelProperty("类型")
    private String permsType;

    @JsonProperty("remark")
    @ExcelProperty("备注")
    private String permsRemark;

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

    public String getPermsStatus() {
        return permsStatus;
    }

    public void setPermsStatus(String permsStatus) {
        this.permsStatus = permsStatus;
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

    public String getPermsRemark() {
        return permsRemark;
    }

    public void setPermsRemark(String permsRemark) {
        this.permsRemark = permsRemark;
    }
}
