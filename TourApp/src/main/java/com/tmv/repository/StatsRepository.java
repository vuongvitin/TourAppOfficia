/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public interface StatsRepository {
    List<Object> toursNumMonthStats(String kw, Date fromDate, Date toDate); 
    List<Object> toursNumQuarterlyStats(String kw, Date fromDate, Date toDate);
    List<Object> toursNumYearStats(String kw, Date fromDate, Date toDate);
    List<Object> toursSumAmountMonthStats(String kw, Date fromDate, Date toDate);
    List<Object> toursSumAmountQuarterStats(String kw, Date fromDate, Date toDate);
    List<Object> toursSumAmountYearStats(String kw, Date fromDate, Date toDate);
}
