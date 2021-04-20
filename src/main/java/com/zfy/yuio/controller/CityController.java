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
        cityService.add(city);
        return new ResultBody(0,null);
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0, cityService.get());
    }
}
