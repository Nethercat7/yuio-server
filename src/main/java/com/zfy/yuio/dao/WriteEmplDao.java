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

    WriteEmplInfo get(Long id);

    int upd(WriteEmplInfo params);

    int addIntentionCities(Long studentId,Long cityId);

    int addIntentionWorks(Long studentId,Long workId);

    int delIntentionCities(Long id);

    int delIntentionWorks(Long id);

    List<Long> getIntentionCities(Long id);

    List<Long> getIntentionWorks(Long id);

    void saveProtocolFile(WriteEmplInfo params);
}
