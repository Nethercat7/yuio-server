package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelDictType;
import com.zfy.yuio.entity.system.SysDictType;
import com.zfy.yuio.listener.SysDictTypeExcelListener;
import com.zfy.yuio.service.SysDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@CrossOrigin
@RestController
@RequestMapping("sys/dict/type")
public class SysDictTypeController {
    @Autowired
    private SysDictTypeService sysDictTypeService;

    @PostMapping("add")
    @RequiresPermissions("system:dict:add")
    public ResultBody add(@RequestBody SysDictType params) {
        int status = sysDictTypeService.add(params);
        if (status == 1) {
            return new ResultBody(status, "名称已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "类型已存在", "error");
        }
        return new ResultBody(status, "添加成功", "success");
    }

    @GetMapping("get")
    public ResultBody get() {
        return new ResultBody(0, sysDictTypeService.get());
    }

    @DeleteMapping("del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = sysDictTypeService.del(id);
        if (status != 1) {
            return new ResultBody(1, "删除失败", "error");
        }
        return new ResultBody(0, "删除成功", "success");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:dict:upd")
    public ResultBody upd(@RequestBody SysDictType params) {
        int status = sysDictTypeService.upd(params);
        if (status == 1) {
            return new ResultBody(status, "名称已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "类型已存在", "error");
        }
        return new ResultBody(status, "修改成功", "success");
    }

    @GetMapping("getByKeyword")
    public ResultBody getByKeyword(@RequestParam("keyword") String keyword) {
        return new ResultBody(0, sysDictTypeService.getByKeyword(keyword));
    }

    @GetMapping("output")
    @RequiresPermissions("system:dict:output")
    public void output(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("字典类型数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysDictType.class).sheet("Sheet1").doWrite(sysDictTypeService.get());
    }

    @PostMapping("upload")
    @RequiresPermissions("system:dict:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelDictType.class, new SysDictTypeExcelListener(sysDictTypeService)).sheet().doRead();
        return new ResultBody(0, "成功导入数据", "success");
    }
}
