package com.codegym.cart.controller;

import com.codegym.cart.Service.ProductService;
import com.codegym.cart.model.Cart;
import com.codegym.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/products")
@SessionAttributes("carts")
public class ProductController {

    @Autowired
    ProductService productService;

    @ModelAttribute("carts")
    public HashMap<Integer, Cart>cartHashMap(){
        return new HashMap<>();
    }

    @GetMapping("")
    public String showListProduct(Model model, @ModelAttribute("carts") HashMap<Integer, Cart> cartHashMap){
        System.out.println(cartHashMap.keySet());
        model.addAttribute("listProduct", productService.findAll());
        return "product/list";
    }

    @GetMapping("/view/{id}")
    public String viewProduct(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product/view";
    }
}
