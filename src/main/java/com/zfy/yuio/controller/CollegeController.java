package com.zfy.yuio.controller;

import com.zfy.yuio.entity.SysCollege;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.CollegeService;
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
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @PostMapping("add")
    public ResultBody add(@RequestBody SysCollege params){
        int status=collegeService.add(params);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,collegeService.get(),"success");
    }

    @DeleteMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=collegeService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PutMapping("upd")
    public ResultBody upd(@RequestBody SysCollege params){
        int status=collegeService.upd(params);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败，请稍后重试","error");
    }
}
