package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Cls;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.ClsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("cls")
public class ClsController {
    @Autowired
    private ClsService clsService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Cls cls){
        int status=clsService.add(cls);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,clsService.get(),"success");
    }
}
