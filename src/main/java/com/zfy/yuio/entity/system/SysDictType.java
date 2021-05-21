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
 *@Description:字典类型实体
 *@Author:赵富源
 *@CreateDate:2021/4/22 20:25
*/
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class SysDictType {
    @ExcelProperty(value = "ID")
    @JsonProperty("id")
    private Long dictId;

    @ExcelProperty(value = "标签")
    @JsonProperty("name")
    private String dictName;

    @ExcelProperty(value = "类型")
    @JsonProperty("type")
    private String dictType;

    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    @JsonProperty("status")
    private String dictStatus;

    @ExcelProperty(value = "备注")
    @JsonProperty("remark")
    private String dictRemark;

    @ExcelIgnore
    @JsonProperty("create_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private String dictCreateTime;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
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
}
