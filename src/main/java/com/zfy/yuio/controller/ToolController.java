package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
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
    public ResultBody randomCls(@RequestParam("num") int num) {
        toolService.randomCls(num);
        return new ResultBody(0, "oo");
    }

    @GetMapping("randomStudent")
    public ResultBody randomStudent(@RequestParam("num") int num) {
        toolService.randomStudent(num);
        return new ResultBody(0, "oo");
    }

    @GetMapping("randomEStatus")
    public ResultBody randomEStatus(@RequestParam("num") int num) {
        toolService.randomEStatus(num);
        return new ResultBody(0, "oo");
    }
}
