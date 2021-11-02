/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.User;
import com.tmv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/admin")
public class AdminUserController {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/staff-add-user")
    public String addUserStaffView(Model model){
        model.addAttribute("user", new User());
        return "staff-add-user";
    }
    
    @PostMapping("/staff-add-user")
    public String addUserStaff(Model model, @ModelAttribute(value = "user") User user){
        if(user.getPassword().isEmpty()
                || !user.getPassword().equals(user.getConfirmPassword()))
        model.addAttribute("errMsg", "Mat mật khẩu không khớp hoặc rỗng!!!");        
        else{
            if(this.userDetailsService.addUserStaff(user) == true)
            {   
//              model.addAttribute("errMsg", "Bạn thêm thành công tài khoảng nhân viên!!!");
                return "redirect:/admin/manage-staff";
            }
            model.addAttribute("errMsg", "Đã có lỗi xảy ra vui lòng quay lại sau!!!");  
        }
        return "staff-add-user";
    }
}
