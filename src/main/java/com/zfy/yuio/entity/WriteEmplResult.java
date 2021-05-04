package com.zfy.yuio.entity;

import java.util.List;

/**
 *@Description:数据统计返回体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 0:37
*/
public class WriteEmplResult {
    private int people;
    private String city;
    private String type;
    private String plan;
    private List<Integer> grades;
    private List<String> rates;

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

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public List<String> getRates() {
        return rates;
    }

    public void setRates(List<String> rates) {
        this.rates = rates;
    }
}
