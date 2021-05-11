package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelStudent;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.listener.SysStudentExcelListener;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.utils.UsefulUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Description:学生管理模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/10 16:11
 */
@CrossOrigin
@RestController
@RequestMapping("sys/student")
public class SysStudentController {
    @Autowired
    private SysStudentService studentService;

    @PostMapping("add")
    @RequiresPermissions("system:student:add")
    public ResultBody add(@RequestBody SysStudent params) {
        int status = studentService.add(params);
        if (status == 1) {
            return new ResultBody(0, "成功添加", "success");
        }
        return new ResultBody(1, "添加失败", "error");
    }

    @PostMapping("get")
    //@RequiresPermissions("system:student:get")
    public ResultBody get(@RequestBody QueryParams params) {
        return new ResultBody(0, studentService.get(params));
    }

    @DeleteMapping("del")
    @RequiresPermissions("system:student:del")
    public ResultBody del(@RequestParam("id") Long id) {
        int status = studentService.del(id);
        if (status == 1) {
            return new ResultBody(0, "成功删除", "success");
        }
        return new ResultBody(1, "删除失败", "error");
    }

    @PutMapping("upd")
    @RequiresPermissions("system:student:upd")
    public ResultBody upd(@RequestBody SysStudent params) {
        int status = studentService.upd(params);
        if (status == 1) {
            return new ResultBody(0, "成功修改", "success");
        }
        return new ResultBody(1, "修改失败", "error");
    }

    @GetMapping("getById")
    public ResultBody getById(@RequestParam("id") Long id) {
        return new ResultBody(0, studentService.getById(id));
    }

    @PutMapping("updProfile")
    public ResultBody updProfile(@RequestBody SysStudent params) {
        int status = studentService.updProfile(params);
        if (status != 1) {
            return new ResultBody(1, "修改失败", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }

    @PostMapping("output")
    public void output(@RequestBody QueryParams params, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("学生数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysStudent.class).sheet("sheet1").doWrite(studentService.get(params));
    }

    @PostMapping("upload")
    public void upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelStudent.class, new SysStudentExcelListener(studentService)).sheet().doRead();
    }

    @GetMapping("download")
    public void download(@RequestParam("type") String type, HttpServletResponse response) throws IOException {
        String filename = "学生数据上传模板." + type;
        String filepath = ClassUtils.getDefaultClassLoader().getResource("").getPath()+ "static/excel/" + type + "/" + filename;
        UsefulUtil.download(filepath,filename,response);
    }
}
