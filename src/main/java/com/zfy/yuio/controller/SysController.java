package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Description:系统功能模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 0:18
 */
@CrossOrigin
@RestController
@RequestMapping("sys")
public class SysController {
    @Autowired
    private SysService sysService;

    @PutMapping("resetPwd")
    public ResultBody resetPwd(@RequestBody Map<String, Object> map) {
        int status = sysService.resetPwd(map);
        if (status == 1) {
            return new ResultBody(0, "成功重置", "success");
        }
        return new ResultBody(1, "重置失败", "error");
    }

    @PostMapping("login")
    public ResultBody login(@RequestBody Map<String, Object> map) {
        return sysService.login(map);
    }

    @GetMapping("getCollegeAndMajor")
    public ResultBody getCollegeAndMajor(){
        return new ResultBody(0,sysService.getCollegeAndMajor(),"success");
    }

    @GetMapping("getFullOrg")
    public ResultBody getFullOrg(@RequestParam("grade") int grade){
        return new ResultBody(0,sysService.getFullOrg(grade),"success");
    }

    @GetMapping("getGrade")
    public ResultBody getGrade(){
        return new ResultBody(0,sysService.getGrade(),"success");
    }
}
