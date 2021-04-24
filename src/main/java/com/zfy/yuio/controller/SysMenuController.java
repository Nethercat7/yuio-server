package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysPerms;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:26
*/
@CrossOrigin
@RestController
@RequestMapping("menu")
public class SysMenuController {
    @Autowired
    private SysMenuService menuService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysPerms params){
        int status=menuService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,menuService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=menuService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody SysPerms params){
        int status=menuService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }
}
