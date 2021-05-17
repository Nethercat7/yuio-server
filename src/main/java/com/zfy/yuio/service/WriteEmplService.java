package com.zfy.yuio.service;

import com.zfy.yuio.entity.write.WriteEmplInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 *@Description:就业情况填写
 *@Author:赵富源
 *@CreateDate:2021/4/26 23:47
*/
public interface WriteEmplService {
    int add(WriteEmplInfo params, MultipartFile file);

    WriteEmplInfo get(Long id);

    int upd(WriteEmplInfo params,MultipartFile file);
}
