package com.zfy.yuio.controller;

import com.zfy.yuio.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:系统工具
 * @Author:Nethercat7
 * @CreateDate:2021/4/18 18:15
 */
@CrossOrigin
@RestController
@RequestMapping("tool")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("randomCls")
    public void randomCls(@RequestParam("num") int num,@RequestParam("grade") int grade) {
        toolService.randomCls(num,grade);
    }

    @GetMapping("randomStudent")
    public void randomStudent(@RequestParam("num") int num,@RequestParam("grade") int grade) {
        toolService.randomStudent(num,grade);
    }

    @GetMapping("randomEStatus")
    public void randomEStatus(@RequestParam("num") int num,@RequestParam("grade") int grade) {
        toolService.randomEStatus(num,grade);
    }
}
