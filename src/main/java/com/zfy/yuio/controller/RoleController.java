package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.Role;
import com.zfy.yuio.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Role role) {
        int status = roleService.add(role);
        if (status != 1) {
            return new ResultBody(1, "添加失败", "error");
        }
        return new ResultBody(0, "成功添加", "success");
    }

    @GetMapping("get")
    public ResultBody get() {
        return new ResultBody(0, roleService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id") String id) {
        int status = roleService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "成功删除", "success");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Role role) {
        int status = roleService.upd(role);
        if (status != 1) {
            return new ResultBody(1, "修改失败", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }
}
