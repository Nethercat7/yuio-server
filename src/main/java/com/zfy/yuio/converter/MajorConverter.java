package com.zfy.yuio.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.zfy.yuio.entity.system.SysMajor;
import org.springframework.util.ObjectUtils;

public class MajorConverter implements Converter<SysMajor> {
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public SysMajor convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(SysMajor sysMajor, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String data="";
        if(!ObjectUtils.isEmpty(sysMajor)){
            data=sysMajor.getMajorName();
        }
        return new CellData(data);
    }
}
