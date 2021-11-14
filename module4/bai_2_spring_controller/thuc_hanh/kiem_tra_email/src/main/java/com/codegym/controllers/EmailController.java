package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    @GetMapping("/")
    public String showForm(){
        return "home";
    }

    private boolean validate(String regex){
        return regex.matches(EMAIL_REGEX);
    }

    @PostMapping("/validate")
    public String validateEmail(@RequestParam("email") String email, Model model){
        boolean isValid = this.validate(email);
        if(isValid) model.addAttribute("message","Email hợp lệ");
        else model.addAttribute("message","Email không hợp lệ");
        return "home";
    }
}
