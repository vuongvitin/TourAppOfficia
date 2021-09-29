/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.Imges;
import com.tmv.repository.ImageRepository;
import com.tmv.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public List<Imges> getImageByTourId(int tourId) {
        return this.imageRepository.getImageByTourId(tourId);
    }
    
}
