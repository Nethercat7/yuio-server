package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *@Description:字典数据实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 23:53
*/
public class SysDictData {
    @JsonProperty("id")
    private String dictId;
    @JsonProperty("label")
    private String dictLabel;
    @JsonProperty("type")
    private String dictType;
    private String status;
    @JsonProperty("create_time")
    private String createTime;
    private String remark;
    @JsonProperty("value")
    private String dictValue;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }
}
