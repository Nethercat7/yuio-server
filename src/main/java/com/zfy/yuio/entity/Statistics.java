package com.zfy.yuio.entity;
/**
 *@Description:数据统计返回体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 0:37
*/
public class Statistics {
    private int people;
    private String city;
    private String type;
    private String plan;

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
