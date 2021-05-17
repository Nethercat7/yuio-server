package com.zfy.yuio.dao;

import com.zfy.yuio.entity.write.WriteEmplInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *@Description:就业情况填写
 *@Author:赵富源
 *@CreateDate:2021/4/26 23:42
*/
@Repository
public interface WriteEmplDao {
    int add(WriteEmplInfo params);

    WriteEmplInfo get(String code);

    int upd(WriteEmplInfo params);

    int addIntentionCities(String studentCode,Long cityId);

    int addIntentionWorks(String studentCode,Long workId);

    int delIntentionCities(String code);

    int delIntentionWorks(String code);

    List<Long> getIntentionCities(String code);

    List<Long> getIntentionWorks(String code);

    void saveProtocolFile(WriteEmplInfo params);
}
