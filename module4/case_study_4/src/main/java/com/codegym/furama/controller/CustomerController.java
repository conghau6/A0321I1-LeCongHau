package com.codegym.furama.controller;

import com.codegym.furama.entity.Customer;
import com.codegym.furama.entity.CustomerType;
import com.codegym.furama.repositories.customer.ICustomerType;
import com.codegym.furama.repositories.employee.IUserRepositories;
import com.codegym.furama.service.CustomerService;
import com.codegym.furama.ultil.WebUtils;
import com.codegym.furama.validator.DateFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    IUserRepositories userRepositories;

    @Autowired
    ICustomerType customerType;

    @ModelAttribute("url")
    public String url(){
        return "/customers";
    }

    @ModelAttribute("nameUser")
    public String nameUser(Principal principal){
        if(principal == null) return null;
        org.springframework.security.core.userdetails.User loginedUserInfo = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUserInfo);
        String nameUser = userRepositories.findByUsername(loginedUserInfo.getUsername()).getEmployee().getEmployeeName();
        return nameUser;
    }

    @GetMapping("")
    public ModelAndView showIndex(@PageableDefault(size = 10) Pageable pageable,
                                  Optional<String> search){
        if(search.isPresent()){
            return new ModelAndView("customer/list","customerList",customerService.findCustomerByCustomerName(search.get(), pageable));
        }
        return new ModelAndView("customer/list","customerList",customerService.findAll(pageable));
    }

    @ModelAttribute
    public List<CustomerType> customerTypes(){
        return customerType.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("customer/create","customer",new Customer());
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("customer", customer);
            return "customer/create";
        }
       customerService.save(customer);
       return "redirect:/customers/";
    }

    @GetMapping("/edit/{id}")
    public String showFormEdit(@PathVariable("id") Integer id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "customer/edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        customerService.remove(id);
        return "redirect:/customers/";
    }
}
