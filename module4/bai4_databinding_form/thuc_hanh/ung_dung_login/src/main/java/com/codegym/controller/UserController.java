package com.codegym.controller;

import com.codegym.model.bean.Login;
import com.codegym.model.bean.User;
import com.codegym.model.repositories.UserRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    UserRepositories userRepositories = new UserRepositories();
    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home","login", new Login());
        return modelAndView;
    }
    @PostMapping
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = userRepositories.checklogin(login);
        if(user==null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user","user",user);
            return modelAndView;
        }
    }
}
