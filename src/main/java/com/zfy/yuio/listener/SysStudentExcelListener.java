package com.zfy.yuio.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.service.SysStudentService;

import java.util.ArrayList;
import java.util.List;

public class SysStudentExcelListener extends AnalysisEventListener<SysStudent> {
    private static final int BATCH_COUNT = 3000;

    List<SysStudent> list = new ArrayList<SysStudent>();

    private SysStudentService studentService;

    public SysStudentExcelListener(SysStudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void invoke(SysStudent student, AnalysisContext analysisContext) {
        list.add(student);
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

    private void saveData(){
        studentService.addFromExcel(list);
    }
}
