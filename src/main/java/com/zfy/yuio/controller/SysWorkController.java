package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysWork;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("work")
public class SysWorkController {
    @Autowired
    private SysWorkService workService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysWork params){
        int status=workService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0, "成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0, workService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id") String id){
        int status= workService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0, "成功删除","success");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody SysWork params){
        int status=workService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0, "成功修改","success");
    }

    @PostMapping("initial")
    public void initial(@RequestBody SysWork params){
        workService.initial(params);
    }
}
