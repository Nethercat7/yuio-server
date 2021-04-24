package com.zfy.yuio.realms;

import com.zfy.yuio.entity.SysStudent;
import com.zfy.yuio.entity.Token;
import com.zfy.yuio.entity.SysUser;
import com.zfy.yuio.service.SysMenuService;
import com.zfy.yuio.service.SysStudentService;
import com.zfy.yuio.service.SysUsrService;
import com.zfy.yuio.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private SysUsrService usrService;

    @Autowired
    private SysStudentService studentService;

    @Autowired
    private SysMenuService menuService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String id=JWTUtil.getId((String)principalCollection.getPrimaryPrincipal());
        //获取使用者拥有的权限
        List<String> perms=menuService.getUserPerms(id);
        simpleAuthorizationInfo.addStringPermissions(perms);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取Token
        String token = (String) authenticationToken.getCredentials();
        //判断使用者是用户还是学生
        String type = JWTUtil.getType(token);
        try {
            if (type.equals("usr")) {
                SysUser usr = usrService.getByCode(JWTUtil.getCode(token));
                //验证
                if (!ObjectUtils.isEmpty(usr) && JWTUtil.verify(token, usr.getUserId(), usr.getUserName(), usr.getUserCode(), type)) {
                    return new SimpleAuthenticationInfo(token, token, this.getName());
                }
            } else {
                SysStudent student = studentService.getByCode(JWTUtil.getCode(token));
                if (!ObjectUtils.isEmpty(student) && JWTUtil.verify(token, student.getStudentId(), student.getStudentName(), student.getStudentCode(), type)) {
                    return new SimpleAuthenticationInfo(token, token, this.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
