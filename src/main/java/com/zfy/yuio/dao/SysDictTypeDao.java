package com.zfy.yuio.dao;

import com.zfy.yuio.entity.SysDictType;
import org.springframework.stereotype.Repository;

/**
 *@Description:字典类型
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 20:29
*/
@Repository
public interface SysDictTypeDao {
    int add(SysDictType sysDictType);
}
