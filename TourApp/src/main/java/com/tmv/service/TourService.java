/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service;

import com.tmv.pojos.Tour;
import java.util.List;

/**
 *
 * @author PC
 */
public interface TourService {
    List<Tour> getTours(String kw, int page);
}
