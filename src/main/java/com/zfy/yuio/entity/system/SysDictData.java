package com.zfy.yuio.entity.system;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.UvslStatusConverter;

/**
 *@Description:字典数据实体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 23:53
*/
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysDictData {
    @JsonProperty("id")
    @ExcelProperty(value = "ID")
    private Long dictId;

    @JsonProperty("label")
    @ExcelProperty(value = "标签")
    private String dictLabel;

    @JsonProperty("type")
    @ExcelProperty(value = "类型")
    private String dictType;

    @JsonProperty("status")
    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    private String dictStatus;

    @JsonProperty("remark")
    @ExcelProperty(value = "备注")
    private String dictRemark;

    @JsonProperty("value")
    @ExcelProperty(value = "键值")
    private String dictValue;

    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ExcelIgnore
    private String dictCreateTime;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
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
