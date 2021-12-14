package com.codegym.cart.repositories;

import com.codegym.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepositories extends JpaRepository<Cart, Integer> {
}
