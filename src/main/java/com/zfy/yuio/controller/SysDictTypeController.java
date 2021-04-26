package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysDictType;
import com.zfy.yuio.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("sys/dict/type")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictTypeService;

    @PostMapping("add")
    @RequiresPermissions("system:dict:add")
    public ResultBody add(@RequestBody SysDictType params){
        int status=sysDictTypeService.add(params);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"添加成功","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,sysDictTypeService.get());
    }

    @DeleteMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=sysDictTypeService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"删除成功","success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:dict:upd")
    public ResultBody upd(@RequestBody SysDictType params){
        int status=sysDictTypeService.upd(params);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0,"修改成功","success");
    }
}
