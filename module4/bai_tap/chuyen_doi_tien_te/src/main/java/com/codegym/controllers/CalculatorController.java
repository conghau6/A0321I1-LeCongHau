package com.codegym.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String showForm(){
        return "home";
    }

    @GetMapping("/result")
    public String resultForm(@RequestParam String usd, String rate, Model model){
        double result = Double.parseDouble(usd) * Double.parseDouble(rate);
        model.addAttribute("result", result);
        return "result";
    }
}
