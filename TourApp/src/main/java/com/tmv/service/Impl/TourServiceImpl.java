/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.Tour;
import com.tmv.repository.TourRepository;
import com.tmv.service.TourService;
import java.util.List;
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
    
    @Override
    public List<Tour> getTours(String kw, int page) {
        return this.tourRepository.getTours(kw, page);
    }

    @Override
    public Long countTours() {
        return this.tourRepository.countTours();
    }

    @Override
    public Tour getTourById(int tourId) {
        return this.tourRepository.getTourById(tourId);
    }
    
}
