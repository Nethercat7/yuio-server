package com.zfy.yuio.controller;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.excel.ExcelStudent;
import com.zfy.yuio.entity.system.SysStudent;
import com.zfy.yuio.entity.write.WriteEmplInfo;
import com.zfy.yuio.listener.SysStudentExcelListener;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.service.WriteEmplService;
import com.zfy.yuio.utils.UsefulUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @Description:学生管理模块
 * @Author:赵富源
 * @CreateDate:2021/4/10 16:11
 */
@CrossOrigin
@RestController
@RequestMapping("sys/student")
public class SysStudentController {
    @Autowired
    private SysStudentService studentService;

    @Autowired
    private WriteEmplService writeEmplService;

    @Value("${file.path}")
    private String filepath;

    @PostMapping("add")
    @RequiresPermissions("system:student:add")
    public ResultBody add(@RequestBody SysStudent params) {
        int status = studentService.add(params);
        if (status == 1) {
            return new ResultBody(status, "学号已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "手机号码已存在", "error");
        }
        return new ResultBody(status, "添加成功", "success");
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
            return new ResultBody(status, "学号已存在", "error");
        } else if (status == 2) {
            return new ResultBody(status, "手机号码已存在", "error");
        }
        return new ResultBody(status, "修改成功", "success");
    }

    @GetMapping("getById")
    public ResultBody getById(@RequestParam("id") Long id) {
        return new ResultBody(0, studentService.getById(id));
    }

    @PutMapping("updProfile")
    public ResultBody updProfile(@RequestBody SysStudent params) {
        int status = studentService.updProfile(params);
        if (status == 2) {
            return new ResultBody(status, "手机号码存在", "error");
        }
        return new ResultBody(0, "成功修改", "success");
    }

    @PostMapping("output")
    @RequiresPermissions("system:student:output")
    public void output(@RequestBody QueryParams params, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("学生数据", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), SysStudent.class).sheet("sheet1").doWrite(studentService.get(params));
    }

    @PostMapping("upload")
    @RequiresPermissions("system:student:import")
    public ResultBody upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ExcelStudent.class, new SysStudentExcelListener(studentService)).sheet().doRead();
        return new ResultBody(0, "成功导入数据", "success");
    }

    @GetMapping("downloadProtocol")
    public void downloadProtocol(@RequestParam("code") String code,HttpServletResponse response) throws IOException {
        WriteEmplInfo info=writeEmplService.get(code);
        String path=filepath+info.getEmplProtocolFile();
        response.setContentType("application/pdf");
        UsefulUtil.download(path,code+".pdf",response);
    }
}
