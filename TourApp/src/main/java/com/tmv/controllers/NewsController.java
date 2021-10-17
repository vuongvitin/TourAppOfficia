/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.repository.NewsRepository;
import com.tmv.service.NewsService;
import java.util.Map;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
public class NewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/news-view")
    public String newsView(Model model, @RequestParam(required = false) Map<String, String> params){
        String kw = params.getOrDefault("kw", null);
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        
        model.addAttribute("news", this.newsService.getNews(kw, page));
        model.addAttribute("countNews", this.newsService.countAllNews());
        
        return "news-view";
    }
}
