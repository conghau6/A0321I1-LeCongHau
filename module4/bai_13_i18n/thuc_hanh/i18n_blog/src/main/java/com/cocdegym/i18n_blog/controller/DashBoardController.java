package com.cocdegym.i18n_blog.controller;

import com.cocdegym.i18n_blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class DashBoardController {
    @GetMapping("/dashboard")
    public String login(@ModelAttribute("user") User user){
        return "dashboard";
    }
}
