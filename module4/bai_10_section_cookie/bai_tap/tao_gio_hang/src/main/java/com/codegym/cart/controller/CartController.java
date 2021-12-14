package com.codegym.cart.controller;

import com.codegym.cart.Service.CartService;
import com.codegym.cart.Service.ProductService;
import com.codegym.cart.model.Cart;
import com.codegym.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    CartService cartService;

    @GetMapping("")
    public String listCart(@SessionAttribute("carts") HashMap<Integer, Cart> cartHashMap, Model model){
        model.addAttribute("carts",cartHashMap);
        model.addAttribute("size",cartHashMap.size());
        model.addAttribute("totalPrice",totalPrice(cartHashMap));
        return "cart/list";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addProductToCart(@PathVariable("id") Integer id,
                                   @SessionAttribute("carts") HashMap<Integer, Cart> cartMap){
        Product product = productService.findById(id);

        if(product!=null){
            if(!cartMap.containsKey(id)){
                Cart cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
                cartMap.put(id,cart);
            } else {
                Cart cart = cartMap.get(id);
                cart.setQuantity(cart.getQuantity() + 1);
                cartMap.put(id,cart);
            }
        }
        return "redirect:/cart/";
    }

    @GetMapping("/remove-from-cart/{id}")
    public String removeFromCart(@PathVariable("id") Integer id,
                                 @SessionAttribute("carts") HashMap<Integer, Cart> cartMap){
        Product product = productService.findById(id);
        if(product!=null) {
            Cart cart = cartMap.get(id);
            if(cart.getQuantity()>0) {
                cart.setProduct(product);
                cart.setQuantity(cart.getQuantity() - 1);
            }
            cartMap.put(id, cart);
        }
        return "redirect:/cart/";
    }


    @PostMapping("/buy")
    public String buy(@SessionAttribute("carts") HashMap<Integer,Cart> cartHashMap, HttpSession session){
        for(Map.Entry<Integer,Cart> list : cartHashMap.entrySet()){
            cartService.save(list.getValue());
        }
        session.setAttribute("carts", new HashMap<Integer, Cart>());
        return "redirect:/cart/history";
    }

    @GetMapping("/history")
    public String historyCart(Model model){
        model.addAttribute("carts", cartService.findAll());
        return "cart/history";
    }

    @GetMapping("/delete/{id}")
    public String deleteCart(@PathVariable("id") Integer id,
                             @SessionAttribute("carts") HashMap<Integer,Cart> cartHashMap){
        cartHashMap.remove(id);
        return "redirect:/cart/";
    }

    public Long totalPrice(HashMap<Integer, Cart> cartHashMap){
        long total = 0;
        for(Map.Entry<Integer,Cart> list : cartHashMap.entrySet()){
            total += list.getValue().getPrice();
        }
        return total;
    }
}
