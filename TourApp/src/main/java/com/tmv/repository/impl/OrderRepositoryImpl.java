/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.Cart;
import com.tmv.pojos.OrderDetail;
import com.tmv.pojos.SaleOrder;
import com.tmv.pojos.User;
import com.tmv.repository.TourRepository;
import com.tmv.repository.UserRepository;
import com.tmv.repository.OrderRepository;
import com.tmv.utils.Utils;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository{
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addReceipt(Cart cart, User user) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
        
            SaleOrder order = new SaleOrder();
            order.setUserId(user);
            order.setCreatedDate(new Date());

            Long sum = Utils.sumAmount(cart);
            order.setAmount(sum);

            session.save(order);

            OrderDetail detail = new OrderDetail();
            detail.setSaleOrder(order);
            detail.setTourId(this.tourRepository.getTourById(cart.getTourId()));
            detail.setUnitPrice(cart.getPriceAdult());
            detail.setNum(cart.getQuantityAdult());
            session.save(detail);
            
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        
        
        return false;
    }
    
}
