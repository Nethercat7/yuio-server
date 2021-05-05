package com.zfy.yuio.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *@Description:数据统计返回体
 *@Author:Nethercat7
 *@CreateDate:2021/4/22 0:37
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
   private String plan;

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

   public String getPlan() {
      return plan;
   }

   public void setPlan(String plan) {
      this.plan = plan;
   }
}
