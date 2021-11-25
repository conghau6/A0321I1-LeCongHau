package com.codegym.controller;

import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ModelAndView listCustomers(){
        return new ModelAndView("list","listCustomer",customerService.findAll());
    }
}
