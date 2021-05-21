package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.system.SysMajor;
import com.zfy.yuio.listener.SysMajorExcelListener;
import com.zfy.yuio.service.SysMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@Description:专业管理
 *@Author:赵富源
 *@CreateDate:2021/4/8 20:53
 */
@CrossOrigin
@RestController
@RequestMapping("sys/major")
public class SysMajorController {
    @Autowired
    private SysMajorService majorService;

    @PostMapping("add")
    @RequiresPermissions("system:major:add")
    public ResultBody add(@RequestBody SysMajor params){
        int status=majorService.add(params);
        if(status==1){
            return new ResultBody(status,"专业名称已存在","error");
        }
        return new ResultBody(status,"添加成功","success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:major:get")
    public ResultBody get(){
        return new ResultBody(0,majorService.get(),"success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:major:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=majorService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:major:upd")
    public ResultBody upd(@RequestBody SysMajor params){
        int status=majorService.upd(params);
        if(status==1){
            return new ResultBody(status,"专业名称已存在","error");
        }
        return new ResultBody(status,"修改成功","success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,majorService.getByKeyword(keyword));
    }

    @GetMapping("output")
    @RequiresPermissions("system:major:output")
    public void output(HttpServletResponse response){
      majorService.output2Excel(response);
    }

    @PostMapping("upload")
    @RequiresPermissions("system:major:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), SysMajor.class,new SysMajorExcelListener(majorService)).sheet().doRead();
        return new ResultBody(0,"成功导入数据","success");
    }
}
