package com.zfy.yuio.service;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.WriteEmplResult;

/**
 *@Description:就业率对比
 *@Author:Nethercat7
 *@CreateDate:2021/4/27 21:36
*/
public interface CmpRateService {
    WriteEmplResult get(QueryParams params);
}
