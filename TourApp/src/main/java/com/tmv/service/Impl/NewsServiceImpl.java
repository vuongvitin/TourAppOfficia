/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.tmv.pojos.News;
import com.tmv.repository.NewsRepository;
import com.tmv.service.NewsService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
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
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<News> getNews(String kw, int page) {
        return this.newsRepository.getNews(kw, page);
    }

    @Override
    public Long countAllNews() {
        return this.newsRepository.countAllNews();
    }

    @Override
    public boolean addOrUpdateTour(News news) {
        try {
            
            Map r = this.cloudinary.uploader().upload(news.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            
            news.setImage((String) r.get("secure_url"));
            
            
            return this.newsRepository.addOrUpdateNews(news);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteNews(int newsId) {
        return this.newsRepository.deleteNews(newsId);
    }

    @Override
    public News getNewsById(int newsId) {
        return this.newsRepository.getNewsById(newsId);
    }
    
}
