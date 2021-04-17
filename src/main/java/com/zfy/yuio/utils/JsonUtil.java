package com.zfy.yuio.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 *@Description:Json工具类
 *@Author:Nethercat7
 *@CreateDate:2021/4/17 23:10
*/
public class JsonUtil {
    public static void sendJson(ServletResponse response, Map<String, Object> map) throws IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        String json = new ObjectMapper().writeValueAsString(map);
        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().print(json);
    }

    public static void setStatus(ServletResponse response, int status) {
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setStatus(status);
    }
}
