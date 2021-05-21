package com.zfy.yuio.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.service.SysStudentService;

import java.util.ArrayList;
import java.util.List;

public class SysStudentExcelListener extends AnalysisEventListener<SysStudent> {
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
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
