/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
public class APINewsController {
    @Autowired
    private NewsService newsService;
    
    @DeleteMapping("/api/news/{newsId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteNews(@PathVariable(name = "newsId") int newsId){
        this.newsService.deleteNews(newsId);
    } 
    
}
