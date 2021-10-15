/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository.impl;

import com.tmv.pojos.Staff;
import com.tmv.repository.StaffRepository;
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
public class StaffRepositoryImpl implements StaffRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    

    @Override
    public List<Staff> getStaffs(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Staff> query = builder.createQuery(Staff.class);
        Root root = query.from(Staff.class);
        query = query.select(root);
        
        
        if( kw != null){
            Predicate p = builder.like(root.get("name").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        query = query.orderBy(builder.desc(root.get("id")));
        
        Query q = session.createQuery(query); 
        
        int max = 5;
        int first = (page -1)*max;
        q.setFirstResult(first);       
        q.setMaxResults(max);
        
        
        return q.getResultList();
    }

    @Override
    public Staff getStaffById(int staffId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Staff.class, staffId);
    }

    @Override
    public boolean addOrUpdateTour(Staff staff) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(staff.getId() <= 0){
                session.save(staff);
            }else{
                session.update(staff);
            }
            return true;
        }catch(HibernateException ex){
            System.err.println("== ADD OR UPDATE STAFF ERROR ==="+ ex.getMessage());
            ex.printStackTrace();        
        }
        return false;
    }

    @Override
    public boolean deleteStaff(int staffId) {
         try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Staff t = session.get(Staff.class, staffId);
            session.delete(t);
            return true;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
}
