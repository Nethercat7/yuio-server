package com.zfy.yuio.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zfy.yuio.entity.system.SysMajor;
import com.zfy.yuio.service.SysMajorService;

import java.util.ArrayList;
import java.util.List;

public class SysMajorExcelListener extends AnalysisEventListener<SysMajor> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<SysMajor> list = new ArrayList<SysMajor>();

    private SysMajorService service;

    public SysMajorExcelListener(SysMajorService service) {
        this.service = service;
    }

    @Override
    public void invoke(SysMajor data, AnalysisContext analysisContext) {
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
