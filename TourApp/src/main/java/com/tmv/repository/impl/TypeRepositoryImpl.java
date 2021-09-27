package com.tmv.repository.impl;

import com.tmv.pojos.Type;
import com.tmv.repository.TypeRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class TypeRepositoryImpl implements TypeRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
        
    @Override
    public List<Type> getTypes() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Type");
        
        return q.getResultList();
    }
    
}
