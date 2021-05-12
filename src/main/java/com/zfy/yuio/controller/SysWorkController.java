package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelWork;
import com.zfy.yuio.entity.system.SysWork;
import com.zfy.yuio.listener.SysWorkExcelListener;
import com.zfy.yuio.service.SysWorkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("sys/work")
public class SysWorkController {
    @Autowired
    private SysWorkService workService;

    @PostMapping("add")
    @RequiresPermissions("system:work:add")
    public ResultBody add(@RequestBody SysWork params) {
        int status = workService.add(params);
        if (status == 1) {
            return new ResultBody(status, "岗位名称已存在", "error");
        }
        return new ResultBody(status, "成功添加", "success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:work:get")
    public ResultBody get() {
        return new ResultBody(0, workService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:work:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = workService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:work:upd")
    public ResultBody upd(@RequestBody SysWork params) {
        int status = workService.upd(params);
        if (status == 1) {
            return new ResultBody(status, "岗位名称已存在", "error");
        }
        return new ResultBody(status, "成功修改", "success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword) {
        return new ResultBody(0, workService.getByKeyword(keyword));
    }

    @GetMapping("output")
    @RequiresPermissions("system:work:output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("岗位数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysWork.class).sheet("Sheet1").doWrite(workService.getWithoutConvert());
    }

    @PostMapping("upload")
    @RequiresPermissions("system:work:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelWork.class, new SysWorkExcelListener(workService)).sheet().doRead();
        return new ResultBody(0, "成功导入数据", "success");
    }
}
