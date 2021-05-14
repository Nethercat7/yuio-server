package com.zfy.yuio.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface StatsRateDao {
    int getTotalPeople(Long id);
}
