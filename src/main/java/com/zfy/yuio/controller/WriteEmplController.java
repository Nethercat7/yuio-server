package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.write.WriteEmplInfo;
import com.zfy.yuio.service.WriteEmplService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("write/empl")
public class WriteEmplController {
    @Autowired
    private WriteEmplService emplService;

    @PostMapping("add")
    @RequiresPermissions("write:empl:write")
    public ResultBody add(@RequestPart("params") WriteEmplInfo params, @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        int status = emplService.add(params,file);
        return new ResultBody(status, "提交成功", "success");
    }

    @GetMapping("get")
    public ResultBody get(@RequestParam("code") String code) {
        WriteEmplInfo emplInfo = emplService.get(code);
        if (ObjectUtils.isEmpty(emplInfo)) {
            return new ResultBody(1, "未找到相关信息", "success");
        }
        return new ResultBody(0, emplInfo, "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("write:empl:write")
    public ResultBody upd(@RequestPart("params") WriteEmplInfo params, @RequestPart(value = "file", required = false) MultipartFile file) throws IOException {
        int status = emplService.upd(params,file);
        return new ResultBody(status, "提交成功", "success");
    }
}
