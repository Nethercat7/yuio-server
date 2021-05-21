package com.zfy.yuio.service.impl;

import com.alibaba.excel.EasyExcel;
import com.zfy.yuio.dao.SysRoleDao;
import com.zfy.yuio.entity.system.SysRole;
import com.zfy.yuio.service.SysRoleService;
import com.zfy.yuio.utils.SnowflakeIdGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Description:Role mgt
 * @Author:赵富源
 * @CreateDate:2021/4/13 22:41
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleDao roleDao;

    SnowflakeIdGeneratorUtil snowflakeIdGeneratorUtil = new SnowflakeIdGeneratorUtil(5, 0);

    @Override
    public int add(SysRole params) {
        int status = validator(params,0);
        if (status == 0) {
            params.setRoleId(snowflakeIdGeneratorUtil.nextId());
            roleDao.add(params);
            savePerms(params);
        }
        return status;
    }

    @Override
    public List<SysRole> get() {
        List<SysRole> roles = roleDao.get();
        //获取当前角色所拥有的权限
        for (SysRole r : roles
        ) {
            if(r.getRoleStatus().equals("1")){
                r.setDisabled(true);
            }
            r.setPerms(roleDao.getRolePerms(r.getRoleId()));
        }
        return roles;
    }

    @Override
    public int del(Long id) {
        //先删除角色权限
        roleDao.delPerms(id);
        return roleDao.del(id);
    }

    @Override
    public int upd(SysRole params) {
        int status = validator(params,1);
        if (status == 0) {
            //先删除该角色下的所有权限
            roleDao.delPerms(params.getRoleId());
            //再添加权限
            savePerms(params);
            roleDao.upd(params);
        }
        return status;
    }

    @Override
    public void addFromExcel(List<SysRole> params) {
        for (SysRole r : params
        ) {
            r.setRoleId(snowflakeIdGeneratorUtil.nextId());
            r.setRoleStatus("0");
        }
        roleDao.addFromExcel(params);
    }

    @Override
    public List<SysRole> getByKeyword(String keyword) {
        return roleDao.getByKeyword(keyword);
    }

    private int validator(SysRole params, int type) {
        if (type == 0) {
            if (!ObjectUtils.isEmpty(roleDao.verify(params.getRoleName()))) {
                return 1;
            }
        } else {
            SysRole role = roleDao.getById(params.getRoleId());
            if (!params.getRoleName().equals(role.getRoleName())) {
                if (!ObjectUtils.isEmpty(roleDao.verify(params.getRoleName()))) return 1;
            }
        }
        return 0;
    }

    @Override
    public void output2Excel(HttpServletResponse response) {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = "role_data";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try{
            EasyExcel.write(response.getOutputStream(), SysRole.class).sheet("Sheet1").doWrite(get());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void savePerms(SysRole params) {
        for (Long perms : params.getPerms()
        ) {
            roleDao.addPerms(params.getRoleId(), perms);
        }
    }
}
