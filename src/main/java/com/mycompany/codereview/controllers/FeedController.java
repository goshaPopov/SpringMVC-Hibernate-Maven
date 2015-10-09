/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codereview.controllers;

import com.mycompany.codereview.domain.Post;
import com.mycompany.codereview.service.PostService;
import com.mycompany.codereview.service.UserService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Georgiy Popov
 */
@Controller
public class FeedController {
    
    private static final Logger log = Logger.getLogger(FeedController.class);
    
    private PostService postService;
    private UserService userService;
    
    @Autowired
    public FeedController(PostService postService, UserService userService){
        this.postService = postService;
        this.userService = userService;
    }
    
    @RequestMapping(value={"/","/feed"}, method = RequestMethod.GET)
    public String showFeedPage(Model model){
        
        log.debug(("Request to \"/\" or \"/feed\" "));
        
        model.addAllAttributes(postService.getAllPosts());
        
        log.debug(("Get List  of posts and return \"index.jsp\" "));
        
        return "index" ;
    }
    
}
