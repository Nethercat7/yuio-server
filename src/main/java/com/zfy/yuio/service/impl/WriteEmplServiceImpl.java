package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysStudentDao;
import com.zfy.yuio.dao.WriteEmplDao;
import com.zfy.yuio.entity.write.WriteEmplInfo;
import com.zfy.yuio.service.WriteEmplService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @Description:就业情况填写
 * @Author:赵富源
 * @CreateDate:2021/4/26 23:47
 */
@Service
public class WriteEmplServiceImpl implements WriteEmplService {
    @Autowired
    private WriteEmplDao emplDao;

    @Autowired
    private SysStudentDao studentDao;

    @Value("${file.path}")
    private String filePath;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(13, 0);

    @Override
    public int add(WriteEmplInfo params, MultipartFile file) {
        params.setEmplId(snowflakeIdGeneratorUtil.nextId());
        int status = emplDao.add(params);
        //添加意向城市和意向岗位
        if (status == 1) {
            if (!ObjectUtils.isEmpty(params.getIntentionCities())) {
                for (Long id : params.getIntentionCities()
                ) {
                    emplDao.addIntentionCities(params.getEmplStudentCode(), id);
                }
            }

            if (!ObjectUtils.isEmpty(params.getIntentionWorks())) {
                for (Long id : params.getIntentionWorks()
                ) {
                    emplDao.addIntentionWorks(params.getEmplStudentCode(), id);
                }
            }
        }
        //保存三方协议文件
        saveFile(params, file);
        return 0;
    }

    @Override
    public WriteEmplInfo get(String code) {
        WriteEmplInfo info = emplDao.get(code);
        if (!ObjectUtils.isEmpty(info)) {
            info.setIntentionCities(emplDao.getIntentionCities(code));
            info.setIntentionWorks(emplDao.getIntentionWorks(code));
        }
        return info;
    }

    @Override
    public int upd(WriteEmplInfo params, MultipartFile file) {
        //修改意向城市和意向岗位
        if (!ObjectUtils.isEmpty(params.getIntentionCities())) {
            emplDao.delIntentionCities(params.getEmplStudentCode());
            for (Long id : params.getIntentionCities()
            ) {
                emplDao.addIntentionCities(params.getEmplStudentCode(), id);
            }
        }

        if (!ObjectUtils.isEmpty(params.getIntentionWorks())) {
            emplDao.delIntentionWorks(params.getEmplStudentCode());
            for (Long id : params.getIntentionWorks()
            ) {
                emplDao.addIntentionWorks(params.getEmplStudentCode(), id);
            }
        }
        emplDao.upd(params);
        saveFile(params, file);
        return 0;
    }

    private void saveFile(WriteEmplInfo params, MultipartFile file) {
        if (!ObjectUtils.isEmpty(file)) {
            //配置三方协议
            Long id = params.getEmplId();
            String filename = id + ".pdf";
            try {
                file.transferTo(Paths.get(filePath + filename));
                params.setEmplProtocolFile(filename);
                emplDao.saveProtocolFile(params);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
