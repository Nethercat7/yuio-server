package com.zfy.yuio.realms;

import com.zfy.yuio.entity.Token;
import com.zfy.yuio.entity.Usr;
import com.zfy.yuio.service.UsrService;
import com.zfy.yuio.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UsrService usrService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return  token instanceof Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取Token
        String token=(String)authenticationToken.getCredentials();
        //判断使用者是用户还是学生
        String type=JWTUtil.getType(token);
        if(type.equals("usr")){
           Usr usr=usrService.get(JWTUtil.getCode(token));
           //验证
            try {
                if(!ObjectUtils.isEmpty(usr)&&JWTUtil.verify(token,usr.getUsrId(),usr.getUsrName(),usr.getUsrCode(),type)){
                   return new SimpleAuthenticationInfo(token,token,this.getName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
