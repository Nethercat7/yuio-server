package com.zfy.yuio.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zfy.yuio.entity.system.SysWork;
import com.zfy.yuio.service.SysWorkService;

import java.util.ArrayList;
import java.util.List;

public class SysWorkExcelListener extends AnalysisEventListener<SysWork> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<SysWork> list = new ArrayList<SysWork>();

    private SysWorkService service;

    public SysWorkExcelListener(SysWorkService service) {
        this.service = service;
    }

    @Override
    public void invoke(SysWork data, AnalysisContext analysisContext) {
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
