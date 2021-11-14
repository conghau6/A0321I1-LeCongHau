package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showForm(){
        return "home";
    }

    @PostMapping("/calculate")
    public ModelAndView calculator(@RequestParam("firstNumber") String firstNumber, @RequestParam("secondNumber") String secondNumber,
                                   @RequestParam("operation") String operation){
        ModelAndView modelAndView = new ModelAndView("home");
        int number1 = Integer.parseInt(firstNumber);
        int number2 = Integer.parseInt(secondNumber);
        int result = 0;
        switch (operation) {
            case "Addition(+)":
                result = number1 + number2;
                break;
            case "Subtraction(-)":
                result = number1 - number2;
                break;
            case "Multiplication(+)":
                result = number1 * number2;
                break;
            case "Division(/)":
                result = number1 / number2;
                break;
        }
        modelAndView.addObject("result",result);
        return modelAndView;
    }
}
