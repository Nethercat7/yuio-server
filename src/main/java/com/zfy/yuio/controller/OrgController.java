package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Org;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.OrgService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:组织管理模块
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 20:53
 */
@CrossOrigin
@RestController
@RequestMapping("org")
@RequiresPermissions("system:org:mgt")
public class OrgController {
    @Autowired
    private OrgService orgService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Org org){
        int status=orgService.add(org);
        if(status==1){
            return new ResultBody(0,"成功添加","success");
        }
        return new ResultBody(1,"添加失败","error");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,orgService.get(),"success");
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=orgService.del(id);
        if(status==1){
            return new ResultBody(0,"成功删除","success");
        }
        return new ResultBody(1,"删除失败，可能已经被删除","error");
    }

    @PostMapping("upd")
    public ResultBody upd(@RequestBody Org org){
        int status=orgService.upd(org);
        if(status==1){
            return new ResultBody(0,"成功修改","success");
        }
        return new ResultBody(1,"修改失败，请稍后重试","error");
    }
}
