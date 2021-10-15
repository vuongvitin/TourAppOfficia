/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
@RequestMapping("/api")
public class APIStaffController {
    @Autowired
    private StaffService staffService;
        
    @DeleteMapping("/staffs/{staffId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStaff(@PathVariable(name = "staffId") int staffId){
        this.staffService.deleteStaff(staffId);
    }
    
}
