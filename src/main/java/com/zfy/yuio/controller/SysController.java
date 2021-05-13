package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.SysService;
import com.zfy.yuio.utils.UsefulUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description:系统功能模块
 * @Author:赵富源
 * @CreateDate:2021/4/12 0:18
 */
@CrossOrigin
@RestController
@RequestMapping("sys")
public class SysController {
    @Autowired
    private SysService sysService;

    @PutMapping("resetPwd")
    @RequiresPermissions(value = {"system:user:reset", "system:student:reset"}, logical = Logical.OR)
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
    public ResultBody getCollegeAndMajor() {
        return new ResultBody(0, sysService.getCollegeAndMajor(), "success");
    }

    @GetMapping("getCompleteOrg")
    public ResultBody getFullOrg(@RequestParam("grade") int grade) {
        return new ResultBody(0, sysService.getFullOrg(grade), "success");
    }

    @GetMapping("getGrade")
    public ResultBody getGrade() {
        List<Integer> grades = sysService.getGrade();
        if (ObjectUtils.isEmpty(grades)) {
            return new ResultBody(1, "未找到相关数据", "success");
        }
        return new ResultBody(0, grades, "success");
    }

    @PutMapping("changePwd")
    public ResultBody changePwd(@RequestBody Map<String, Object> params) {
        int status = sysService.changePwd(params);
        if (status == 1) {
            return new ResultBody(0, "修改成功，请重新登录", "success");
        } else if (status == 2) {
            return new ResultBody(2, "旧密码不正确", "error");
        }
        return new ResultBody(1, "修改失败", "error");
    }

    @GetMapping("getMenus")
    public ResultBody getMenus(@RequestParam("type") String type, @RequestParam("id") Long id) {
        return new ResultBody(0, sysService.getMenus(type, id));
    }

    @GetMapping("getTemplate")
    public void getTemplate(@RequestParam("template") String template, @RequestParam("type") String type, HttpServletResponse response) throws IOException {
        String filename = template +"."+ type;
        String filepath = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/excel/" + type + "/" + filename;
        UsefulUtil.download(filepath, filename, response);
    }
}
