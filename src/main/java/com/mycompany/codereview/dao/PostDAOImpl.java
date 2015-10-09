/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Comment;
import com.mycompany.codereview.domain.Post;

import java.util.List;
import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Georgiy Popov
 */
@Repository
@Transactional
public class PostDAOImpl implements PostDAO{
    
    private static final Logger log = Logger.getLogger(PostDAOImpl.class);
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public PostDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addPost(Post post){
        currentSession().save(post);
    }
    
    @Override
    public List<Post> getAllPosts() {
         return currentSession().createQuery("from Post").list();
    }

    @Override
    public Post getPostById(Integer id) {
        return (Post) currentSession().get(Post.class, id);
    }

    @Override
    public void editPost(Post post) {
        currentSession().update(post);
    }

    @Override
    public void deletePost(Post post) {
        currentSession().delete(post);
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        post = (Post) currentSession().get(Post.class, post.getId());
        return post.getComments();
    }
    
}
