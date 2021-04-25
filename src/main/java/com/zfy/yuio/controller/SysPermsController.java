package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysPerms;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysPermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:26
*/
@CrossOrigin
@RestController
@RequestMapping("sys/perms")
public class SysPermsController {
    @Autowired
    private SysPermsService permsService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysPerms params){
        int status=permsService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,permsService.get());
    }

    @DeleteMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=permsService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }

    @PutMapping("upd")
    public ResultBody upd(@RequestBody SysPerms params){
        int status=permsService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }
}
