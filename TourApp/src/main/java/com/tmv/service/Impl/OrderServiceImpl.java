/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.Cart;
import com.tmv.pojos.User;
import com.tmv.repository.OrderRepository;
import com.tmv.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addReceipt(Cart cart, User user) {
        if(cart != null)
            return this.orderRepository.addReceipt(cart, user);
        return false;
    }
    
}
