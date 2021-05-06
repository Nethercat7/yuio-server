package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysPerms;
import com.zfy.yuio.service.SysPermsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
    @RequiresPermissions("system:perms:add")
    public ResultBody add(@RequestBody SysPerms params){
        int status=permsService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }

    @GetMapping("get")
    //@RequiresPermissions(value={"system:perms:get","system:role:*"},logical = Logical.OR)
    public ResultBody get(){
        return new ResultBody(0,permsService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:perms:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=permsService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:perms:upd")
    public ResultBody upd(@RequestBody SysPerms params){
        int status=permsService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,permsService.getByKeyword(keyword));
    }
}
