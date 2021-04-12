package com.zfy.yuio.controller;

import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.Usr;
import com.zfy.yuio.service.UsrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:User mgt
 *@Author:Nethercat7
 *@CreateDate:2021/4/12 17:09
*/
@CrossOrigin
@RestController
@RequestMapping("usr")
public class UsrController {
    @Autowired
    private UsrService usrService;

    @PostMapping("add")
    public ResultBody add(@RequestBody Usr usr){
        int status=usrService.add(usr);
        if(status!=1){
            return new ResultBody(1,"添加失败","error");
        }
        return new ResultBody(0,"成功添加","success");
    }
}
