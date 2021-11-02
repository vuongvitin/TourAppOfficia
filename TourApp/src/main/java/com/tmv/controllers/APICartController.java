/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Cart;
import com.tmv.pojos.User;
import com.tmv.service.OrderService;
import com.tmv.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/api/cart")
    public int addToCart(@RequestBody Cart params, HttpSession session){
        Cart cart =  (Cart) session.getAttribute("cart");
        
        if(cart == null){
            session.setAttribute("cart", params);
            return 1;
        }else{//san pham da co trong gio
            session.removeAttribute("cart");
            String tenTour = params.getTourName();
            if(cart.getTourName().equals(tenTour) == true){
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
    
    @PostMapping("/api/pay")
    public HttpStatus pay(HttpSession session, Model model){
        User u = (User) session.getAttribute("currentUser");
                
        if(this.orderService.addReceipt((Cart) session.getAttribute("cart"), u) == true){
            session.removeAttribute("cart");
//            model.addAttribute("msg", "Bạn đã thanh toán thành công!!");
            return HttpStatus.OK;
        }
        
        return HttpStatus.BAD_REQUEST;
    }
} 
