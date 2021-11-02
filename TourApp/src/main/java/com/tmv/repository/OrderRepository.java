/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository;

import com.tmv.pojos.Cart;
import com.tmv.pojos.User;

/**
 *
 * @author PC
 */
public interface OrderRepository {
    boolean addReceipt(Cart cart, User user);
}
