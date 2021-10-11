/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Cart;
import com.tmv.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
public class APICartController {
    
    
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Cart cart =  (Cart) session.getAttribute("cart");

        if(cart == null){
            session.setAttribute("cart", params);
            return 1;
        }else{
            String tenTour = params.getTourName();
            if(cart.getTourName().equals(tenTour) != true){//san pham chua co trong gio
                session.setAttribute("cart", params);
                return 1;
            }
        }
        
        
        
        return 0;
    }
    
    @PutMapping("/api/cart")
//    @ResponseStatus(HttpStatus.OK)
    public Long updateCart(@RequestBody Cart params, HttpSession session){
        Cart c = (Cart) session.getAttribute("cart");
        
        if(c != null){
            if(params.getQuantityAdult() != 0){
                c.setQuantityAdult(params.getQuantityAdult());    
                session.setAttribute("cart", c);
            }else{
                c.setQuantityChildren(params.getQuantityChildren());
                session.setAttribute("cart", c);
            }
        }
       
        
        return Utils.sumAmount(c);
    }
} 
