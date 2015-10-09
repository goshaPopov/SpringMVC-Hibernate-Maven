/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.service;

import com.mycompany.codereview.dao.PostDAO;
import com.mycompany.codereview.domain.Comment;
import com.mycompany.codereview.domain.Post;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Georgiy Popov
 */
@Service
public class PostServiceImpl implements PostService{
    
    private PostDAO postDAO;
    
    @Autowired
    public PostServiceImpl(PostDAO postDAO){
        this.postDAO = postDAO;
    }

    @Override
    public void addPost(Post post) {
        postDAO.addPost(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    @Override
    public Post getPostById(Integer id) {
        return postDAO.getPostById(id);
    }

    @Override
    public void editPost(Post post) {
        postDAO.editPost(post);
    }

    @Override
    public void deletePost(Post post) {
        postDAO.deletePost(post);
    }

    @Override
    public List<Comment> getCommentsByPost(Post post) {
        return postDAO.getCommentsByPost(post);
    }
    
    
}
