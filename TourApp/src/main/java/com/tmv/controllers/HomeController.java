/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Type;
import com.tmv.service.TourService;
import com.tmv.service.TypeService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private TourService tourService;
    
    
    @ModelAttribute
    public void commmonAttrs(Model model, @RequestParam(required = false) Map<String, String> params){
        model.addAttribute("types", this.typeService.getTypes());
        
        model.addAttribute("countTours", this.tourService.countAllTours());
               
        
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        String fromPrice = params.getOrDefault("fp", null);
        String toPrice = params.getOrDefault("tp", null);
        //StartDate
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        
        Date startDate = null;
        Date endDate = null;
        
        long fPrice = 0l;
        long tPrice = 0l;
        //Tim kiem theo gia
        if(fromPrice != null && !fromPrice.isEmpty() && toPrice != null && !toPrice.isEmpty()){            
            fPrice = Long.parseLong(fromPrice);
            tPrice = Long.parseLong(toPrice);                       
        }
        
        try{
            String from = params.getOrDefault("startDate", null);
            if(from != null){
                startDate = form.parse(from);
            }
            
            String to = params.getOrDefault("endDate", null);
            if(from != null){
                endDate = form.parse(to);
            }
            
            }catch(ParseException ex){
                ex.printStackTrace();
        }
        

        
        String typeId = params.get("TypeId");
        if(typeId == null){
            model.addAttribute("tours", this.tourService.getTours(kw, page, fPrice, tPrice, startDate, endDate));
            
            model.addAttribute("countTours", this.tourService.getTours(kw, -1, fPrice, tPrice, endDate, endDate).size());
        }else{
            Type t = this.typeService.getTypeById(Integer.parseInt(typeId));
            model.addAttribute("tours", t.getTourCollection());
            
            int size = t.getTourCollection().size();
            model.addAttribute("countTours", size);
        } 
        

        
        return "index";
    }
    
    
}
