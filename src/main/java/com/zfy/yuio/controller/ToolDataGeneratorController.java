package com.zfy.yuio.controller;

import com.zfy.yuio.service.ToolDataGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("tool/dataGenerator")
public class ToolDataGeneratorController {
    @Autowired
    private ToolDataGeneratorService toolDataGeneratorService;

    @GetMapping("generateClass")
    public void generateClass(@RequestParam("num") int num,@RequestParam("grade") int grade){
        toolDataGeneratorService.generateClass(num,grade);
    }

    @GetMapping("generateStudent")
    public void generateStudent(@RequestParam("num") int num,@RequestParam("grade") int grade){
        toolDataGeneratorService.generateStudent(num,grade);
    }
}
