/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.utils;

import com.tmv.pojos.Cart;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Utils {
    
    public static Long sumAmount(Cart cart){
        Long amountAdult = 0l;
        Long amountChildren = 0l;
        Long sumAmount = 0l;
        if(cart != null){
            amountAdult += cart.getPriceAdult()*cart.getQuantityAdult();
            amountChildren += cart.getPriceChildren()*cart.getQuantityChildren();
            sumAmount = amountAdult + amountChildren;
        }
            
        return sumAmount;
    }
}
