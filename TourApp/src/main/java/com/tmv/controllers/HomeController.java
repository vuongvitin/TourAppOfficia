/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.TourService;
import com.tmv.service.TypeService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
    public void commmonAttrs(Model model){
        model.addAttribute("types", this.typeService.getTypes());
    }
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params){
        

        model.addAttribute("tours", this.tourService.getTours(null, 1));
        return "index";
    }
}
