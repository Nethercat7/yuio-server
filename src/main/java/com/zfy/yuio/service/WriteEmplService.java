package com.zfy.yuio.service;

import com.zfy.yuio.entity.StatsEmplInfo;

/**
 *@Description:就业情况填写
 *@Author:Nethercat7
 *@CreateDate:2021/4/26 23:47
*/
public interface WriteEmplService {
    int add(StatsEmplInfo params);

    StatsEmplInfo get(String id);

    int upd(StatsEmplInfo params);
}
