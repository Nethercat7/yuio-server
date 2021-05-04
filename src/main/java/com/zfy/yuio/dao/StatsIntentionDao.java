package com.zfy.yuio.dao;

import com.zfy.yuio.entity.WriteEmplInfo;
import com.zfy.yuio.entity.WriteEmplResult;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:数据统计模块
 * @Author:Nethercat7
 * @CreateDate:2021/4/19 17:32
 */
@Repository
public interface StatsIntentionDao {
    List<WriteEmplResult> getCityInfo(WriteEmplInfo params);
    List<WriteEmplResult> getWorkInfo(WriteEmplInfo params);
}
