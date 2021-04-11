package com.zfy.yuio.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.util.Random;

/**
 *@Description:Shirogo工具类
 *@Author:Nethercat7
 *@CreateDate:2021/4/11 23:03
*/
public class ShiroUntil {
    /**
     *@Author Nethercat7
     *@Description 将密码通过MD5算法加密
     *@param pwd 密码
     *@param salt 随机盐
     *@param hash 散列次数
     *@Return java.lang.String
    */
    public static String pwd2MD5(String pwd, String salt, int hash){
        return new Md5Hash(pwd,salt,hash).toHex();
    }

    /**
     *@Author Nethercat7
     *@Description 生成随机盐
     *@param n 随机盐位数
     *@Return java.lang.String
    */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
