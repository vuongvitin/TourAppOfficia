/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.controllers;

import com.tmv.pojos.Comment;
import com.tmv.pojos.User;
import com.tmv.service.CommentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author PC
 */
@RestController
public class APICommentController {
    @Autowired
    private CommentService commentService;
    
    
    @PostMapping(path = "/api/add-comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params, HttpSession session){
        User u = (User) session.getAttribute("currentUser");
        if(u != null){
            try{
            String content = params.get("content");
            int tourId = Integer.parseInt(params.get("tourId"));
            String avatar = u.getAvatar();
            
            Comment c = this.commentService.addComment(content, tourId, u, avatar);
            return new ResponseEntity<>(c, HttpStatus.CREATED);
            }catch(HibernateException ex){
                ex.printStackTrace();
            }
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
