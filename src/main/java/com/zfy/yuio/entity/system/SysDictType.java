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
    @JsonProperty("id")
    @ExcelProperty(value = "ID")
    private Long dictId;

    @JsonProperty("name")
    @ExcelProperty(value = "标签")
    private String dictName;

    @JsonProperty("type")
    @ExcelProperty(value = "类型")
    private String dictType;

    @JsonProperty("status")
    @ExcelProperty(value = "状态",converter = UvslStatusConverter.class)
    private String dictStatus;

    @JsonProperty("remark")
    @ExcelProperty(value = "备注")
    private String dictRemark;

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
