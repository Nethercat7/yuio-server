package com.zfy.yuio.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.zfy.yuio.entity.system.SysDictData;
import com.zfy.yuio.service.SysDictDataService;
import com.zfy.yuio.utils.SpringApplicationUtil;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class EmplWriteConverter implements Converter<String> {
    private static List<SysDictData> dictList = null;

    private SysDictDataService dictDataService;

    public EmplWriteConverter() {
        dictDataService = SpringApplicationUtil.getBean(SysDictDataService.class);
        if (ObjectUtils.isEmpty(dictList)) {
            dictList = dictDataService.get("sys_write_status");
        }
    }

    @Override
    public Class supportJavaTypeKey() {
        return null;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return null;
    }

    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return null;
    }

    @Override
    public CellData convertToExcelData(String s, ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        for (SysDictData d:dictList
             ) {
            if(s.equals(d.getDictValue())){
                s=d.getDictLabel();
            }
        }
        return new CellData(s);
    }
}
