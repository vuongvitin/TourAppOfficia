/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.Imges;
import com.tmv.pojos.Tour;
import com.tmv.pojos.Type;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tmv.repository.ImageRepository;
import java.util.List;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class ImageRepositoryImpl implements ImageRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Imges> getImageByTourId(int arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
