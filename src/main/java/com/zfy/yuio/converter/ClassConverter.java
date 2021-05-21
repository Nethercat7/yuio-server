package com.zfy.yuio.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.zfy.yuio.entity.system.SysClass;
import org.springframework.util.ObjectUtils;

public class ClassConverter implements Converter<SysClass> {
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public SysClass convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        SysClass data=new SysClass();
        data.setClassName(cellData.getStringValue());
        return data;
    }

    @Override
    public CellData convertToExcelData(SysClass sysClass, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String data="";
        if(!ObjectUtils.isEmpty(sysClass)){
            data=sysClass.getClassName();
        }
        return new CellData(data);
    }
}
