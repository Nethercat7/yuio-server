package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.statstics.StatsEmplResult;
import com.zfy.yuio.service.StatsRateService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("stats/rate")
public class StatsRateController {
    @Autowired
    private StatsRateService statsRateService;

    @PostMapping("getEmplInfo")
    @RequiresPermissions("statistics:rate:view")
    public ResultBody getEmplInfoBy(@RequestBody QueryParams params){
        return new ResultBody(0,statsRateService.getEmplInfo(params));
    }

    @PostMapping("output")
    @RequiresPermissions("statistics:rate:output")
    public void output(@RequestBody QueryParams params, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        StatsEmplResult result=statsRateService.getEmplInfo(params);
        EasyExcel.write(response.getOutputStream(), StatsEmplResult.class).sheet("Sheet1").doWrite(result.getResults());
    }
}
