package com.zfy.yuio.config;

import com.zfy.yuio.realms.AuthRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
   //创建Filter
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        //创建Filter
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        //注入安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //受限资源
        //公共资源
        return shiroFilterFactoryBean;
    }

    //创建Web管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        //创建管理器
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //设置Realm
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    //创建自定义Realm
    @Bean
    public Realm realm(){
        return new AuthRealm();
    }
}
