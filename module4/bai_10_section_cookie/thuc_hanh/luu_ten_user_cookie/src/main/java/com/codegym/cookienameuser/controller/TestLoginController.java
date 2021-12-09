package com.codegym.cookienameuser.controller;

import com.codegym.cookienameuser.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
@SessionAttributes("user")
public class TestLoginController {

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

//    @GetMapping("/home")
//    public String home(HttpServletRequest request, Model model){
//        Cookie[] cookies = request.getCookies();
//        if(cookies!=null){
//            for(Cookie ck : cookies){
//                if(ck.getName().equals("user_info")){
//                    model.addAttribute("message","login success");
//                    return "index";
//                }
//            }
//        }
//        return "testLogin";
//    }

    @GetMapping("/login")
    public String goLogin(){
        return "testLogin";
    }

    @RequestMapping("/home")
    public String login(@CookieValue(value = "userInfo", defaultValue = "") String userInfo, @ModelAttribute("user") User user
            , Model model, HttpServletResponse response, HttpServletRequest request){

        Cookie[] cookies = request.getCookies();
        if(cookies!=null){
            for(Cookie ck : cookies){
                if(ck.getName().equals("userInfo")){
                    if(ck.getValue().equals("")) return "testLogin";
                }
            }
        }

        if(user.getEmail()!=null && user.getPassword()!=null) {
            if (user.getEmail().equals("hau@gmail.com") && user.getPassword().equals("1234")) {
                model.addAttribute("message", "login success");
                Cookie cookie = new Cookie("userInfo", user.getEmail());
                cookie.setMaxAge(5);
                response.addCookie(cookie);
                return "index";
            }
        }
        return "testLogin";
    }

}
