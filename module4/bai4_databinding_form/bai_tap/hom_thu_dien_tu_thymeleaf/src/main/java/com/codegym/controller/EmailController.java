package com.codegym.controller;

import com.codegym.model.bean.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {

    @ModelAttribute("languages")
    public List<String> languages(){
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        return languages;
    }

    @ModelAttribute("sizes")
    public List<Integer> pageSizes(){
        List<Integer> sizes = new ArrayList<>();
        sizes.add(5);
        sizes.add(10);
        sizes.add(15);
        sizes.add(20);
        sizes.add(100);
        return sizes;
    }

    @ModelAttribute("EmailConfig")
    public EmailConfig emailConfig(){
        return new EmailConfig("English",25,true,"king");
    }

    @GetMapping("")
    public String index(){
        return "index";
    }
}
