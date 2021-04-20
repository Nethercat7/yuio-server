package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Work;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("work")
public class WorkController {
    @Autowired
    private WorkService workService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Work work){
        int status=workService.add(work);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0, "成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0, workService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id") String id){
        int status= workService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0, "成功删除","success");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Work work){
        int status=workService.upd(work);
        if(status!=1){
            return new ResultBody(1,"修改失败","error");
        }
        return new ResultBody(0, "成功修改","success");
    }

    @PostMapping("initial")
    public void initial(@RequestBody Work work){
        workService.initial(work);
    }
}
