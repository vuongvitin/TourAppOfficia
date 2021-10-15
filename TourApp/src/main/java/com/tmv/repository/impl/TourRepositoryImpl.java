/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.Tour;
import com.tmv.repository.TourRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class TourRepositoryImpl implements TourRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public List<Tour> getTours(String kw, int page, Long fromPrice, Long toPrice, Date startDate, Date endDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Tour> query = builder.createQuery(Tour.class);
        Root root = query.from(Tour.class);
        query = query.select(root);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if( kw != null){
            predicates.add(builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromPrice != null && fromPrice != 0l)
            predicates.add(builder.greaterThanOrEqualTo(root.get("giaTour"), fromPrice));
        if(toPrice != null && fromPrice != 0l)
           predicates.add(builder.lessThanOrEqualTo(root.get("giaTour"), toPrice));
        
        if(startDate != null)
            predicates.add(builder.greaterThanOrEqualTo(root.get("ngayKhoiHanh"), startDate));
        if(endDate != null)
            predicates.add(builder.lessThanOrEqualTo(root.get("ngayKhoiHanh"), endDate));
        
        
        query = query.where(predicates.toArray(new Predicate[] {}));
        
        query = query.orderBy(builder.desc(root.get("id")));
        
        Query q = session.createQuery(query);
        
        if(page != -1){
            int max = 20;
            int first = (page -1)*max;
            q.setFirstResult(first);       
            q.setMaxResults(max);
        }

        
        return q.getResultList();
    }

    @Override
    public long countAllTours() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) From Tour");
        
        
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public Tour getTourById(int tourId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Tour.class, tourId);
    }

    @Override
    public boolean addOrUpdateTour(Tour tour) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if (tour.getId() == 0)
                session.save(tour);
            else
                session.update(tour);
            return true;
        } catch (HibernateException ex){
           System.err.println("== ADD OR UPDATE TOUR ERROR ==="+ ex.getMessage());
           ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteTour(int tourId) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Tour t = session.get(Tour.class, tourId);
            session.delete(t);
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
}
