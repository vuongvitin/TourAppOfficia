/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.repository;

import com.tmv.pojos.News;
import java.util.List;

/**
 *
 * @author PC
 */
public interface NewsRepository {
    List<News> getNews(String kw, int page);
    Long countAllNews();
    boolean addOrUpdateNews(News news);
    boolean deleteNews(int newsId);
    News getNewsById(int newsId);
}
