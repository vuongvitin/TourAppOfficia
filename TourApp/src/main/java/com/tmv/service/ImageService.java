/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service;

import com.tmv.pojos.Images;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ImageService {
    List<Images> getImageByTourId(int tourId);
}
