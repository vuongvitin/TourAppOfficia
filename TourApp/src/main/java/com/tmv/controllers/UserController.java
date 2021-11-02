/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.User;
import com.tmv.service.UserService;
import com.tmv.validator.UserNameValidator;
//import com.tmv.validator.WebAppValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author PC
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
//    @Autowired
//    private UserNameValidator userNameValidator;
//    
//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.setValidator(userNameValidator);
//    }
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "register";
    }
    
    @PostMapping("/register")
    public String registers(Model model, @ModelAttribute(value = "user") @Valid User user,
            BindingResult resultErr){

        if(!resultErr.hasErrors())
            if(user.getPassword().isEmpty()
                    || !user.getPassword().equals(user.getConfirmPassword()))
                model.addAttribute("errMsg", "Mật khẩu không khớp!!!");        
            else{
                if(this.userDetailsService.addUser(user) == true)
                {   
    //                    model.addAttribute("successMsg", "Bạn đã đăng ký thành công!!!");
                    return "redirect:/login";
                }
                model.addAttribute("errMsg", "Đã có lỗi xảy ra vui lòng quay lại sau!!!");  
        }
     
        
        
        return "register";
    }
}
