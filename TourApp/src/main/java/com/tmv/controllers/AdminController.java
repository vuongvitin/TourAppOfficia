/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;


import com.tmv.pojos.Tour;
import com.tmv.service.TourService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public TourService tourService;
    
    @GetMapping("/manage-tour")
    public String manageTour(Model model, @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("tours", this.tourService.getTours(kw, page, null, null, null, null));
        model.addAttribute("countTours", this.tourService.countAllTours());
        
        return "manage-tour";
    }
    
    @GetMapping("/tour-edit")
    public String addTourView(Model model,
            @RequestParam(name = "tourId", defaultValue = "0") int tourId){
        Tour test = this.tourService.getTourById(tourId);
        if (tourId > 0) // cập nhật
            model.addAttribute("tour", test);
        else // thêm
        {   
            Tour t = new Tour();
            model.addAttribute("tour", t);
        }
        
        return "tour-edit";
    }
    
    @PostMapping("/tour-edit")
    public String addOrUpdateTour(Model model, 
            @RequestParam(name = "tourId", defaultValue = "0") int tourId,
            @ModelAttribute(value = "tour") @Valid Tour tour,
            BindingResult err){
        
//        if (err.hasErrors()) {
//            return "tour-edit";
//        }
        
//        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
//        
//        Date userDate = new Date();
        tour.setId(tourId);
        if(tour.getId() > 0){}
        
        

        if(this.tourService.addOrUpdateTour(tour) == true){
//            model.addAttribute("Msg", "Thêm thành công!!!");
            return "redirect:/admin/manage-tour";
        }else{
            model.addAttribute("Msg", "Đã có lỗi xảy ra vui lòng quay lại sau!!!");
        }
        
        return "tour-edit";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
