package com.zfy.yuio.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 *@Description:Shiro请求错误响应
 *@Author:Nethercat7
 *@CreateDate:2021/4/27 16:55
*/
@ControllerAdvice
public class ExceptionController {
    //未经授权访问
    @ExceptionHandler(value= {UnauthorizedException.class})
    public void unauthorized(ServletResponse response){
        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setStatus(403);
    }
}
