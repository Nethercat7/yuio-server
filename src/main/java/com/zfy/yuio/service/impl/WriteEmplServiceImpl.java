package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.WriteEmplDao;
import com.zfy.yuio.entity.write.WriteEmplInfo;
import com.zfy.yuio.service.WriteEmplService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Description:就业情况填写
 * @Author:Nethercat7
 * @CreateDate:2021/4/26 23:47
 */
@Service
public class WriteEmplServiceImpl implements WriteEmplService {
    @Autowired
    private WriteEmplDao emplDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(13, 0);

    @Override
    public int add(WriteEmplInfo params) {
        params.setEmplId(snowflakeIdGeneratorUtil.nextId());
        int status = emplDao.add(params);
        //添加意向城市和意向岗位
        if (status == 1) {
            if (!ObjectUtils.isEmpty(params.getIntentionCities())) {
                for (Long id : params.getIntentionCities()
                ) {
                    emplDao.addIntentionCities(params.getEmplStudentId(), id);
                }
            }

            if (!ObjectUtils.isEmpty(params.getIntentionWorks())) {
                for (Long id : params.getIntentionWorks()
                ) {
                    emplDao.addIntentionWorks(params.getEmplStudentId(), id);
                }
            }
        }
        return status;
    }

    @Override
    public WriteEmplInfo get(Long id) {
        WriteEmplInfo info = emplDao.get(id);
        if(!ObjectUtils.isEmpty(info)){
            info.setIntentionCities(emplDao.getIntentionCities(id));
            info.setIntentionWorks(emplDao.getIntentionWorks(id));
        }
        return info;
    }

    @Override
    public int upd(WriteEmplInfo params) {
        //修改意向城市和意向岗位
        if (!ObjectUtils.isEmpty(params.getIntentionCities())) {
            emplDao.delIntentionCities(params.getEmplStudentId());
            for (Long id : params.getIntentionCities()
            ) {
                emplDao.addIntentionCities(params.getEmplStudentId(), id);
            }
        }

        if (!ObjectUtils.isEmpty(params.getIntentionWorks())) {
            emplDao.delIntentionWorks(params.getEmplStudentId());
            for (Long id : params.getIntentionWorks()
            ) {
                emplDao.addIntentionWorks(params.getEmplStudentId(), id);
            }
        }
        return emplDao.upd(params);
    }
}
