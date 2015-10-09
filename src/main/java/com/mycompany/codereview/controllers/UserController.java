
package com.mycompany.codereview.controllers;

import com.mycompany.codereview.domain.User;
import com.mycompany.codereview.service.UserService;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gosha
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    private static final Logger log = Logger.getLogger(UserController.class);
    
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(value="/list", method = RequestMethod.GET)
    public String getAllUsers(Model model){
        
        log.info("Request to get list of users");
         
        model.addAttribute(userService.getAllUsers());
        
        return "listOfUsers";
    }
    
    @RequestMapping(value="/addPageUser", method = RequestMethod.GET)
    public String getAddPageUser(Model model){
        
        log.info("Request to add user.");
        
        model.addAttribute("newUser",new User());
        
        return "addUserPage";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") User user, Model model){
        userService.addUser(user);
        
        log.info("User added.");
        
        model.addAttribute(user);
        
        return "redirect:/" + user.getId();
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.GET)
    public String getUserId(@PathVariable Integer id, Model model){
        
        model.addAttribute(userService.getUserById(id));
        
        log.info("Return user profile by id: "+ id);
        
        return "profile";
    }
    
}
