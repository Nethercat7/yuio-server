package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.StatsEmplInfo;
import com.zfy.yuio.service.WriteEmplService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("write/empl")
public class WriteEmplController {
    @Autowired
    private WriteEmplService emplService;

    @PostMapping("add")
    @RequiresPermissions("write:empl:write")
    public ResultBody add(@RequestBody StatsEmplInfo params){
        int status=emplService.add(params);
        if(status!=1){
            return new ResultBody(1,"提交失败","error");
        }
        return new ResultBody(0,"提交成功","success");
    }

    @GetMapping("get")
    public ResultBody get(@RequestParam("id") String id){
        StatsEmplInfo emplInfo=emplService.get(id);
        if(ObjectUtils.isEmpty(emplInfo)){
            return new ResultBody(1,"未找到相关信息","success");
        }
        return new ResultBody(0,emplInfo,"success");
    }

    @PutMapping("upd")
    @RequiresPermissions("write:empl:write")
    public ResultBody upd(@RequestBody StatsEmplInfo params){
        int status=emplService.upd(params);
        if(status!=1){
            return new ResultBody(1,"提交失败","error");
        }
        return new ResultBody(0,"提交成功","success");
    }
}
