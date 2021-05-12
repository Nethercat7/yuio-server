package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelClass;
import com.zfy.yuio.entity.system.SysClass;
import com.zfy.yuio.listener.SysClassExcelListener;
import com.zfy.yuio.service.SysClassService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("sys/class")
public class SysClassController {
    @Autowired
    private SysClassService classService;

    @PostMapping("add")
    @RequiresPermissions("system:class:add")
    public ResultBody add(@RequestBody SysClass params){
        int status=classService.add(params);
        if(status==1){
            return new ResultBody(status,"班级名称已存在","error");
        }
        return new ResultBody(status,"添加成功","success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:class:get")
    public ResultBody get(){
        return new ResultBody(0,classService.get(),"success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:class:del")
    public ResultBody add(@RequestParam("id") Long id){
        int status=classService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败","error");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:class:upd")
    public ResultBody upd(@RequestBody SysClass params){
        int status=classService.upd(params);
        if(status==1){
            return new ResultBody(status,"班级名称已存在","error");
        }
        return new ResultBody(status,"修改成功","success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,classService.getByKeyword(keyword));
    }

    @GetMapping("output")
    @RequiresPermissions("system:class:output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("班级数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysClass.class).sheet("Sheet1").doWrite(classService.get());
    }

    @PostMapping("upload")
    @RequiresPermissions("system:class:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelClass.class,new SysClassExcelListener(classService)).sheet().doRead();
        return new ResultBody(0,"成功导入数据","success");
    }
}
