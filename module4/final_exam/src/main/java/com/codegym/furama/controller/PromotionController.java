package com.codegym.furama.controller;

import com.codegym.furama.entity.Promotion;
import com.codegym.furama.service.IPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class PromotionController {
    @Autowired
    IPromotionService promotionService;

    @ModelAttribute("url")
    public String url(){
        return "/list";
    }

    @GetMapping("/list")
    public String showList(Model model, Optional<Double> discount, Optional<String> start_date
            ,Optional<String> end_date){
        if(discount.isPresent()){
            model.addAttribute("listPromotion", promotionService.findAllByDiscount(discount.get()));
            return "list";
        } else if(start_date.isPresent()) {
            model.addAttribute("listPromotion", promotionService.findAllByStartDate(start_date.get()));
            return "list";
        } else if(end_date.isPresent()){
            model.addAttribute("listPromotion", promotionService.findAllByEndDate(end_date.get()));
            return "list";
        } else if (discount.isPresent() && start_date.isPresent() && end_date.isPresent()){
            model.addAttribute("listPromotion", promotionService.findAllByDiscountAndStartDateAndEndDate(discount.get()
                    , start_date.get(),end_date.get()));
            return "list";
        }
        model.addAttribute("listPromotion",promotionService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("promotion", new Promotion());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("promotion") Promotion promotion, BindingResult bindingResult, Model model){
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("promotion", promotion);
            return "/create";
        }
        promotionService.save(promotion);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model){
        Promotion promotion = promotionService.findById(id);
        model.addAttribute("promotion",promotion);
        return "edit";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        promotionService.remove(id);
        return "redirect:/list";
    }
}
