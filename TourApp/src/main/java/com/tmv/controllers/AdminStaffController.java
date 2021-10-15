/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Staff;
import com.tmv.pojos.Tour;
import com.tmv.service.StaffService;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
public class AdminStaffController {
    @Autowired
    public StaffService staffService;
    
    @GetMapping("/manage-staff")
    public String manageStaff(Model model,
            @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        List<Staff> list = this.staffService.getStaffs(kw, page);
        
        model.addAttribute("staffs", this.staffService.getStaffs(kw, page));
        
        return "manage-staff";
    }
    
    @GetMapping("/staff-edit")
    public String addOrUpdateView(Model model,
            @RequestParam(name = "staffId", defaultValue = "0") int staffId){
        Staff test = this.staffService.getStaffById(staffId);
        if (staffId > 0) // cập nhật
            model.addAttribute("staff", test);
        else // thêm
        {   
            Staff t = new Staff();
            model.addAttribute("staff", t);
        }
        return "staff-edit";
    }
    
    @PostMapping("/staff-edit")
    public String addOrUpdateModel(Model model,
            @RequestParam(name = "staffId", defaultValue = "0") int staffId,
            @ModelAttribute(name = "staff") @Valid Staff staff,
            BindingResult err){
    
        if(staff.getId() <= 0){
            staff.setId(staffId);
        }
        
        if(!this.staffService.addOrUpdateTour(staff)){
            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
            return "staff-edit";
        }
        return "redirect:/admin/manage-staff";
    }
}
