package com.codegym.cookienameuser.controller;

import com.codegym.cookienameuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/test")
//@SessionAttributes("user")
public class TestLoginController {

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

//    @GetMapping("/login")
//    public String goLogin(){
//        return "test/login";
//    }

    @RequestMapping("/home")
    public String login(@ModelAttribute("user") User user, Model model, HttpSession session){
        if(user.getEmail()!=null && user.getPassword()!=null) {
            if (user.getEmail().equals("hau@gmail.com") && user.getPassword().equals("1234")) {
                session.setAttribute("user",user.getEmail());
                session.setMaxInactiveInterval(5);
                model.addAttribute("message", "login success");
                return "test/index";
            }
        }
        return "test/login";
    }

    @PostMapping("/logout")
    public String logout(@ModelAttribute("user") User user, Model model, HttpSession httpSession){
        httpSession.invalidate();
//        System.out.println(user);
//        user = new User();
//        model.addAttribute("user",user);
//        System.out.println(user);
        return "redirect:/test/home";
    }

}
