package com.zfy.yuio.dao;

import com.zfy.yuio.entity.QueryParams;
import com.zfy.yuio.entity.StatsEmplInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:就业率对比
 * @Author:Nethercat7
 * @CreateDate:2021/4/27 21:10
 */
@Repository
public interface CmpRateDao {
    List<StatsEmplInfo> get(QueryParams params);
}

