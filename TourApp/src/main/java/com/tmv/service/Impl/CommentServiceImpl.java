/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service.Impl;

import com.tmv.pojos.Comment;
import com.tmv.pojos.Tour;
import com.tmv.pojos.User;
import com.tmv.repository.CommentRepository;
import com.tmv.repository.TourRepository;
import com.tmv.repository.UserRepository;
import com.tmv.service.CommentService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TourRepository tourRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Comment addComment(String content, int tourId, User creator) {
        Tour tour = this.tourRepository.getTourById(tourId);
        User user = this.userRepository.getUserById(creator.getId());
        Comment c = new Comment();
        c.setContent(content);
        c.setUser(user);
        c.setTour(tour);
        c.setCreatedDate(new Date());
        
        return this.commentRepository.addComment(c);
    }

    @Override
    public Long countCommentByTourId(int tourId) {
        return this.commentRepository.countCommentByTourId(tourId);
    }

    @Override
    public List<Comment> getCommentByTourId(int tourId, int page) {
        return this.commentRepository.getCommentByTourId(tourId, page);
    }
    
}
