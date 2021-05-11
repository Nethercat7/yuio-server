package com.zfy.yuio.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Description:字典数据实体
 * @Author:Nethercat7
 * @CreateDate:2021/4/22 23:53
 */
public class ExcelDictData {
    @ExcelProperty("ID")
    private Long dictId;

    @ExcelProperty("标签")
    private String dictLabel;

    @ExcelProperty("类型")
    private String dictType;

    @ExcelProperty("状态")
    private String dictStatus;

    @ExcelProperty("备注")
    private String dictRemark;

    @ExcelProperty("键值")
    private String dictValue;

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
