package com.codegym.controller;

import com.codegym.model.bean.EmailConfig;
import com.codegym.model.bean.ListLanguages;
import com.codegym.model.bean.ListPageSize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    EmailConfig emailConfig = new EmailConfig("Vietnamese",25,true,"thor");

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listLanguages", ListLanguages.languages());
        modelAndView.addObject("listPageSize", ListPageSize.pageSizes());
        modelAndView.addObject("emailConfig",emailConfig);
        return modelAndView;
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute EmailConfig emailConfig){
        System.out.println("ok");
        return "redirect:/";
    }
}
