package com.codegym.custom_phone_validation.controller;

import com.codegym.custom_phone_validation.model.PhoneNumber;
import com.codegym.custom_phone_validation.validator.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PhoneController {

    @Autowired
    PhoneNumberValidator phoneNumberValidator;

    @GetMapping("/")
    public ModelAndView showForm(){
        return new ModelAndView("index","phoneNumber",new PhoneNumber());
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@Validated @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        phoneNumberValidator.validate(phoneNumber,bindingResult);
        if(bindingResult.hasFieldErrors()){
            return new ModelAndView("index");
        } else {
            return new ModelAndView("result","phoneNumber",phoneNumber);
        }
    }
}
