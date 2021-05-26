package com.zfy.yuio.entity.statstics;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.fasterxml.jackson.annotation.JsonProperty;

@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(20)
public class ExcelCityStatus {
    @ExcelProperty("城市名称")
    @JsonProperty("city_name")
    private String cityName;

    @ExcelProperty("总人数")
    @JsonProperty("total_people")
    private String totalPeople;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(String totalPeople) {
        this.totalPeople = totalPeople;
    }
}
