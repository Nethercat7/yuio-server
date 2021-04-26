package com.zfy.yuio.dao;

import com.zfy.yuio.entity.StatsEmplInfo;
import org.springframework.stereotype.Repository;

/**
 *@Description:就业情况填写
 *@Author:Nethercat7
 *@CreateDate:2021/4/26 23:42
*/
@Repository
public interface WriteEmplDao {
    int add(StatsEmplInfo params);

    StatsEmplInfo get(String id);

    int upd(StatsEmplInfo params);
}
