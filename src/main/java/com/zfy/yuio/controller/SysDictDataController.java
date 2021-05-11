package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelDictData;
import com.zfy.yuio.entity.system.SysDictData;
import com.zfy.yuio.listener.SysDictDataExcelListener;
import com.zfy.yuio.service.SysDictDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 *@Description:字典数据
 *@Author:Nethercat7
 *@CreateDate:2021/4/23 0:00
*/
@CrossOrigin
@RestController
@RequestMapping("sys/dict/data")
public class SysDictDataController {
    @Autowired
    private SysDictDataService sysDictDataService;

    @PostMapping("add")
    @RequiresPermissions("system:dict:add")
    public ResultBody add(@RequestBody SysDictData params){
        int status=sysDictDataService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"添加成功","success");
    }

    @GetMapping("get")
    public ResultBody get(@RequestParam("type") String type){
        return new ResultBody(0,sysDictDataService.get(type));
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:dict:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=sysDictDataService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"删除成功","success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:dict:upd")
    public ResultBody upd(@RequestBody SysDictData params){
        int status=sysDictDataService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"修改成功","success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,sysDictDataService.getByKeyword(keyword));
    }

    @GetMapping("output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("字典数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysDictData.class).sheet("Sheet1").doWrite(sysDictDataService.getAll());
    }

    @PostMapping("upload")
    public void upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelDictData.class,new SysDictDataExcelListener(sysDictDataService)).sheet().doRead();
    }
}
