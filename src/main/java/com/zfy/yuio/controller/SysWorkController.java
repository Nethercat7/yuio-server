package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysWork;
import com.zfy.yuio.service.SysWorkService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("sys/work")
public class SysWorkController {
    @Autowired
    private SysWorkService workService;

    @PostMapping("add")
    @RequiresPermissions("system:work:add")
    public ResultBody add(@RequestBody SysWork params){
        int status=workService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0, "成功添加","success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:work:get")
    public ResultBody get(){
        return new ResultBody(0, workService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:work:del")
    public ResultBody del(@RequestParam("id") Long id){
        int status= workService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0, "成功删除","success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:work:upd")
    public ResultBody upd(@RequestBody SysWork params){
        int status=workService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0, "成功修改","success");
    }
}
