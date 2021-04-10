package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Student;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:学生管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/10 16:11
*/
@CrossOrigin
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    
    @PostMapping("add")
    public ResultBody add(@RequestBody Student student){
        int status=studentService.add(student);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,studentService.get(),"success");
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id") String id){
        int status=studentService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败","error");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Student student){
        int status=studentService.upd(student);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败","error");
    }
}
