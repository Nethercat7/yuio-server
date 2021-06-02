package com.zfy.yuio.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Description:一些常用到的方法
 * @Author:赵富源
 * @CreateDate:2020.1.8 0:59
 */
public class UsefulUtil {

    /**
     * @param str
     * @Author 赵富源
     * @Description 字符串去重
     * @Return java.lang.String
     */
    public static String removeRepeat(String str) {
        StringBuffer sb = new StringBuffer(str);
        String rs = sb.reverse().toString().replaceAll("(.)(?=.*\\1)", "");
        StringBuffer out = new StringBuffer(rs);
        return out.reverse().toString();
    }

    /**
     * @param startNumber
     * @param endNumber
     * @Author 赵富源
     * @Description 获取指定范围的整形随机数
     * @Return int
     */
    public static int getRandomNumber(int startNumber, int endNumber) {
        return (int) (Math.random() * (endNumber - startNumber + 1) + startNumber);
    }

    /**
     * @param filepath
     * @param filename
     * @param response
     * @Author 赵富源
     * @Description 文件下载
     * @Return void
     */
    public static void download(String filepath, String filename, HttpServletResponse response){
        File file = new File(filepath);
        if (file.exists()) {
            try{
                response.addHeader("Content-Length", String.valueOf(file.length()));
                response.setCharacterEncoding("utf-8");
                String n = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
                response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + n);
                byte[] buffer = new byte[1024];
                FileInputStream fis = new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
                fis.close();
                bis.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
