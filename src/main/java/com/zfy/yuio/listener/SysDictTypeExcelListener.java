package com.zfy.yuio.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zfy.yuio.entity.excel.ExcelDictType;
import com.zfy.yuio.service.SysDictTypeService;

import java.util.ArrayList;
import java.util.List;

public class SysDictTypeExcelListener extends AnalysisEventListener<ExcelDictType> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<ExcelDictType> list = new ArrayList<ExcelDictType>();

    private SysDictTypeService service;

    public SysDictTypeExcelListener(SysDictTypeService service) {
        this.service = service;
    }

    @Override
    public void invoke(ExcelDictType data, AnalysisContext analysisContext) {
        list.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
    }

    private void saveData() {
        service.addFromExcel(list);
    }
}
