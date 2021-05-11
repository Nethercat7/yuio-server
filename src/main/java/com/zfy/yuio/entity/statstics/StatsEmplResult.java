package com.zfy.yuio.entity.statstics;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @Description:数据统计返回体
 * @Author:Nethercat7
 * @CreateDate:2021/4/22 0:37
 */
public class StatsEmplResult {
    @JsonProperty("total_people")
    private int totalPeople;

    @JsonProperty("empl_people")
    private int emplPeople;

    @JsonProperty("un_empl_people")
    private int unEmplPeople;

    @JsonProperty("empl_rate")
    private String emplRate;

    @JsonProperty("college_name")
    private String collegeName;

    @JsonProperty("city_name")
    private String cityName;

    @JsonProperty("work_name")
    private String workName;

    @JsonProperty("plan")
    private String emplPlan;

    private List<StatsEmplResult> results;

    private int max;

    @JsonProperty("total_work_rank")
    private List<StatsEmplResult> totalWorkRank;

    @JsonProperty("female_work_rank")
    private List<StatsEmplResult> femaleWorkRank;

    @JsonProperty("male_work_rank")
    private List<StatsEmplResult> maleWorkRank;

    public int getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(int totalPeople) {
        this.totalPeople = totalPeople;
    }

    public int getEmplPeople() {
        return emplPeople;
    }

    public void setEmplPeople(int emplPeople) {
        this.emplPeople = emplPeople;
    }

    public int getUnEmplPeople() {
        return unEmplPeople;
    }

    public void setUnEmplPeople(int unEmplPeople) {
        this.unEmplPeople = unEmplPeople;
    }

    public String getEmplRate() {
        return emplRate;
    }

    public void setEmplRate(String emplRate) {
        this.emplRate = emplRate;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getEmplPlan() {
        return emplPlan;
    }

    public void setEmplPlan(String emplPlan) {
        this.emplPlan = emplPlan;
    }

    public List<StatsEmplResult> getResults() {
        return results;
    }

    public void setResults(List<StatsEmplResult> results) {
        this.results = results;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<StatsEmplResult> getTotalWorkRank() {
        return totalWorkRank;
    }

    public void setTotalWorkRank(List<StatsEmplResult> totalWorkRank) {
        this.totalWorkRank = totalWorkRank;
    }

    public List<StatsEmplResult> getFemaleWorkRank() {
        return femaleWorkRank;
    }

    public void setFemaleWorkRank(List<StatsEmplResult> femaleWorkRank) {
        this.femaleWorkRank = femaleWorkRank;
    }

    public List<StatsEmplResult> getMaleWorkRank() {
        return maleWorkRank;
    }

    public void setMaleWorkRank(List<StatsEmplResult> maleWorkRank) {
        this.maleWorkRank = maleWorkRank;
    }
}
