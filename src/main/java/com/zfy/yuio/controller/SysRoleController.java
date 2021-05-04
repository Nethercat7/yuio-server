package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.SysRole;
import com.zfy.yuio.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
