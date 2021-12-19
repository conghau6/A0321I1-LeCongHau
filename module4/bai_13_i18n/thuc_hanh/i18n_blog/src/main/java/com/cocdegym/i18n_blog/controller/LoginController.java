package com.cocdegym.i18n_blog.controller;

import com.cocdegym.i18n_blog.model.Credential;
import com.cocdegym.i18n_blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/")
    public String login(@ModelAttribute("credential") Credential credential){
        System.out.println(credential);
        return "login";
    }

    @PostMapping("/")
    public String dashboard(@ModelAttribute("credential") Credential credential, Model model){
        User user = new User();
        user.setUserName(credential.getUsername());
        model.addAttribute("user",user);
        return "redirect:/dashboard";
    }
}
