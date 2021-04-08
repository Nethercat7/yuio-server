package com.zfy.yuio.entity;
/**
 *@Description:API返回体
 *@Author:Nethercat7
 *@CreateDate:2021/4/8 18:23
*/
public class ResultBody {
    private int code;
    private Object obj;
    private String msg;
    private String type; //Element Ui message组件的类型

    public ResultBody(int code, String msg, String type) {
        this.code = code;
        this.msg = msg;
        this.type = type;
    }

    public ResultBody(int code, Object obj, String type) {
        this.code = code;
        this.obj = obj;
        this.type = type;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
