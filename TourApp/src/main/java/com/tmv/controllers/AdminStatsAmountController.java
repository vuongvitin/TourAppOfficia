/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/admin")
public class AdminStatsAmountController {
    @Autowired
    private StatsService statsService;
    
    
    @GetMapping("/tours-amount-month-stats")
    public String amountMonth(Model model, @RequestParam(required = false) Map<String, String> params){
        
        String kw = params.getOrDefault("kw", null);
        
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        try{
            String from = params.getOrDefault("fromDate", null);
            if(from != null){
                fromDate = form.parse(from);
            }


            String to = params.getOrDefault("toDate", null);
            if(to != null){
                toDate = form.parse(to);
            }
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        
        
        model.addAttribute("monthAmountStats", this.statsService.toursSumAmountMonthStats(kw, fromDate, toDate));
        return "tours-amount-month-stats";
    }
    
    @GetMapping("/tours-amount-quarter-stats")
    public String amountQuarter(Model model, @RequestParam(required = false) Map<String, String> params){
        
        String kw = params.getOrDefault("kw", null);
        
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        try{
            String from = params.getOrDefault("fromDate", null);
            if(from != null){
                fromDate = form.parse(from);
            }


            String to = params.getOrDefault("toDate", null);
            if(to != null){
                toDate = form.parse(to);
            }
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        
        
        model.addAttribute("quarterAmountStats", this.statsService.toursSumAmountQuarterStats(kw, fromDate, toDate));
        return "tours-amount-quarter-stats";
    }
    
    @GetMapping("/tours-amount-year-stats")
    public String amountYear(Model model, @RequestParam(required = false) Map<String, String> params){
        
        String kw = params.getOrDefault("kw", null);
        
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        try{
            String from = params.getOrDefault("fromDate", null);
            if(from != null){
                fromDate = form.parse(from);
            }


            String to = params.getOrDefault("toDate", null);
            if(to != null){
                toDate = form.parse(to);
            }
        }catch(ParseException ex){
            ex.printStackTrace();
        }
        
        
        model.addAttribute("yearAmountStats", this.statsService.toursSumAmountYearStats(kw, fromDate, toDate));
        return "tours-amount-year-stats";
    }
}
