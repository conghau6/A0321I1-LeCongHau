package com.codegym.controller;

import com.codegym.model.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepositories productRepositories;
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("customerList",productRepositories.findAll());
        return "index";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("product",productRepositories.findById(id));
        return "view";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productRepositories.findById(id));
        return "edit";
    }
}
