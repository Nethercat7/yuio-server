package com.zfy.yuio.controller;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.ResultBody;
import com.zfy.yuio.entity.StatsEmplResult;
import com.zfy.yuio.service.CmpRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 *@Description:就业率对比
 *@Author:Nethercat7
 *@CreateDate:2021/4/27 21:51
*/
@CrossOrigin
@RestController
@RequestMapping("cmp/rate")
public class CmpRateController {
    @Autowired
    private CmpRateService rateService;

    @PostMapping("getSelf")
    public ResultBody get(@RequestBody QueryParams params){
        StatsEmplResult result=rateService.get(params);
        if(ObjectUtils.isEmpty(result)){
            return new ResultBody(1,"未找到相关信息","success");
        }
        return new ResultBody(0,result,"success");
    }
}
