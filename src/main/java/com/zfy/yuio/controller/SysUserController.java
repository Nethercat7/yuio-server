package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelUser;
import com.zfy.yuio.entity.system.SysUser;
import com.zfy.yuio.listener.SysUserExcelListener;
import com.zfy.yuio.service.SysUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Description:User mgt
 * @Author:Nethercat7
 * @CreateDate:2021/4/12 17:09
 */
@CrossOrigin
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Autowired
    private SysUserService userService;

    @PostMapping("add")
    @RequiresPermissions("system:user:add")
    public ResultBody add(@RequestBody SysUser params) {
        int status = userService.add(params);
        if (status == 1) {
            return new ResultBody(status, "工号已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "手机号码存在", "error");
        }
        return new ResultBody(status, "成功添加", "success");
    }

    @GetMapping("get")
    public ResultBody get() {
        return new ResultBody(0, userService.get(), "success");
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:user:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = userService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:user:upd")
    public ResultBody upd(@RequestBody SysUser params) {
        int status = userService.upd(params);
        if (status == 1) {
            return new ResultBody(status, "工号已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "手机号码存在", "error");
        }
        return new ResultBody(status, "成功修改", "success");
    }

    @GetMapping("getById")
    public ResultBody getById(@RequestParam("id") Long id) {
        return new ResultBody(0, userService.getById(id));
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword) {
        return new ResultBody(0, userService.getByKeyword(keyword));
    }

    @PutMapping("updProfile")
    public ResultBody updProfile(@RequestBody SysUser params) {
        int status = userService.updProfile(params);
        if (status == 2) {
            return new ResultBody(status, "手机号码存在", "error");
        }
        return new ResultBody(status, "成功修改", "success");
    }

    @GetMapping("output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysUser.class).sheet("Sheet1").doWrite(userService.get());
    }

    @PostMapping("upload")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelUser.class, new SysUserExcelListener(userService)).sheet().doRead();
        return new ResultBody(0, "成功导入数据", "success");
    }
}
