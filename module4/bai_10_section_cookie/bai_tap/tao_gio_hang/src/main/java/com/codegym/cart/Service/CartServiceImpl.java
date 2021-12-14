package com.codegym.cart.Service;

import com.codegym.cart.model.Cart;
import com.codegym.cart.repositories.CartRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepositories cartRepositories;

    @Override
    public List<Cart> findAll() {
        return cartRepositories.findAll();
    }

    @Override
    public void delete(Integer id) {
        cartRepositories.deleteById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepositories.save(cart);
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepositories.findById(id).orElse(null);
    }
}
