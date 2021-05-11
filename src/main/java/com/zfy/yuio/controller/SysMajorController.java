package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.system.SysMajor;
import com.zfy.yuio.service.SysMajorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 20:53
 */
@CrossOrigin
@RestController
@RequestMapping("sys/major")
public class SysMajorController {
    @Autowired
    private SysMajorService majorService;

    @PostMapping("add")
    @RequiresPermissions("system:major:add")
    public ResultBody add(@RequestBody SysMajor params){
        int status=majorService.add(params);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    //@RequiresPermissions("system:major:get")
    public ResultBody get(){
        return new ResultBody(0,majorService.get(),"success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:major:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=majorService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:major:upd")
    public ResultBody upd(@RequestBody SysMajor params){
        int status=majorService.upd(params);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败，请稍后重试","error");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,majorService.getByKeyword(keyword));
    }
}
