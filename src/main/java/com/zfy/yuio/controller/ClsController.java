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

    @GetMapping("del")
    public ResultBody add(@RequestParam("id") String id){
        int status=clsService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败","error");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Cls cls){
        int status=clsService.upd(cls);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败","error");
    }
}
