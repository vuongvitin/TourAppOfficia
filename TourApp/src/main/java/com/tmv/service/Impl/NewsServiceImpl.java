/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.News;
import com.tmv.repository.NewsRepository;
import com.tmv.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getNews(String kw, int page) {
        return this.newsRepository.getNews(kw, page);
    }
    
}
