package com.zfy.yuio.controller;

import com.zfy.yuio.entity.EStatus;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.Student;
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

    @PostMapping("resetPwd")
    public ResultBody resetPwd(@RequestBody Map<String, Object> map) {
        int status = sysService.resetPwd(map);
        if (status == 1) {
            return new ResultBody(0, "成功重置", "success");
        }
        return new ResultBody(1, "重置失败", "error");
    }

    @PostMapping("login")
    public ResultBody login(@RequestBody Map<String, Object> map) {
        int status = sysService.login(map);
        if (status == 1) {
            return new ResultBody(1, "账号不正确", "error");
        } else if (status == 2) {
            return new ResultBody(2, "密码错误", "error");
        }
        return new ResultBody(0, "登录成功", "success");
    }

    @PostMapping("saveEmploymentStatus")
    public ResultBody saveEmploymentStatus(@RequestBody EStatus eStatus) {
        int status = sysService.saveEmploymentStatus(eStatus);
        if (status != 1) {
            return new ResultBody(1, "提交失败", "success");
        }
        return new ResultBody(1, "提交成功", "error");
    }

    @PostMapping("studentLogin")
    public ResultBody login(@RequestBody Student student) {
        return sysService.studentLogin(student);
    }
}
