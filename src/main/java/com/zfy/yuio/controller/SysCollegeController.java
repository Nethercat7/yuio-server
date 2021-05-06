package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.service.SysCollegeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:院系管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 20:53
 */
@CrossOrigin
@RestController
@RequestMapping("sys/college")
public class SysCollegeController {
    @Autowired
    private SysCollegeService collegeService;

    @PostMapping("add")
    @RequiresPermissions("system:college:add")
    public ResultBody add(@RequestBody SysCollege params){
        int status=collegeService.add(params);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    //@RequiresPermissions(value = {"system:college:get","system:major:*"},logical = Logical.OR)
    public ResultBody get(){
        return new ResultBody(0,collegeService.get(),"success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:college:del")
    public ResultBody del(@RequestParam("id")Long id){
        int status=collegeService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:college:upd")
    public ResultBody upd(@RequestBody SysCollege params){
        int status=collegeService.upd(params);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败，请稍后重试","error");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword){
        return new ResultBody(0,collegeService.getByKeyword(keyword));
    }
}
