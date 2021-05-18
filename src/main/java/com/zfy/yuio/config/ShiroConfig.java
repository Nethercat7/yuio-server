package com.zfy.yuio.config;

import com.zfy.yuio.filter.AuthFilter;
import com.zfy.yuio.realms.AuthRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Value("${shiro.auth}")
    private boolean auth;

   //创建Filter
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        //创建Filter
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //注入安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //设置自定义Filter
        Map<String, Filter> filters=new HashMap<>();
        filters.put("auth",new AuthFilter());
        shiroFilterFactoryBean.setFilters(filters);

        //请求拦截设置
        Map<String,String> filterMap=new LinkedHashMap<>();
        filterMap.put("/sys/login","anon");
        filterMap.put("/**",auth?"auth":"anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    //创建Web管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        //创建管理器
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        //设置Realm
        defaultWebSecurityManager.setRealm(realm());
        return defaultWebSecurityManager;
    }

    //创建自定义Realm
    @Bean
    public AuthRealm realm(){
        return new AuthRealm();
    }

    @Bean
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(defaultWebSecurityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //开启Shiro注解支持
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}
