/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.service.CommentService;
import com.tmv.service.ImageService;
import com.tmv.service.TourService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author PC
 */
@Controller
public class TourController {
    @Autowired
    private TourService tourService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private CommentService commentService;
    
//    @GetMapping("products/{productId}")
//    public String detail(Model model,@PathVariable(value = "productId") int productId,
//            ){
//        model.addAttribute("productId", this.ProductService.getProductById(productId));
//        
//        model.addAttribute("countComment", this.commentRepository.countCommentByProductId(productId));
//        
//        
//        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        
//        model.addAttribute("comment", this.commentRepository.getCommentByProductId(productId, page));
//        
//        return "product-detail";
//    }
    
    @GetMapping("tours/{tourId}")
    public String detail(Model model, @PathVariable(value = "tourId") int tourId,
            @RequestParam(required = false) Map<String, String> params){
        
        model.addAttribute("tourId", this.tourService.getTourById(tourId));
        
        model.addAttribute("images", this.imageService.getImageByTourId(tourId));

        model.addAttribute("countComment", this.commentService.countCommentByTourId(tourId));
//        
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
//        
        model.addAttribute("comments", this.commentService.getCommentByTourId(tourId, page));
        
        return "tour-detail";
    }
}
