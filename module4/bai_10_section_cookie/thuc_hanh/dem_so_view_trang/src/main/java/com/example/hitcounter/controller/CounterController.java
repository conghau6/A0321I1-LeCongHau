package com.example.hitcounter.controller;

import com.example.hitcounter.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
//@SessionAttributes("mycounter")
public class CounterController {
    @ModelAttribute("mycounter")
    public MyCounter setUpCounter(){
        return new MyCounter();
    }
//
//    @GetMapping("/")
//    public String get(@ModelAttribute("mycounter") MyCounter myCounter){
//        myCounter.increment();
//        return "index";
//    }
    @GetMapping("/")
    public String index(@CookieValue(name = "hitCounter", defaultValue = "0") Integer count
            , @ModelAttribute(name = "mycounter") MyCounter myCounter, HttpServletResponse response, Model model) {
        count++;
        Cookie cookie = new Cookie("hitCounter",count.toString());
        response.addCookie(cookie);
        myCounter.setCount(count);
        model.addAttribute("mycounter",myCounter);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(HttpServletResponse response){
        Cookie cookie = new Cookie("hitCounter","0");
        response.addCookie(cookie);
        return "redirect:/";
    }
}
