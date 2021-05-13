package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 *@Description:字典类型实体
 *@Author:赵富源
 *@CreateDate:2021/4/22 20:25
*/
public class ExcelDictType {
    @ExcelProperty("ID")
    private Long dictId;

    @ExcelProperty("标签")
    private String dictName;

    @ExcelProperty("类型")
    private String dictType;

    @ExcelProperty("状态")
    private String dictStatus;

    @ExcelProperty("备注")
    private String dictRemark;

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

    public String getDictRemark() {
        return dictRemark;
    }

    public void setDictRemark(String dictRemark) {
        this.dictRemark = dictRemark;
    }
}
