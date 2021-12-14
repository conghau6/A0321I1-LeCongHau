package com.codegym.cart.Service;


import com.codegym.cart.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAll();
    void delete(Integer id);
    void save(Cart cart);
    Cart findById(Integer id);
}
