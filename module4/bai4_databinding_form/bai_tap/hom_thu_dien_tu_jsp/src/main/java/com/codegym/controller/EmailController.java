package com.codegym.controller;

import com.codegym.model.bean.EmailConfig;
import com.codegym.model.bean.ListLanguages;
import com.codegym.model.bean.ListPageSize;
import com.codegym.model.repositories.EmailConfigRepositories;
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

    EmailConfigRepositories emailConfigRepositories = new EmailConfigRepositories();

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("listLanguages", ListLanguages.languages());
        modelAndView.addObject("listPageSize", ListPageSize.pageSizes());
        modelAndView.addObject("emailConfig",emailConfigRepositories.getEmailConfig());
        return modelAndView;
    }

    @PostMapping("/save")
    public String submitForm(@ModelAttribute("emailConfig") EmailConfig emailConfig){
        emailConfigRepositories.setEmailConfig(emailConfig);
        return "redirect:/";
    }
}
