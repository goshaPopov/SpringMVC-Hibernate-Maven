
package com.mycompany.codereview.controllers;

import com.mycompany.codereview.domain.User;
import com.mycompany.codereview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gosha
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @RequestMapping(value="/addPageUser", method = RequestMethod.GET)
    public String getAddPageUser(Model model){
        model.addAttribute("newUser",new User());
        return "addUserPage";
    }
    
    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("newUser") User user){
        userService.addUser(user);
        return "users";
    }
    
    
}
