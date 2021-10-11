/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Cart;
import com.tmv.service.TourService;
import com.tmv.utils.Utils;
import javax.servlet.http.HttpSession;
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
public class BookingController {
    @Autowired
    private TourService tourService;

    @GetMapping("booking/{tourId}")
    public String booking(Model model,@PathVariable(value = "tourId") int tourId, HttpSession session){
        
        Cart cart = (Cart) session.getAttribute("cart");
        
        model.addAttribute("amountCart", Utils.sumAmount(cart));
        model.addAttribute("c", cart);
        
        model.addAttribute("tourId", this.tourService.getTourById(tourId));
        return "booking";
    }
}
