/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.OrderDetail;
import com.tmv.pojos.SaleOrder;
import com.tmv.pojos.Tour;
import com.tmv.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author PC
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object> toursNumMonthStats(String kw, Date fromDate, Date toDate) {
       Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("MONTH", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(rootD.get("num")));
        
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootT.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("MONTH", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object> toursNumQuarterlyStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("QUARTER", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(rootD.get("num")));
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("QUARTER", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
//        return null;
    }

    @Override
    public List<Object> toursNumYearStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(rootD.get("num")));
        
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootT.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object> toursSumAmountMonthStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("MONTH", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(builder.prod(rootD.get("unitPrice"), rootD.get("num"))));
        
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootT.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("MONTH", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object> toursSumAmountQuarterStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("QUARTER", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(builder.prod(rootD.get("unitPrice"), rootD.get("num"))));
        
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootT.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("QUARTER", Integer.class, rootO.get("createdDate")),
                builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object> toursSumAmountYearStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        
        Root rootT = q.from(Tour.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(builder.equal(rootD.get("tourId"), rootT.get("id")));
        predicates.add(builder.equal(rootD.get("saleOrder"), rootO.get("id")));
        
        q.multiselect(builder.function("YEAR", Integer.class, rootO.get("createdDate")),
                builder.sum(builder.prod(rootD.get("unitPrice"), rootD.get("num"))));
        
        
        if(kw != null && !kw.isEmpty()){
            predicates.add(builder.like(rootT.get("name").as(String.class), 
                    String.format("%%%s%%", kw)));
        }
        
        if(fromDate != null)
            predicates.add(builder.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));
        if(toDate != null)
           predicates.add(builder.lessThanOrEqualTo(rootO.get("createdDate"), toDate));
        
        
        q.where(predicates.toArray(new Predicate[] {}));
        
        q.groupBy(builder.function("YEAR", Integer.class, rootO.get("createdDate")));
//        q.orderBy(builder.asc(rootO.get("id")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
    
}
