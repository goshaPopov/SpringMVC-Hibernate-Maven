/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.dao;

import com.mycompany.codereview.domain.Post;
import com.mycompany.codereview.domain.User;
import java.util.List;

/**
 *
 * @author Georgiy Popov
 */
public interface UserDAO {
    
    public void addUser(User user);
    public List<User> getAllUsers();
    public User getUserById(Integer id);
    public void editUser(User user);
    public void deleteUser(User user);
    public List<Post> getPostsOfUser(User user);
    
}
