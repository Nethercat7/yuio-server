package com.zfy.yuio.service.impl;

import com.zfy.yuio.dao.SysPermsDao;
import com.zfy.yuio.entity.excel.ExcelPerms;
import com.zfy.yuio.entity.system.SysPerms;
import com.zfy.yuio.service.SysPermsService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysPermsServiceImpl implements SysPermsService {
    @Autowired
    private SysPermsDao permsDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(6, 0);

    @Override
    public int add(SysPerms params) {
        int status = validate(params, 0);
        if (status == 0) {
            params.setPermsId(snowflakeIdGeneratorUtil.nextId());
            if (ObjectUtils.isEmpty(params.getPermsPid())) {
                params.setPermsPid(0L);
                params.setPermsLevel(0);
            } else {
                SysPerms perms = permsDao.getById(params.getPermsPid());
                params.setPermsLevel(perms.getPermsLevel() + 1);
            }
            permsDao.add(params);
        }
        return status;
    }

    @Override
    public List<SysPerms> get() {
        List<SysPerms> perms = permsDao.get();
        List<SysPerms> permsList = new ArrayList<>();
        for (SysPerms p : perms
        ) {
            if (p.getPermsPid() == 0) {
                permsList.add(p);
            }
        }
        for (SysPerms m : permsList
        ) {
            m.setChildren(getChildren(m.getPermsId(), perms));
        }
        return permsList;
    }

    @Override
    public int del(Long id) {
        return permsDao.del(id);
    }

    @Override
    public int upd(SysPerms params) {
        int status = validate(params, 1);
        if (status == 0) {
            if (ObjectUtils.isEmpty(params.getPermsPid())) {
                params.setPermsPid(0L);
            }
            permsDao.upd(params);
        }
        return status;
    }

    @Override
    public List<String> getUserPerms(String code) {
        return permsDao.getUserPerms(code);
    }

    @Override
    public List<String> getStudentPerms(String code) {
        return permsDao.getStudentPerms(code);
    }

    @Override
    public List<SysPerms> getByKeyword(String keyword) {
        return permsDao.getByKeyword(keyword);
    }

    @Override
    public List<SysPerms> getWithoutConvert() {
        return permsDao.get();
    }

    @Override
    public void addFromExcel(List<ExcelPerms> params) {
        permsDao.addFromExcel(params);
    }


    private int validate(SysPerms params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsName()))) return 1;
            if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsMark()))) return 2;
            if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsUrl()))) return 3;
        } else {
            SysPerms p = permsDao.getById(params.getPermsId());
            if (!p.getPermsName().equals(params.getPermsName())) {
                if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsName()))) return 1;
            } else if (!p.getPermsMark().equals(params.getPermsMark())) {
                if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsMark()))) return 2;
            } else if (!p.getPermsUrl().equals(params.getPermsUrl())) {
                if (!ObjectUtils.isEmpty(permsDao.verify(params.getPermsUrl()))) return 3;
            }
        }
        return 0;
    }

    private List<SysPerms> getChildren(Long pid, List<SysPerms> list) {
        List<SysPerms> children = new ArrayList<>();
        for (SysPerms p : list
        ) {
            if (p.getPermsPid().equals(pid)) {
                children.add(p);
            }
        }

        for (SysPerms m : children
        ) {
            m.setChildren(getChildren(m.getPermsId(), list));
        }
        return children;
    }
}
