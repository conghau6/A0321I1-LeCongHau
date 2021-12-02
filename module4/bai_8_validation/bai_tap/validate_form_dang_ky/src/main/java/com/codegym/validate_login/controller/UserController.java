package com.codegym.validate_login.controller;

import com.codegym.validate_login.model.User;
import com.codegym.validate_login.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserValidator userValidator;

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index","user", new User());
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
        userValidator.validate(user,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        }
        return new ModelAndView("result","user",user);
    }
}
