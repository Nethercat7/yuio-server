package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelRole;
import com.zfy.yuio.entity.system.SysRole;
import com.zfy.yuio.listener.SysRoleExcelListener;
import com.zfy.yuio.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("sys/role")
public class SysRoleController {
    @Autowired
    private SysRoleService roleService;

    @PostMapping("add")
    @RequiresPermissions("system:role:add")
    public ResultBody add(@RequestBody SysRole params) {
        int status = roleService.add(params);
        if (status != 1) {
            return new ResultBody(1, "添加失败", "error");
        }
        return new ResultBody(0, "成功添加", "success");
    }

    @GetMapping("get")
    //@RequiresPermissions(value = {"system:role:get","system:user:*"},logical = Logical.OR)
    public ResultBody get() {
        return new ResultBody(0, roleService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:role:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = roleService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:role:upd")
    public ResultBody upd(@RequestBody SysRole params) {
        int status = roleService.upd(params);
        if (status != 1) {
            return new ResultBody(1, "修改失败", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }

    @GetMapping("output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysRole.class).sheet("Sheet1").doWrite(roleService.get());
    }

    @PostMapping("upload")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelRole.class,new SysRoleExcelListener(roleService)).sheet().doRead();
        return new ResultBody(0,"成功导入数据","success");
    }
}
