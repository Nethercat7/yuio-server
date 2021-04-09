package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Major;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:专业管理
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 20:53
 */
@CrossOrigin
@RestController
@RequestMapping("major")
public class MajorController {
    @Autowired
    private MajorService majorService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Major major){
        int status=majorService.add(major);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,majorService.get(),"success");
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=majorService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Major major){
        int status=majorService.upd(major);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败，请稍后重试","error");
    }
}
