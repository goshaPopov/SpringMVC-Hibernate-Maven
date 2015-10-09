/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Comment;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Georgiy Popov
 */
@Repository
public class CommentDAOImpl implements CommentDAO{
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public CommentDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
        
    }
    
    @Override
    public Comment getCommetnById(Integer id) {
        return (Comment) currentSession().get(Comment.class,id);
    }

    @Override
    public void addComment(Comment comment) {
        currentSession().save(comment);
    }

    @Override
    public void editComment(Comment comment) {
        currentSession().update(comment);
    }

    @Override
    public void deleteComment(Comment comment) {
        currentSession().delete(comment);
    }    
    
}
