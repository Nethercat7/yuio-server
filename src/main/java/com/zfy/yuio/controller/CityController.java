package com.zfy.yuio.controller;

import com.zfy.yuio.entity.City;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("city")
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("add")
    public ResultBody add(@RequestBody City city){
        int status=cityService.add(city);
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
    public ResultBody upd(@RequestBody City city){
        int status=cityService.upd(city);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0, "成功修改","success");
    }

    @PostMapping("initial")
    public void initial(@RequestBody City city){
        cityService.initial(city);
    }
}
