/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Comment;
import org.apache.log4j.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Georgiy Popov
 */
@Repository
@Transactional
public class CommentDAOImpl implements CommentDAO{
    
    private static final Logger log = Logger.getLogger(CommentDAOImpl.class);
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public CommentDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
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
