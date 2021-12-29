package com.codegym.furama.controller;

import com.codegym.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showIndex(@PageableDefault(size = 10) Pageable pageable){
        return new ModelAndView("customer/list","customerList",customerService.findAll(pageable));
    }
}
