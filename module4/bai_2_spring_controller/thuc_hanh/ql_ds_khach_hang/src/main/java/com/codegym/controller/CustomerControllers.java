package com.codegym.controller;

import com.codegym.model.bean.Customer;
import com.codegym.model.service.CustomerService;
import com.codegym.model.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerControllers {
    @Autowired
    private CustomerService customerService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showList(Model model){
        model.addAttribute("customerList",customerService.findAll());
        return "customers/list";
    }

    @GetMapping(value = "/info/{id}")
    public ModelAndView showInfo(@PathVariable String id){
        Customer customer = customerService.findById(id);
        ModelAndView modelAndView = new ModelAndView("customers/info","customer",customer);
//        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping(value = "/update")
    public String updateCustomer(Customer customer){ // cơ chế mass assignment để rút gọn, nó sẽ tự động tạo ra đối tượng customer
//        Customer customer = new Customer(id,name,email,address);
        customerService.update(customer);
        return "redirect:/customer/list";
    }
}
