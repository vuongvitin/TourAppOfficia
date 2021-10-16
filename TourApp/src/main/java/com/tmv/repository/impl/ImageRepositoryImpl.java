/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.Images;
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
    public List<Images> getImageByTourId(int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Images> query = builder.createQuery(Images.class);
        Root root = query.from(Images.class);

        
        query = query.where(builder.equal(root.get("tour"), tourId));

        
        Query q = session.createQuery(query);
        
        
        return q.getResultList();  
    }
    
    
   
}
