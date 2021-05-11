package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelCity;
import com.zfy.yuio.entity.system.SysCity;
import com.zfy.yuio.listener.SysCityExcelListener;
import com.zfy.yuio.service.SysCityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("sys/city")
public class SysCityController {
    @Autowired
    private SysCityService cityService;

    @PostMapping("add")
    @RequiresPermissions("system:city:add")
    public ResultBody add(@RequestBody SysCity params) {
        int status = cityService.add(params);
        if (status != 1) {
            return new ResultBody(1, "添加失败", "error");
        }
        return new ResultBody(0, "成功添加", "success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:city:get")
    public ResultBody get() {
        return new ResultBody(0, cityService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:city:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = cityService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:city:upd")
    public ResultBody upd(@RequestBody SysCity params) {
        int status = cityService.upd(params);
        if (status != 1) {
            return new ResultBody(1, "修改失败", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,cityService.getByKeyword(keyword));
    }

    @GetMapping("output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("城市数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysCity.class).sheet("Sheet1").doWrite(cityService.getWithoutConvert());
    }

    @PostMapping("upload")
    public void upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelCity.class,new SysCityExcelListener(cityService)).sheet().doRead();
    }
}
