/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.validator;

import com.tmv.pojos.User;
import com.tmv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author PC
 */
@Component
public class UserNameValidator implements Validator{
    @Autowired
    private UserService userDetailsService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;
        if(this.userDetailsService.getUserTest(u.getUsername()) == true)
            errors.rejectValue("username", "user.Username.myErr");
    }
    
}
