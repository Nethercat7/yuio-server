package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zfy.yuio.entity.statstics.ExcelCityStatus;
import com.zfy.yuio.entity.statstics.ExcelPlanStats;
import com.zfy.yuio.entity.statstics.ExcelWorkStats;
import com.zfy.yuio.service.StatsDataOutputService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class StatsDataOutputServiceImpl implements StatsDataOutputService {
    @Override
    public void outputCityInfo(List<ExcelCityStatus> excelCityStatuses, HttpServletResponse response) {
        try{
            setExcelParams(response);
            EasyExcel.write(response.getOutputStream(),ExcelCityStatus.class).sheet("sheet1").doWrite(excelCityStatuses);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void outputWorkInfo(ExcelWorkStats params, HttpServletResponse response) {
        try{
            setExcelParams(response);
            ExcelWriter writer = EasyExcel.write(response.getOutputStream()).build();
            //创建单元格
            WriteSheet sheet1=EasyExcel.writerSheet(0,"总排行").head(ExcelWorkStats.class).build();
            WriteSheet sheet2=EasyExcel.writerSheet(1,"女生排行").head(ExcelWorkStats.class).build();
            WriteSheet sheet3=EasyExcel.writerSheet(2,"男生排行").head(ExcelWorkStats.class).build();
            //写入数据
            writer.write(params.getTotalRank(),sheet1);
            writer.write(params.getFemaleRank(),sheet2);
            writer.write(params.getMaleRank(),sheet3);
            writer.finish();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void outputStudentPlan(ExcelPlanStats params, HttpServletResponse response) {
        try{
            setExcelParams(response);
            ExcelWriter writer = EasyExcel.write(response.getOutputStream()).build();
            //创建单元格
            WriteSheet sheet1=EasyExcel.writerSheet(0,"总排行").head(ExcelPlanStats.class).build();
            WriteSheet sheet2=EasyExcel.writerSheet(1,"女生排行").head(ExcelPlanStats.class).build();
            WriteSheet sheet3=EasyExcel.writerSheet(2,"男生排行").head(ExcelPlanStats.class).build();
            //写入数据
            writer.write(params.getTotalRank(),sheet1);
            writer.write(params.getFemaleRank(),sheet2);
            writer.write(params.getMaleRank(),sheet3);
            writer.finish();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void setExcelParams(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "Data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }
}
