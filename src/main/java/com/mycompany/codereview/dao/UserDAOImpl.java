/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Post;
import com.mycompany.codereview.domain.User;

import java.util.List;
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
public class UserDAOImpl implements UserDAO{
    
    private static final Logger log = Logger.getLogger(UserDAOImpl.class);
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
    @Transactional
    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void addUser(User user) {
        currentSession().save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return currentSession().createQuery("from User").list();
    }

    @Override
    public User getUserById(Integer id) {
        return (User) currentSession().get(User.class, id);
    }

    @Override
    public void editUser(User user) {
         currentSession().update(user);
    }

    @Override
    public void deleteUser(User user) {
        currentSession().delete(user);
    }

    @Override
    public List<Post> getPostsOfUser(User user) {
        user = (User) currentSession().get(User.class, user.getId());
        return user.getPosts();
    }
  
}
