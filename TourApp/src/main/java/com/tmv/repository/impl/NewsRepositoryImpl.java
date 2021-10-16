/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.News;
import com.tmv.repository.NewsRepository;
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
public class NewsRepositoryImpl implements NewsRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<News> getNews(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<News> query = builder.createQuery(News.class);
        Root root = query.from(News.class);
        query = query.select(root);

         if( kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }

        query = query.orderBy(builder.desc(root.get("id")));
        
        Query q = session.createQuery(query);
        
        int max = 3;
        int first = (page - 1)*max;
        q.setFirstResult(first);       
        q.setMaxResults(max);

        
        return q.getResultList(); 
    }
    
}
