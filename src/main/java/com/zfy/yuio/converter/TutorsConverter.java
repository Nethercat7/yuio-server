package com.zfy.yuio.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class TutorsConverter implements Converter<List<String>> {
    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public List<String> convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(List<String> strings, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        String data="";
        if(!ObjectUtils.isEmpty(strings)){
            data=String.join(",",strings);
        }
        return new CellData(data);
    }
}
