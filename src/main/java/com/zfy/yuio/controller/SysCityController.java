package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysCity;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("city")
public class SysCityController {
    @Autowired
    private SysCityService cityService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysCity params){
        int status=cityService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0, "成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0, cityService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id") String id){
        int status= cityService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0, "成功删除","success");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody SysCity params){
        int status=cityService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0, "成功修改","success");
    }

    @PostMapping("initial")
    public void initial(@RequestBody SysCity params){
        cityService.initial(params);
    }
}
