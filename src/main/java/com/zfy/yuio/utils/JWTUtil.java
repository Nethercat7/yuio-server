package com.zfy.yuio.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 *@Description:JWT工具类
 *@Author:Nethercat7
 *@CreateDate:2021/4/17 22:57
*/
public class JWTUtil {
    private final static int EXPIRE_TIME = 7;
    private final static String SECRET = "*******";
    private final static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET);

    public static String createToken(String id, String name) {
        //设置Token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRE_TIME);

        return JWT.create()
                .withClaim("id", id)
                .withClaim("name", name)
                .withExpiresAt(calendar.getTime())
                .sign(ALGORITHM);
    }

    public static String createToken(String id, String name,String code) {
        //设置Token过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, EXPIRE_TIME);

        return JWT.create()
                .withClaim("id", id)
                .withClaim("name", name)
                .withClaim("code",code)
                .withExpiresAt(calendar.getTime())
                .sign(ALGORITHM);
    }

    public static boolean verify(String token, String userId, String username) throws Exception {
        JWT.require(ALGORITHM).withClaim("userId", userId).withClaim("username", username).build().verify(token);
        return true;
    }

    public static void verify(String token) throws Exception {
        JWT.require(ALGORITHM).build().verify(token);
    }

    public static String getToken(ServletRequest request) {
        HttpServletRequest req = (HttpServletRequest) request;
        return req.getHeader("token");
    }
}
