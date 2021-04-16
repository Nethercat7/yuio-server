package com.zfy.yuio.controller;

import com.zfy.yuio.entity.Menu;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:Menu mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/16 21:26
*/
@CrossOrigin
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Menu menu){
        int status=menuService.add(menu);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }

    @GetMapping("get")
    public ResultBody get(){
        return new ResultBody(0,menuService.get());
    }

    @GetMapping("del")
    public ResultBody del(@RequestParam("id")String id){
        int status=menuService.del(id);
        if(status!=1){
            return new ResultBody(1,"删除失败","error");
        }
        return new ResultBody(0,"成功删除","success");
    }
}
