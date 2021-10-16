/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tmv.service;

import com.tmv.pojos.Comment;
import com.tmv.pojos.User;
import java.util.List;

/**
 *
 * @author PC
 */
public interface CommentService {
    Comment addComment(String content, int productId, User creator, String avatar);
    Long countCommentByTourId(int tourId);
    List<Comment> getCommentByTourId(int tourId, int page);
}
