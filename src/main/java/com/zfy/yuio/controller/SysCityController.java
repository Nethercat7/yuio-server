package com.zfy.yuio.controller;

import com.zfy.yuio.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("sys/city")
public class SysCityController {
    @Autowired
    private SysCityService cityService;

    /*@PostMapping("add")
    @RequiresPermissions("system:city:add")
    public ResultBody add(@RequestBody SysCity params) {
        int status = cityService.add(params);
        if (status != 1) {
            return new ResultBody(1, "添加失败", "error");
        }
        return new ResultBody(0, "成功添加", "success");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:city:get")
    public ResultBody get() {
        return new ResultBody(0, cityService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:city:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = cityService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:city:upd")
    public ResultBody upd(@RequestBody SysCity params) {
        int status = cityService.upd(params);
        if (status != 1) {
            return new ResultBody(1, "修改失败", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,cityService.getByKeyword(keyword));
    }*/
}
