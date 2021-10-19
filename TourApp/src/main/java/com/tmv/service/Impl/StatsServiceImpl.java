/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.repository.StatsRepository;
import com.tmv.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object> toursNumMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursNumMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object> toursNumQuarterlyStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursNumQuarterlyStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object> toursNumYearStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursNumYearStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object> toursSumAmountMonthStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursSumAmountMonthStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object> toursSumAmountQuarterStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursSumAmountQuarterStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object> toursSumAmountYearStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.toursSumAmountYearStats(kw, fromDate, toDate);
    }
}
