package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysClass;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("sys/class")
public class SysClassController {
    @Autowired
    private SysClassService classService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysClass params){
        int status=classService.add(params);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,classService.get(),"success");
    }

    @DeleteMapping("del")
    public ResultBody add(@RequestParam("id") String id){
        int status=classService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败","error");
    }

    @PutMapping("upd")
    public ResultBody upd(@RequestBody SysClass params){
        int status=classService.upd(params);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败","error");
    }
}
