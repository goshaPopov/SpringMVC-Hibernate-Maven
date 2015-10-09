/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.service;

import com.mycompany.codereview.dao.CommentDAO;
import com.mycompany.codereview.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Georgiy Popov
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    private CommentDAO commentDAO;
    
    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO){
        this.commentDAO = commentDAO;
    }

    @Override
    public Comment getCommetnById(Integer id) {
        return commentDAO.getCommetnById(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentDAO.addComment(comment);
    }

    @Override
    public void editComment(Comment comment) {
        commentDAO.editComment(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentDAO.deleteComment(comment);
    }
    
}
