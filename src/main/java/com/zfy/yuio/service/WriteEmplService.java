package com.zfy.yuio.service;

import com.zfy.yuio.entity.write.WriteEmplInfo;

/**
 *@Description:就业情况填写
 *@Author:Nethercat7
 *@CreateDate:2021/4/26 23:47
*/
public interface WriteEmplService {
    int add(WriteEmplInfo params);

    WriteEmplInfo get(Long id);

    int upd(WriteEmplInfo params);
}
