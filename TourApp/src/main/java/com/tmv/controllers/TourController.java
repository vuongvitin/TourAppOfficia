/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.ImageService;
import com.tmv.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author PC
 */
@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private ImageService imageService;
    
    @GetMapping("tours/{tourId}")
    public String detail(Model model,@PathVariable(value = "tourId") int tourId){
        
        model.addAttribute("tourId", this.tourService.getTourById(tourId));
//        model.addAttribute("images", this.imageService.getImageByTourId(tourId));
        
        return "tour-detail";
    }
}
