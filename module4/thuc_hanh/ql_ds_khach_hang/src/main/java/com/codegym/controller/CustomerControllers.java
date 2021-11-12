package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerControllers {
    
    @GetMapping("/greeting")
    public String greeting(){
        return "index";
    }
}
