package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String showForm(){
        return "home";
    }

    @PostMapping("/calculate")
    public String calculator(@RequestParam("firstNumber") String firstNumber, @RequestParam("secondNumber") String secondNumber,
                                   @RequestParam("operation") String operation, Model model){
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
        model.addAttribute("result",result);
        return "home";
    }
}
