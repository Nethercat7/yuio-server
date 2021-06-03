package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.system.SysPerms;
import com.zfy.yuio.listener.SysPermsExcelListener;
import com.zfy.yuio.service.SysPermsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:Menu mgt
 * @Author:赵富源
 * @CreateDate:2021/4/16 21:26
 */
@CrossOrigin
@RestController
@RequestMapping("sys/perms")
public class SysPermsController {
    @Autowired
    private SysPermsService permsService;

    @PostMapping("add")
    @RequiresPermissions("system:perms:add")
    public ResultBody add(@RequestBody SysPerms params) {
        int status = permsService.add(params);
        if (status == 1) {
            return new ResultBody(status, "名称已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "标识符已存在", "error");
        }
        return new ResultBody(status, "成功添加", "success");
    }

    @GetMapping("get")
    //@RequiresPermissions(value={"system:perms:get","system:role:*"},logical = Logical.OR)
    public ResultBody get() {
        return new ResultBody(0, permsService.get());
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:perms:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = permsService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:perms:upd")
    public ResultBody upd(@RequestBody SysPerms params) {
        int status = permsService.upd(params);
        if (status == 1) {
            return new ResultBody(status, "名称已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "标识符已存在", "error");
        } else if (status == 3) {
            return new ResultBody(status, "请求地址已存在", "error");
        }
        return new ResultBody(status, "成功修改", "success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword) {
        return new ResultBody(0, permsService.getByKeyword(keyword));
    }

    @GetMapping("output")
    @RequiresPermissions("system:perms:output")
    public void output(HttpServletResponse response) throws IOException {
       permsService.output2Excel(response);
    }

    @PostMapping("upload")
    @RequiresPermissions("system:perms:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), SysPerms.class, new SysPermsExcelListener(permsService)).sheet().doRead();
        return new ResultBody(0, "成功导入数据", "success");
    }
}
