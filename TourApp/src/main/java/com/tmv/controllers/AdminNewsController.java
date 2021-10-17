/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.News;
import com.tmv.service.NewsService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
@RequestMapping("/admin")
public class AdminNewsController {
    @Autowired
    private NewsService newsService;
    
    @GetMapping("/news-edit")
    public String newsAddOrUpdateView(Model model,
            @RequestParam(name = "newsId", defaultValue = "0") int newsId){
        
        News test = this.newsService.getNewsById(newsId);
        
        if(newsId > 0){//edit News
            model.addAttribute("news", test);
        }else{//add news
            News news = new News();
            model.addAttribute("news", news);
        }
        
        
        return "news-edit";
    }
    
    @PostMapping("/news-edit")
    public String addOrUpdateTour(Model model, 
            @RequestParam(name = "tourId", defaultValue = "0") int newsId,
            @ModelAttribute(value = "tour") @Valid News news,
            BindingResult err){
        
//        if (err.hasErrors()) {
//            return "tour-edit";
//        }
        
        if(newsId != 0){
            news.setId(newsId);
        }
        
        if(this.newsService.addOrUpdateTour(news) == true){
//          model.addAttribute("Msg", "Thêm thành công!!!");
            return "redirect:/news-view";
        }else{
            model.addAttribute("MsgErr", "Đã có lỗi xảy ra vui lòng quay lại sau!!!");
        }
        
        return "news-edit";
    }

}
