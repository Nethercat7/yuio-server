package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysUser;
import com.zfy.yuio.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:09
*/
@CrossOrigin
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @PostMapping("add")
    @RequiresPermissions("system:user:add")
    public ResultBody add(@RequestBody SysUser params){
        int status=userService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,userService.get(),"success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:user:del")
    public ResultBody del(@RequestParam("id")String id){
        int status=userService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:user:upd")
    public ResultBody upd(@RequestBody SysUser params){
        int status=userService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }
}
