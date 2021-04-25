package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *@Description:字典类型实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 20:25
*/
public class SysDictType {
    @JsonProperty("id")
    private String dictId;
    @JsonProperty("name")
    private String dictName;
    @JsonProperty("type")
    private String dictType;
    @JsonProperty("status")
    private String dictStatus;
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String dictCreateTime;
    @JsonProperty("remark")
    private String dictRemark;
    @JsonProperty("value")
    private String dictValue;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(String dictStatus) {
        this.dictStatus = dictStatus;
    }

    public String getDictCreateTime() {
        return dictCreateTime;
    }

    public void setDictCreateTime(String dictCreateTime) {
        this.dictCreateTime = dictCreateTime;
    }

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
