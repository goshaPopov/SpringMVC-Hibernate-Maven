/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Comment;

/**
 *
 * @author Georgiy Popov
 */
public interface CommentDAO {
    
    public Comment getCommetnById(Integer id);
    public void addComment(Comment comment);
    public void editComment(Comment comment);
    public void deleteComment(Comment comment);
    
    
}
