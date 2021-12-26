package com.codegym.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping("")
    public String showIndex(){
        return "fragment/sidebar";
    }
}
