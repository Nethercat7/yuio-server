package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysUser;
import com.zfy.yuio.service.SysUserService;
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
    //@RequiresPermissions("system:user:add")
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
    //@RequiresPermissions("system:user:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=userService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }

    @PutMapping("upd")
    //@RequiresPermissions("system:user:upd")
    public ResultBody upd(@RequestBody SysUser params){
        int status=userService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }

    @GetMapping("getById")
    public ResultBody getById(@RequestParam("id") Long id){
        return new ResultBody(0,userService.getById(id));
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,userService.getByKeyword(keyword));
    }

    @PutMapping("updProfile")
    public ResultBody updProfile(@RequestBody SysUser params){
        int status=userService.updProfile(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"成功修改","success");
    }
}
