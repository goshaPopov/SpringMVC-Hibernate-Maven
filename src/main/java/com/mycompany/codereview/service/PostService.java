/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.service;

import com.mycompany.codereview.domain.Comment;
import com.mycompany.codereview.domain.Post;
import java.util.List;

/**
 *
 * @author Georgiy Popov
 */
public interface PostService {
    
    public void addPost(Post post);
    public List<Post> getAllPosts();
    public Post getPostById(Integer id);
    public void editPost(Post post);
    public void deletePost(Post post);
    
    public List<Comment> getCommentsByPost(Post post);
    
}
