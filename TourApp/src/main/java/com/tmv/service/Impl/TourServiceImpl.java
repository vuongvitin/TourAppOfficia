/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tmv.pojos.Tour;
import com.tmv.pojos.Type;
import com.tmv.repository.TourRepository;
import com.tmv.service.TourService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class TourServiceImpl implements TourService{
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Tour> getTours(String kw, int page, Long fromPrice, Long toPrice, Date startDate, Date endDate) {
        return this.tourRepository.getTours(kw, page, fromPrice, toPrice, startDate, endDate);
    }

    @Override
    public Long countAllTours() {
        return this.tourRepository.countAllTours();
    }

    @Override
    public Tour getTourById(int tourId) {
        return this.tourRepository.getTourById(tourId);
    }

    @Override
    public boolean addOrUpdateTour(Tour tour) {
        try {
//            Type type = (Type)tour.getTypeId();
//            
//            tour.setType(type);
            
            Map r = this.cloudinary.uploader().upload(tour.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            
            tour.setImage((String) r.get("secure_url"));
            
            
            return this.tourRepository.addOrUpdateTour(tour);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
