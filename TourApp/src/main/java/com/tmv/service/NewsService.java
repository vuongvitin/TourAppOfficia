/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service;

import com.tmv.pojos.News;
import java.util.List;

/**
 *
 * @author PC
 */
public interface NewsService {
    List<News> getNews(String kw, int page);
}
