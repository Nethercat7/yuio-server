package com.zfy.yuio.entity.statstics;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zfy.yuio.converter.PlanConverter;

import java.util.List;

@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class ExcelPlanStats {
    @ExcelProperty(value = "计划",converter = PlanConverter.class)
    @JsonProperty("plan")
    private String emplPlan;

    @ExcelProperty("总人数")
    @JsonProperty("total_people")
    private int totalPeople;

    @ExcelIgnore
    @JsonProperty("empl_people")
    private int emplPeople;

    @ExcelIgnore
    @JsonProperty("un_empl_people")
    private int unEmplPeople;

    @ExcelIgnore
    @JsonProperty("empl_rate")
    private String emplRate;

    @ExcelIgnore
    private String name;

    @ExcelIgnore
    @JsonProperty("city_name")
    private String cityName;

    @ExcelIgnore
    private List<StatsEmplResult> results;

    @ExcelIgnore
    private int max;

    @ExcelIgnore
    @JsonProperty("total_rank")
    private List<StatsEmplResult> totalRank;

    @ExcelIgnore
    @JsonProperty("female_rank")
    private List<StatsEmplResult> femaleRank;

    @ExcelIgnore
    @JsonProperty("male_rank")
    private List<StatsEmplResult> maleRank;

    @ExcelIgnore
    @JsonProperty("work_pid")
    private Long workPid;

    @ExcelIgnore
    private List<StatsEmplResult> industries;

    @ExcelIgnore
    @JsonProperty("protocol_number")
    private int protocolNumber;

    @ExcelIgnore
    private int level;

    @ExcelIgnore
    @JsonProperty("work_name")
    private String workName;

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

    public List<StatsEmplResult> getTotalRank() {
        return totalRank;
    }

    public void setTotalRank(List<StatsEmplResult> totalRank) {
        this.totalRank = totalRank;
    }

    public List<StatsEmplResult> getFemaleRank() {
        return femaleRank;
    }

    public void setFemaleRank(List<StatsEmplResult> femaleRank) {
        this.femaleRank = femaleRank;
    }

    public List<StatsEmplResult> getMaleRank() {
        return maleRank;
    }

    public void setMaleRank(List<StatsEmplResult> maleRank) {
        this.maleRank = maleRank;
    }

    public Long getWorkPid() {
        return workPid;
    }

    public void setWorkPid(Long workPid) {
        this.workPid = workPid;
    }

    public List<StatsEmplResult> getIndustries() {
        return industries;
    }

    public void setIndustries(List<StatsEmplResult> industries) {
        this.industries = industries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(int protocolNumber) {
        this.protocolNumber = protocolNumber;
    }
}
